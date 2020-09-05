package com.example.daggervmc.login;

public interface LoginActivityMVP {


    interface View {


        String getLastNAme();

        String getFirstName();

        void showUserNotAvalible();

        void showUserInputError();

        void showUSerSaved();

        void setFirtsname(String firtsname);

        void setLastName(String lastName);


    }

    interface Presenter {
        void setView(LoginActivityMVP.View view);

        void LoginButtonClicked();
        void getCurrentUser();


    }



    interface Model {

        void createdUser(String firsName,String Lastname);
        Users getUsers();
    }
}
