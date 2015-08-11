package ir.pegahtech.saas.client.NegarKhane.services;

import ir.pegahtech.saas.client.NegarKhane.NegarKhaneConfiguration;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.*;
import ir.pegahtech.saas.client.shared.http.CacheControlBuilder;
import ir.pegahtech.saas.client.shared.enums.*;
import ir.pegahtech.saas.client.shared.security.*;
import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.shared.builder.*;
import ir.pegahtech.saas.client.shared.file.*;
import ir.pegahtech.saas.client.shared.http.HttpConnectionUtility;
import ir.pegahtech.saas.client.shared.http.HttpMethods;
import ir.pegahtech.saas.client.shared.http.NetworkFailureException;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.threading.AndroidRunnable;

import java.io.IOException;
import java.util.*;

//import com.google.gson.reflect.TypeToken;

/**
 * Class ImagesesService helps you retrieve list of Imageses, 
 * Create new Images, 
 * Change Info of a(n) Images 
 * or Delete one of them. If you enable tag or category support for this class, 
 * You'll be able to access some utilities for them in this service
 */

public class ImagesesService {

    public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, Class<T> cls) {
        customList(request, callback, null, cls);
    }
   public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, CacheControlBuilder cacheBuilder , Class<T> cls) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<T> callBackTemp = new ServiceCallback<T>() {
            @Override
            public void success(final T object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    cls,
                    callBackTemp
                );
	}
    public <T> T customListSync(final ListRequest request, Class<T> cls) throws NetworkFailureException {
        return customListSync(request, null, cls);
    }

   public <T> T customListSync(final ListRequest request,  CacheControlBuilder cacheBuilder, Class<T> cls)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       T object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    cls
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "customList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void list(final ListRequest request,  final ServiceCallback<ImagesListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<ImagesListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<ImagesListResponse> callBackTemp = new ServiceCallback<ImagesListResponse>() {
            @Override
            public void success(final ImagesListResponse object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    ImagesListResponse.class,
                    callBackTemp
                );
	}
    public  ImagesListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  ImagesListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       ImagesListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    ImagesListResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "list", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void create(final ImagesEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        create(request, callback, null);
    }
   public  void create(final ImagesEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentCreateBuilder().build(request);


        ServiceCallback<InsertUpdateResponse> callBackTemp = new ServiceCallback<InsertUpdateResponse>() {
            @Override
            public void success(final InsertUpdateResponse object) {
			new ContentCreateBuilder().update(request,object);
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateResponse createSync(final ImagesEntity request) throws NetworkFailureException {
        return createSync(request, null);
    }

   public  InsertUpdateResponse createSync(final ImagesEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentCreateBuilder().build(request);


       InsertUpdateResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "create", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void createList(final List<ImagesEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        createList(request, callback, null);
    }
   public  void createList(final List<ImagesEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentCreateBuilder().buildList(request);


        ServiceCallback<InsertUpdateListResponse> callBackTemp = new ServiceCallback<InsertUpdateListResponse>() {
            @Override
            public void success(final InsertUpdateListResponse object) {
			new ContentCreateBuilder().updateAll(request,object);
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateListResponse createListSync(final List<ImagesEntity> request) throws NetworkFailureException {
        return createListSync(request, null);
    }

   public  InsertUpdateListResponse createListSync(final List<ImagesEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentCreateBuilder().buildList(request);


       InsertUpdateListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().updateAll(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "createList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void updateList(final List<ImagesEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        updateList(request, callback, null);
    }
   public  void updateList(final List<ImagesEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentUpdateBuilder().buildList(request);


        ServiceCallback<InsertUpdateListResponse> callBackTemp = new ServiceCallback<InsertUpdateListResponse>() {
            @Override
            public void success(final InsertUpdateListResponse object) {
			new ContentUpdateBuilder().updateAll(request,object);
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateListResponse updateListSync(final List<ImagesEntity> request) throws NetworkFailureException {
        return updateListSync(request, null);
    }

   public  InsertUpdateListResponse updateListSync(final List<ImagesEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentUpdateBuilder().buildList(request);


       InsertUpdateListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().updateAll(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "updateList", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void update(final ImagesEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final ImagesEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentUpdateBuilder().build(request);


        ServiceCallback<InsertUpdateResponse> callBackTemp = new ServiceCallback<InsertUpdateResponse>() {
            @Override
            public void success(final InsertUpdateResponse object) {
			new ContentUpdateBuilder().update(request,object);
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateResponse updateSync(final ImagesEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final ImagesEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentUpdateBuilder().build(request);


       InsertUpdateResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "update", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void deleteImages(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        deleteImages(request, callback, null);
    }
   public  void deleteImages(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<QueryOutputNumber> callBackTemp = new ServiceCallback<QueryOutputNumber>() {
            @Override
            public void success(final QueryOutputNumber object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class,
                    callBackTemp
                );
	}
    public  QueryOutputNumber deleteImagesSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteImagesSync(request, null);
    }

   public  QueryOutputNumber deleteImagesSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       QueryOutputNumber object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "deleteImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void restoreImages(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        restoreImages(request, callback, null);
    }
   public  void restoreImages(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<QueryOutputNumber> callBackTemp = new ServiceCallback<QueryOutputNumber>() {
            @Override
            public void success(final QueryOutputNumber object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class,
                    callBackTemp
                );
	}
    public  QueryOutputNumber restoreImagesSync(final RestoreRequest request) throws NetworkFailureException {
        return restoreImagesSync(request, null);
    }

   public  QueryOutputNumber restoreImagesSync(final RestoreRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/14471f7b-2a7b-44e3-ad24-19299f78ca90/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       QueryOutputNumber object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "Images", "restoreImages", url, "14471f7b-2a7b-44e3-ad24-19299f78ca90", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
}
