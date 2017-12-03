package com.loongstone.commonlibrary.base.app;

import android.content.Context;

/**
 * 内存缓存
 *
 * @author loongstone
 * @date 2017/12/1 14:59
 */
public class AppCache {
    /**
     * 应用实例
     */
    private Context context;
    private volatile static AppCache instance;
    private String token;
    private String userId ;
    private String userName ;
    private String icon;

    private AppCache() {
    }

    public static AppCache getInstance() {
        if (null == instance) {
            synchronized (AppCache.class) {
                if (instance == null) {
                    instance = new AppCache();
                }
            }
        }
        return instance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
