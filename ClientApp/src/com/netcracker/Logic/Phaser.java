package com.netcracker.Logic;

import com.google.gson.Gson;

/**
 * Created by Admin on 3/12/2016.
 */
public class Phaser {
    private String ans;

    public void result(String out){
        Gson transform=new Gson();
        transform.toJson(out);


    }
}
