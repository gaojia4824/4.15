package com.example.myapplication.Api;

import android.database.Observable;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService<T> {
    @GET
    Observable<ResponseBody> resp(@Url String str);
    @GET
    Observable<ResponseBody> resp(@Url String str, @QueryMap Map<String,T> bstr);
    //下载文件
    @GET
    @Streaming
    Observable<ResponseBody> xiazai(@Url String str);
    //无参post请求
    @POST
    Observable<ResponseBody> xiazaiFile(@Url String str);
    //有参post请求
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> xiazaiFile1(@Url String str,@HeaderMap Map<String,T> hea,Map<String,T> file);
    //上传json传
    Observable<ResponseBody> json(@Url String url, @Body ResponseBody body);
    //多个json上传
    Observable<ResponseBody> jsons(@Url String url, @Body ResponseBody body,@HeaderMap Map<String,T> hea);
    //单个文件上传
    Observable<ResponseBody> dan(@Url String url, @Part MultipartBody.Part part);
    //多个文件上传
    //
    @POST
    @Multipart
    Observable<ResponseBody> uploadMultipleFiles(@Url String url, @Part MultipartBody.Part... part);

    <T> Object uploadMultipleFiles(String url, Map<String,T> str);
}
