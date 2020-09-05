package com.example.daggervmc.login;

import androidx.annotation.Nullable;

public class LoginAcitivyPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginAcitivyPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void LoginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastNAme().trim().equals("")) {
                view.showUserInputError();
            } else {
                model.createdUser(view.getFirstName().trim(), view.getLastNAme().trim());
                view.showUSerSaved();
            }
        }
    }


    @Override
    public void getCurrentUser() {
        Users user = model.getUsers();

        if (user == null) {
            if (view != null) {
                view.showUserNotAvalible();
            }
        } else {
            if (view != null) {
                view.setFirtsname(user.getFirtsName());
                view.setLastName(user.getLastname());
            }
        }
    }
}
