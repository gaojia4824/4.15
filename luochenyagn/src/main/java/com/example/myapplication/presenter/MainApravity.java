package com.example.myapplication.presenter;

import com.example.myapplication.module.DataModele;
import com.example.myapplication.View.MainAView;
import com.example.myapplication.base.BasePresenter;

public class MainApravity extends BasePresenter<MainAView> {

    private DataModele mModele;

    @Override
    protected void into() {
       mModele = new DataModele();
    }

    public void ll() {

   }
}
