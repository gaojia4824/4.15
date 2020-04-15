package com.example.myapplication.text;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class BaseApp extends Application {
    public static BaseApp sBaseApp;


    @Override
    public void onCreate() {
        super.onCreate();

        MyCrashHandler mycrashHandler = new MyCrashHandler();
        Thread.setDefaultUncaughtExceptionHandler(mycrashHandler);


        sBaseApp = this;
        Context context = sBaseApp.getApplicationContext();

    }


    public static Resources getRes(){
        return sBaseApp.getResources();
    }
}
