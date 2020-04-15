package com.example.myapplication.Api;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Module
public class okmanager {//单例
    @Provides
    @Singleton
    public OkHttpClient .Builder ok() {
       return new OkHttpClient.Builder()
               .connectTimeout(6, TimeUnit.SECONDS)
               //
               .readTimeout(6,TimeUnit.SECONDS);

               //让ok支持Https请求
//               .sslSocketFactory()
    }
    @Provides
    @Singleton
    public OkHttpClient provideinter(){
            return ok().build();
    }


//    private static volatile okmanager okmanager;
//
//    public okmanager() {
//        initHttp();
//    }
//
//    private void initHttp() {
//
//    }
//    public static okmanager getOkmanager(){
//        if(okmanager==null){
//            synchronized (com.example.myapplication.Api.okmanager.class){
//                if(okmanager==null){
//                    synchronized (com.example.myapplication.Api.okmanager.class){
//                        okmanager = new okmanager();
//                    }
//                }
//            }
//        }
//        return okmanager;
//    }
}
