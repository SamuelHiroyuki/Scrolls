package com.example.vitor.scrolsfinal.Classes;

import java.io.Serializable;

public class Image implements Serializable {
    private int _IdImage;
    private String Url;
    private int UserId;


    public Image(){
        _IdImage = 0;
        Url = null;
        UserId = 0;

    }

    public Image(int id, String url, int uid, int appid){
        _IdImage = id;
        Url = url;
        UserId = uid;

    }

    public int get_IdImage() {
        return _IdImage;
    }

    public String getUrl() {
        return Url;
    }

    public int getUserId() {
        return UserId;
    }



}