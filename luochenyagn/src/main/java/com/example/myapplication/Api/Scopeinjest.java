package com.example.myapplication.Api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
//自定义注解
@Scope

@Retention(RetentionPolicy.RUNTIME)
public @interface Scopeinjest {
}
