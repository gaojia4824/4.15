package com.example.myapplication.module;

import android.os.Parcel;
import android.provider.Telephony;
import android.text.TextUtils;
import android.widget.RelativeLayout;

import com.bumptech.glide.load.data.DataFetcher;
import com.example.myapplication.Api.ApiService;
import com.example.myapplication.Api.App;
import com.example.myapplication.Api.IDataCallBack;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class RxOperateImpl<T> {
    @Inject
    ApiService mApiService;

    public RxOperateImpl() {
        //将apiService注入到RxOperateImpl里面
        DaggerRxOperateComponent.builder().
                appComponent(App.daggerAppComponent()).build().
                inject(this);
    }

    /**
     * @param url          get请求的URL地址
     * @param dataCallBack 结果回调(实际上是接口回调)
     * @param <T>          接口回调获取的值
     */
    public <T> void requestData(String url, IDataCallBack<T> dataCallBack) {
        RxSchedulersOperator.retryWhenOperator
                (mApiService.requestData(url)).
                subscribe(getObserver(dataCallBack));
    }


    /**
     * @param url          get请求的url地址
     * @param params       get请求的参数
     * @param dataCallBack get请求的结果回调
     * @param <T>
     */
    public <T> void requestData(String url, Map<String, T> params, IDataCallBack<T> dataCallBack) {
        if (params == null || params.size() == 0)
            requestData(url, dataCallBack);
        else
            RxSchedulersOperator.retryWhenOperator
                    (mApiService.requestData(url, params)).
                    subscribe(getObserver(dataCallBack));
    }


    /**
     * 没有参数的post请求
     *
     * @param url
     * @param dataCallBack
     * @param <T>
     */
    public <T> void requestFormData(String url, IDataCallBack<T> dataCallBack) {
        RxSchedulersOperator.retryWhenOperator(mApiService.xiazaiFile1(url)).
                subscribe(getObserver(dataCallBack));

    }


    /**
     * 有参数的post请求
     *
     * @param url
     * @param params
     * @param dataCallBack
     * @param <T>
     */
    public <T> void requestFormData(String url, Map<String, T> params, IDataCallBack<T> dataCallBack) {
        if (params == null || params.size() == 0)
            requestFormData(url, dataCallBack);
        else
            RxSchedulersOperator.retryWhenOperator(mApiService.xiazaiFile1(url, params)).
                    subscribe(getObserver(dataCallBack));
    }


    /**
     * 有请求头并且有参数的post请求
     *
     * @param url
     * @param headers
     * @param params
     * @param dataCallBack
     * @param <T>
     */
    public <T> void requestFormData(String url, Map<String, T> headers, Map<String, T> params, IDataCallBack<T> dataCallBack) {
        if (headers == null || headers.size() == 0)  //请求头为空 但是参数不为空
            requestFormData(url, params, dataCallBack);
//        else if (params == null || params.size() == 0) {   //TODO参数为空但是请求头不为空
//
//        }
        else if ((headers == null || headers.size() == 0) && // 请求头和参数都为空
                (params == null || params.size() == 0)) {
            requestFormData(url, dataCallBack);
        } else
            //请求头和参数都不为空
            RxSchedulersOperator.retryWhenOperator(mApiService.requestFormData(url, headers, params)).
                    subscribe(getObserver(dataCallBack));
    }


    /**
     * 抽取出结果回调的方法
     *
     * @param dataCallBack
     * @param <T>
     * @return
     */
    private <T> RxObserver<T> getObserver(IDataCallBack<T> dataCallBack) {
        return new RxObserver<T>(dataCallBack) {
            @Override
            public void onSubscribe(Disposable d) {
                if (dataCallBack != null)
                    dataCallBack.onResponseDisposable(d);

            }

            @Override
            public void onNext(T t) {
                if (dataCallBack != null)
                    dataCallBack.onStateSucess(t);
            }
        };
    }
    //多个文件夹上传
    public<T> void uploadSingleFile(String url,IDataCallBack<T> l,File... str){
        HashMap<String, RequestBody> map = new HashMap<>();
        for(File file1 :str){
            ResponseBody body = ResponseBody.create(MediaType.parse("multipart/form-data"), file1);
            map.put("file:filename="+file1.toString(),body)


        }
        RxSchedulersOperator.retryWhenOperator(mApiService.uploadMultipleFiles(url,map))
        .subscribe(getObserver(DataCallback));

    }
    //单个文件上传
    public void uploadSingleFile(String url, String str, File file, IDataCallBack<T> l){

        if(TextUtils.isEmpty(str)){
            uploadSingleFile(url,file,l);
        }else{
            RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part part= MultipartBody.Part.createFormData("hh",file.getName(),body);
            ResponseBody body1 = ResponseBody.create(MediaType.parse("multipart/form-data"), str);
            RxSchedulersOperator.retryWhenOperator(mApiService.dan(url, Package,part)
            ).subscribe(getObserver(DataCallback));
        }
    }

    //多个文件夹上传1
    public<T> void uploadSingleFile(IDataCallBack<T> l,String url,File... str){
        if(str !=null&&str.length>0){
            MultipartBody.Part[] part1 = new MultipartBody.Part(str.length);
            for (int i=0;i<str.length;i++){
                File file = str[i];
                ResponseBody body = ResponseBody.create(MediaType.parse("multipart/form-data"));
                MultipartBody.Part part=MultipartBody.Part.createFormData("file",file.getName());
                part1[i]=file;
            }

        }
        RxSchedulersOperator.retryWhenOperator(mApiService.dan(url, l, Parcel
        ).subscribe(getObserver(DataCallback));

    }
    //多文件+多个键值对上传
    public <T> void uploadStrFiles(String url, Map<String, String> params, IDataCallBack<T> dataCallBack,
                                   File... files) {
        if (files != null && files.length > 0) {

            if (params == null || params.size() == 0) {
                //不带参数的多文件上传
                uploadMultipleFiles(url, dataCallBack, files);
            } else {
                FormBody.Builder builder = new FormBody.Builder();
                for (int i = 0; i < params.size(); i++) {
                    Set<String> keys = params.keySet();
                    for (String key : keys) {
                        String value = params.get(key);
                        //上传多个键值对
                        builder.add(key, value);
                    }
                }

                Map<String, RequestBody> filesMap = new HashMap<String, RequestBody>();
                for (File file : files) {
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    //上传多个文件
                    filesMap.put("file;fileName=" + file.getName(), requestBody);
                }
                RxSchedulersOperator.retryWhenOperator(mApiService.uploadStrFiles(url, builder.build(), filesMap)).
                        subscribe(getObserver(dataCallBack));

            }
        }
    }


}
