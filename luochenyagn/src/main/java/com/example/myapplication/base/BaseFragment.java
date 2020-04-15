package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    public T mPresenter;
    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getfind(), null);
        mBind = ButterKnife.bind(this, view);
        mPresenter=initPresenter();
        if(mPresenter!=null){
            mPresenter.viewbs(this);
        }
        into(view);
        return view;
    }

    protected abstract int getfind();

    protected abstract void into(View view);

    protected abstract T initPresenter();

}