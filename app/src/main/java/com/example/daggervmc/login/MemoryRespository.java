package com.example.daggervmc.login;

public class MemoryRespository implements LoginRespository {

    private Users users;

    @Override
    public void saveUser(Users users) {
        if (users==null){
            users=getuser();
        }
        this.users=users;
    }

    @Override
    public Users getuser() {
        if (users == null) {
            users = new Users("antionio", "banderas");
            users.setId(0);
            return users;
        } else {
            return users;
        }
    }


}
