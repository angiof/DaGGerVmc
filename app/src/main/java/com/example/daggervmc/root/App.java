package com.example.daggervmc.root;

import android.app.Application;

import com.example.daggervmc.login.LoginModule;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}


