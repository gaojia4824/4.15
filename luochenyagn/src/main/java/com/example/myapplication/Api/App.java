package com.example.myapplication.Api;

import android.app.Application;

public class App extends Application {
   private static App mInstance;
    private Set<Activity> mActivities;
    private static DaggerAppcomponent mDaggerAppCompat;

    @Override

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initInject();
    }

    private void initInject() {
        if (mDaggerAppCompat == null)
            mDaggerAppCompat = (DaggerAppcomponent) DaggerAppcomponent.builder().
                    appModule(new AppModule(this)).build();
    }

    public static DaggerAppcomponent daggerAppComponent() {
        return mDaggerAppCompat;
    }


    public static synchronized App getInstance() {
        return mInstance;
    }


    public void addActivity(Activity act) {
        if (mActivities == null)
            mActivities = new HashSet<Activity>();
        mActivities.add(act);
    }

    public void removeActivity() {
        if (mActivities != null) {
            for (Activity act : mActivities) {
                act.finish();
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }



}
