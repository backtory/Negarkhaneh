package com.sharifcup.negarkhaneh;

import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.MobileUserEntity;
import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.MobileUserListResponse;
import ir.pegahtech.saas.client.NegarKhane.services.MobileUsersService;
import ir.pegahtech.saas.client.shared.builder.Operator;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.FilterNode;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

import java.util.UUID;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;

/**
 * Created by hamid on 6/7/15.
 *
 */
public class UserInfo {
    public final static String USER_INFO_SHARED_PREF = "userinfo";
    public final static String USER_INFO_KEY = "userkey";

    private static UserInfo _instane;

    private String userId = null;

    private boolean lock = false;

    private UserInfo(){

    }

    public static UserInfo getInstance(){
        if(_instane == null){
            _instane = new UserInfo();
        }
        return _instane;
    }

    public void getUserId(final Context context, final UserCallback callback){
        if(this.getSavedUserId(context) != null){
            callback.done(this.getSavedUserId(context));
        }else if(!lock){
            lock = true;
            final MobileUserEntity user = new MobileUserEntity();
            user.setIMEI1(getIMEI(context));
            user.setUsername(UUID.randomUUID().toString());
            user.setPassword(UUID.randomUUID().toString());
            QueryObject query = new QueryObject();
            query.setWhereClause(new FilterNode(new FilterNode(MobileUserEntity.COLUMN_IMEI1),
                    Operator.EQ.toString(), new FilterNode(getIMEI(context))));
            final ListRequest request = new ListRequest(0, 1, true, false, query);
            new MobileUsersService().list(request, new ServiceCallback<MobileUserListResponse>() {
                @Override
                public void success(MobileUserListResponse result) {
                    if(result != null && result.getData() != null && result.getData().size() > 0 ){
                        MobileUserEntity res = result.getData().get(0);
                        saveUserIdToSharedPref(context, res.getGuid());
                        callback.done(res.getGuid());
                        lock = false;
                    }else{
                        new MobileUsersService().signUp(user, new ServiceCallback<InsertUpdateResponse>() {
                            @Override
                            public void success(InsertUpdateResponse result) {
                                if(result != null){
                                    saveUserIdToSharedPref(context, result.getGuid());
                                    callback.done(result.getGuid());
                                }else{
                                    callback.done("");
                                }
                                lock = false;
                            }

                            @Override
                            public void fail(int resultCode) {
                                callback.done("");
                                lock = false;
                            }
                        });
                    }
                }

                @Override
                public void fail(int resultCode) {
                    callback.done("");
                    lock = false;
                }
            });
        }else{
            callback.done("");
        }
    }

    public static String getIMEI(Context context){
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    public String getUserIdFromSharedPref(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(USER_INFO_SHARED_PREF,
                Context.MODE_PRIVATE);
        return sharedPref.getString(USER_INFO_KEY, null);
    }

    public String getSavedUserId(Context context){
        if(this.userId == null){
            this.userId = getUserIdFromSharedPref(context);
        }
        return this.userId;
    }

    public void saveUserIdToSharedPref(Context context, String userId){
        this.userId = userId;
        SharedPreferences sharedPref = context.getSharedPreferences(USER_INFO_SHARED_PREF,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_INFO_KEY, userId);
        editor.apply();
    }
    public interface UserCallback {
        public void done(String userid);
    }
}
