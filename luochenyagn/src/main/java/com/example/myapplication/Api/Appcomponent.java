package com.example.myapplication.Api;

import com.example.myapplication.module.AppModule;
import com.example.myapplication.presenter.Mainpresenter;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = AppModule.class)
public interface Appcomponent {
       //SharedPreferences shar();
       void injiet(Mainpresenter v);
}
