package com.example.vitor.scrolsfinal.Classes;

import java.io.Serializable;

public class User implements Serializable {
    private int _IdUser;

    private String PassUser;
    private String NameUser;

    private String EmailUser;





    public User(){
        this._IdUser = 0;


        this.EmailUser = null;



        this.NameUser=null;
        this.PassUser=null;


    }
    public User(int id, String emailUser, String nameUser, String passUser){
        this._IdUser = id;


        this.EmailUser = emailUser;



        this.NameUser = nameUser;
        this.PassUser = passUser;


    }

    public int get_IdUser() {
        return _IdUser;
    }










    public String getPassUser() {
        return PassUser;
    }


    public String getNameUser() {
        return NameUser;
    }

    public String getEmailUser() {
        return EmailUser;
    }
}