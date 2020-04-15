package com.example.myapplication.presenter;

import android.util.Log;

import com.example.myapplication.View.MianView;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.text.As;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class Mainpresenter extends BasePresenter<MianView> {
   @Inject
    OkHttpClient mOkHttpClient;
    //拦截器
    public Mainpresenter() {
//      App.daggerAppComponent().injiet(this);
    }

    private BaseModel mModel;

    public void kk() {
        Log.i("AS", "kk: "+mOkHttpClient.toString());
    mModel.jie(new As() {
        @Override
        public void ok(String s) {
            if(Mview!=null){
                if(s!=null){
                    Mview.setDate(s);
                }
            }
        }
    });
    }

    @Override
    protected void into() {
        mModel = new BaseModel();
    }
}
