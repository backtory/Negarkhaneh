package ir.pegahtech.saas.client.NegarKhane.services;

import ir.pegahtech.saas.client.NegarKhane.NegarKhaneConfiguration;
import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.*;
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
 * Class MobileUsersService helps you access the user functionalities. 
 * You'll be able to access some utilities for them in this service
 */

public class MobileUsersService {

    public  void list(final ListRequest request,  final ServiceCallback<MobileUserListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<MobileUserListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<MobileUserListResponse> callBackTemp = new ServiceCallback<MobileUserListResponse>() {
            @Override
            public void success(final MobileUserListResponse object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
                    MobileUserListResponse.class,
                    callBackTemp
                );
	}
    public  MobileUserListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  MobileUserListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       MobileUserListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserListResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "list", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void deleteMobileUser(final DeleteRequest request,  final ServiceCallback<DeleteResponse> callback) {
        deleteMobileUser(request, callback, null);
    }
   public  void deleteMobileUser(final DeleteRequest request,  final ServiceCallback<DeleteResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<DeleteResponse> callBackTemp = new ServiceCallback<DeleteResponse>() {
            @Override
            public void success(final DeleteResponse object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.DELETE,
                    pathParams,
                    postData,
                    cacheBuilder,
                    DeleteResponse.class,
                    callBackTemp
                );
	}
    public  DeleteResponse deleteMobileUserSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteMobileUserSync(request, null);
    }

   public  DeleteResponse deleteMobileUserSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       DeleteResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.DELETE,
                    pathParams,
                    postData,
                    cacheBuilder,
                    DeleteResponse.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "deleteMobileUser", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void update(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
    public  InsertUpdateResponse updateSync(final MobileUserEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final MobileUserEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/content/f9299f32-6dc0-44d8-a524-7a96c53faa39/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "update", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void signUp(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        signUp(request, callback, null);
    }
   public  void signUp(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/user/f9299f32-6dc0-44d8-a524-7a96c53faa39/register";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
    public  InsertUpdateResponse signUpSync(final MobileUserEntity request) throws NetworkFailureException {
        return signUpSync(request, null);
    }

   public  InsertUpdateResponse signUpSync(final MobileUserEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/user/f9299f32-6dc0-44d8-a524-7a96c53faa39/register";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
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
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "signUp", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void logIn(final LogInRequest request,  final ServiceCallback<TokenObject> callback) {
        logIn(request, callback, null);
    }
   public  void logIn(final LogInRequest request,  final ServiceCallback<TokenObject> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "oauth/token?grant_type=password&client_id=saas-trusted-client&username={username}&password={password}&schema_id=e33a6220-71a0-4237-87d4-119a60459f30";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("username", request.getUsername());
			pathParams.put("password", request.getPassword());



        ServiceCallback<TokenObject> callBackTemp = new ServiceCallback<TokenObject>() {
            @Override
            public void success(final TokenObject object) {
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_access_token",object.getAccess_token());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_refresh_token",object.getRefresh_token());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_token_type",object.getToken_type());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_expires_in",object.getExpires_in());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_scope",object.getScope());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_user_id",object.getUserId());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_token_time",DateUtility.getCurrentTime());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_user_name",request.getUsername());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_password",request.getPassword());
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    TokenObject.class,
                    callBackTemp
                );
	}
    public  TokenObject logInSync(final LogInRequest request) throws NetworkFailureException {
        return logInSync(request, null);
    }

   public  TokenObject logInSync(final LogInRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "oauth/token?grant_type=password&client_id=saas-trusted-client&username={username}&password={password}&schema_id=e33a6220-71a0-4237-87d4-119a60459f30";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("username", request.getUsername());
			pathParams.put("password", request.getPassword());



       TokenObject object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    TokenObject.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }

			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_access_token",object.getAccess_token());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_refresh_token",object.getRefresh_token());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_token_type",object.getToken_type());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_expires_in",object.getExpires_in());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_scope",object.getScope());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_user_id",object.getUserId());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_token_time",DateUtility.getCurrentTime());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_user_name",request.getUsername());
			NegarKhaneConfiguration.instance().getDataProvider().save("SAAS_password",request.getPassword());

       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "logIn", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
    public  void userInfo(final UserInfo request,  final ServiceCallback<MobileUserEntity> callback) {
        userInfo(request, callback, null);
    }
   public  void userInfo(final UserInfo request,  final ServiceCallback<MobileUserEntity> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/user/f9299f32-6dc0-44d8-a524-7a96c53faa39/userInfo?username={username}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;




        ServiceCallback<MobileUserEntity> callBackTemp = new ServiceCallback<MobileUserEntity>() {
            @Override
            public void success(final MobileUserEntity object) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NegarKhaneConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserEntity.class,
                    callBackTemp
                );
	}
    public  MobileUserEntity userInfoSync(final UserInfo request) throws NetworkFailureException {
        return userInfoSync(request, null);
    }

   public  MobileUserEntity userInfoSync(final UserInfo request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NegarKhaneConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NegarKhaneConfiguration.serviceRootUrl + "api/user/f9299f32-6dc0-44d8-a524-7a96c53faa39/userInfo?username={username}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NegarKhaneConfiguration.instance().serviceStarted(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;




       MobileUserEntity object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NegarKhaneConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserEntity.class
            );
        } catch (IOException e) {
           NegarKhaneConfiguration.instance().serviceFailed(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
            throw new NetworkFailureException(e);
        }


       NegarKhaneConfiguration.instance().serviceSucceed(true, "MobileUser", "userInfo", url, "f9299f32-6dc0-44d8-a524-7a96c53faa39", "e33a6220-71a0-4237-87d4-119a60459f30");
       return object;
    }
}
