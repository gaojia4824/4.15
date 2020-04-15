package com.example.myapplication.uri.fragment;

import android.view.View;
import android.widget.Toast;

import com.example.myapplication.presenter.MainApravity;
import com.example.myapplication.R;
import com.example.myapplication.View.MainAView;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.text.Data1;
import com.example.myapplication.uri.adapter.DataAdaption;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Retrofit;

public class AFragment extends BaseFragment<MainApravity> implements MainAView {
    private int i1;
    private RecyclerView mRe;
    private ArrayList<Data1.DataBean.CatalogBean> mList;
    private DataAdaption mAdaption;
    private Retrofit mRf;

    public void da(int i) {
        this.i1=i;
    }
    @Override
    protected int getfind() {
        switch (i1){
            case 0:
                return R.layout.kk;
            case 1:
                return R.layout.kk1;
            case 2:
                return R.layout.kk;

        }
        return 0;

    }
 


    @Override
    protected MainApravity initPresenter() {
        return new MainApravity();
    }
    @Override
    protected void into(View view) {
        switch (i1){
            case 0:
                mPresenter.ll();

                break;
        }
    }
    @Override
    public void setDate(Object ok) {
        switch (i1){

        }
    }

    @Override
    public void setStr(String on) {
        Toast.makeText(getContext(),on,Toast.LENGTH_SHORT).show();
    }



    }
