package ir.pegahtech.saas.client.NegarKhane;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import ir.pegahtech.saas.client.shared.conf.SaaSConfiguration;
import ir.pegahtech.saas.client.shared.conf.SaaSDataProvider;
import ir.pegahtech.saas.client.shared.conf.SaaSPostProcess;
import ir.pegahtech.saas.client.shared.conf.SaaSServiceInfo;
import ir.pegahtech.saas.client.shared.security.RefreshTokenInterceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class NegarKhaneConfiguration implements SaaSConfiguration {
	public static final String serviceRootUrl = "http://api.backtory.ir:48000/ContentServices_WAR/";
	public static final String fileTableId = "1717ad61-e185-4931-867b-7f56bfee3f09";

	private static NegarKhaneConfiguration _instance = new NegarKhaneConfiguration();
	private NegarKhaneConfiguration() { }

	private static SaaSDataProvider dataProvider;
	private static OkHttpClient httpClient;
	private List<SaaSPostProcess> postProcesses = new ArrayList<SaaSPostProcess>();

    @Override
    public SaaSDataProvider getDataProvider() {
        return dataProvider;
    }

	public static void initialize(File cacheDirectory, SaaSDataProvider dp) {
        dataProvider = dp;
        httpClient = new OkHttpClient();
        httpClient.getDispatcher().setMaxRequests(15);
        httpClient.setCache(new Cache(cacheDirectory, 1024 * 1024 * 10));
        httpClient.interceptors().add(new RefreshTokenInterceptor(instance()));	}

	@Override
	public UUID getFileTableId() {
		return fileTableId == null || fileTableId.trim().equals("") ? null : UUID.fromString(fileTableId);
	}

	@Override
	public String getApiBaseUrl() {
		return serviceRootUrl;
	}

    //@Override
    //public String getSecretKey() {
    //    return "";
    //}
    @Override
    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public static NegarKhaneConfiguration instance() { return _instance; }

    @Override
    public UUID getSchemaId() {
        return UUID.fromString("e33a6220-71a0-4237-87d4-119a60459f30");
    }
    @Override
    public String getLoggedInUsername() {
        return dataProvider.keyExists("SAAS_user_name")
                ? dataProvider.load("SAAS_user_name")
                : null;
    }


    @Override
    public String getLoggedInUserId() {
        return dataProvider.keyExists("SAAS_user_id")
                ? dataProvider.load("SAAS_user_id")
                : null;
    }
    @Override
    public void addPostProcess(SaaSPostProcess postProcess) {
        for (SaaSPostProcess process: postProcesses)
            if (process.getProcessId().equals(postProcess.getProcessId()))
                throw new RuntimeException("Duplicate process with same id: " + postProcess.getProcessId());

        postProcesses.add(postProcess);
    }

    @Override
    public void removePostProcess(String processId) {
        Iterator<SaaSPostProcess> iterator = postProcesses.iterator();
        while (iterator.hasNext()) {
            SaaSPostProcess next = iterator.next();
            if (next.getProcessId().equals(processId))
                iterator.remove();
        }
    }

    public void serviceStarted(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceStarted(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }

    public void serviceFailed(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceFailed(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }

    public void serviceSucceed(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceSucceed(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }
}