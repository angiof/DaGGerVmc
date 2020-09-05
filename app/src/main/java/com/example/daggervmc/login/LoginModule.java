package com.example.daggervmc.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {


    @Provides
    public LoginActivityMVP.Presenter provaiderLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginAcitivyPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provaiderLoginAcitivyModel(LoginRespository respository) {
        return new LoginActivityModel(respository);

    }

    @Provides
    public LoginRespository provaiderloginRespository() {
        return new MemoryRespository();//cambair aqui se queremos cambiar por un login en memoria e cloud
    }


}
