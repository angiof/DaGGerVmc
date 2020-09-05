package com.example.daggervmc;

import com.example.daggervmc.login.LoginAcitivyPresenter;
import com.example.daggervmc.login.LoginActivityMVP;
import com.example.daggervmc.login.LoginActivityModel;
import com.example.daggervmc.login.MemoryRespository;
import com.example.daggervmc.login.Users;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import twit.TwitModule;

import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class UnitPresenterTest {
    LoginAcitivyPresenter loginAcitivyPresenter;
    Users users;
    LoginActivityMVP.Model Mokectmodel;
    LoginActivityMVP.View Mokectview;

    @Before
    public void init() {
        Mokectmodel = mock(LoginActivityMVP.Model.class);
        Mokectview = mock(LoginActivityMVP.View.class);
        loginAcitivyPresenter = new LoginAcitivyPresenter(Mokectmodel);
        loginAcitivyPresenter.setView(Mokectview);
        MemoryRespository memoryRespository;
        users = new Users("Manolo", "Escobar");
        //   when(Mokectview.getFirstName()).thenReturn("antonio");
        // when(Mokectview.getLastNAme()).thenReturn("BAderas");
    }

    @Test
    public void noExistInteractionsWiththen() {
        loginAcitivyPresenter.getCurrentUser();
        // verifyZeroInteractions(Mokectview);
        verify(Mokectview, never()).showUserNotAvalible();
    }

    @Test
    public void cargandoUsuariosDelRepositorioValidandoSiSonPresetes() {
        when(Mokectmodel.getUsers()).thenReturn(users);
        loginAcitivyPresenter.getCurrentUser();
        //comprobamos la interacion con el  modelo  de datos
        verify(Mokectmodel, times(1)).getUsers();
        //compravamso la iteracion con la vista
        verify(Mokectview, times(1)).setFirtsname("Manolo");
        verify(Mokectview, never()).showUserNotAvalible();

    }

    @Test
    public void showUseerrorIsUserIsNull() {
        when(Mokectmodel.getUsers()).thenReturn(null);
        loginAcitivyPresenter.getCurrentUser();
        //comprovamso iteracion con el modelo
        verify(Mokectmodel, times(1)).getUsers();
        //compravamso la iteracion con la vista
        verify(Mokectview, never()).setFirtsname("Manolo");
        verify(Mokectview, never()).setLastName("Escobar");
        verify(Mokectview, times(1)).showUserNotAvalible();
    }

    @Test
    public void errorMessageISFieldIsEmpaty() {
        when(Mokectview.getLastNAme()).thenReturn("");
        loginAcitivyPresenter.LoginButtonClicked();
        //iteracion con la vista


    }

    public void testerarretrofit(){
        TwitModule twitModule;


    }

}
