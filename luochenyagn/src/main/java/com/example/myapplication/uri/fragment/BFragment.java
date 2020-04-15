package com.example.myapplication.uri.fragment;

import android.util.Log;
import android.view.View;

import com.example.myapplication.presenter.MainApravity;
import com.example.myapplication.R;

public class BFragment extends ViewpFragment {







    //extends BaseFragment<MainApravity> implements MainAView

    private int i1;

    public void da(int i) {
        this.i1=i;
    }

    @Override
    protected void stoplazyload() {
        switch (i1){
            case 0:
                Log.i("TAG", "AFragment停止了");
                return;
            case 1:
                Log.i("TAG", "BFragment停止了");
                return;
        }
    }

    @Override
    protected void lazyload() {
        //在这开始
        //mPresenter.kk();
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
    protected void into(View view) {

    }

    @Override
    protected MainApravity initPresenter() {
        return new MainApravity();
    }
}
