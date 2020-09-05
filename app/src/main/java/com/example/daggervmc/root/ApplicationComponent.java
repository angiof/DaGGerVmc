package com.example.daggervmc.root;

import com.example.daggervmc.login.LoginModule;
import com.example.daggervmc.login.MainActivityView;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import twit.TwitModule;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, TwitModule.class})
public interface ApplicationComponent {

    void inject(MainActivityView target);



}
