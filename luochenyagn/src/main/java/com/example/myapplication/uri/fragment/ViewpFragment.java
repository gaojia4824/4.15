package com.example.myapplication.uri.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//使用Viewpager时加载页面时显示第一个页面时其他的都预加载了，所以让他一次就加载一个页面
//用法直接继承hhFragment
//懒加载·
public abstract class ViewpFragment extends BaseFragment {
   private boolean miok=false;//是否初始化
   private boolean mVon=false;//Fragment是否加载数据了
    //isVisibleToUser 是否对用户可见
    //Viewpager+Fragment情况下会调用setUserVisibleHint

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        miok=true;
        initlay();//加载数据
        return super.onCreateView(inflater, container, savedInstanceState);
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mVon=isVisibleToUser;
        initlay();//加载数据

    }
    protected  void initlay(){
        if(!miok){//没初始化就退出
            return;
        }
        if(getUserVisibleHint()){//可见
            lazyload();//加载数据
            mVon=true;
        }else{
            if(mVon){//加载数据过后，才停止
                stoplazyload();//停止加载
            }
        }

    }
    //结束时
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mVon=false;
        miok=false;
    }

    protected abstract void stoplazyload();

    protected abstract void lazyload();

    ;

//    //Fragment隐藏状态发生变化 true表示隐藏
//    //当执行Fragment的hide() show()是调用onHiddenChanged
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//    }


    @Override
    protected abstract int getfind();

    @Override
    protected abstract void into(View view);

    @Override
    protected abstract BasePresenter initPresenter();
}
