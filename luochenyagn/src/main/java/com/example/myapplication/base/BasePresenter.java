package com.example.myapplication.base;

public abstract class BasePresenter<V extends BaseView>  {
   public V Mview;
    public BasePresenter(){
        into();
    }

    protected abstract void into();

    public  void viewbs(V tBaseActivity){
        this.Mview=tBaseActivity;
    }
}
