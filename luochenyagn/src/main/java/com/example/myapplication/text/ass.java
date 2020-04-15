package com.example.myapplication.text;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ass {
    //https://gitee.com/ccyy2019/server/raw/master/workbook_test1
     String kk="https://gitee.com/ccyy2019/server/raw/";
    @GET("master/workbook_test1")
    Observable<Data1> mgetDate();
}
