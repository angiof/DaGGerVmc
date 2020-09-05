package com.example.daggervmc.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRespository respository;

    public LoginActivityModel(LoginRespository respository) {
        this.respository = respository;
    }

    @Override
    public void createdUser(String firsName, String Lastname) {
        respository.saveUser(new Users(firsName,Lastname));

    }

    @Override
    public Users getUsers() {
        return respository.getuser();
    }
}
