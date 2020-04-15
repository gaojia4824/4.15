package com.example.myapplication.Api;

import dagger.Component;
@Scopeinjest//自定义注解
@Component(dependencies =Appcomponent.class)
public interface incepatrcomponent<T> {
    void inject(T heafer);
}
