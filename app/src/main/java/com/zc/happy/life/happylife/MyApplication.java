package com.zc.happy.life.happylife;

import android.app.Application;
import android.content.Context;


public class MyApplication extends Application {

    public static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        try {
            super.attachBaseContext(base);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

}
