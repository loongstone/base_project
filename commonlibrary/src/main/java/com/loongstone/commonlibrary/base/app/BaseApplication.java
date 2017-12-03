package com.loongstone.commonlibrary.base.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;


/**
 * @author loongstone
 * @date 2017/12/1 14:35
 */
public class BaseApplication extends Application {

    public static BaseApplication baseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Application getaApplication(){
        return baseApplication;
    }
    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

}
