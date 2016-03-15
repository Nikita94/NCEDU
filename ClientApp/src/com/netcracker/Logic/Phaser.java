package com.netcracker.Logic;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 3/12/2016.
 */
public class Phaser {
    private String ans;
    ArrayList<String> fin=new ArrayList<String>();

//{"dependenciesJars":{"infoAboutDependencies":"All dependencies are met","setDep":[]}}

    public void result(String out){
        Pattern pattern= Pattern.compile("[(\"[a-zA-Z]\\s+\")]+");

        Matcher m = pattern.matcher(out);
            while (m.find()) {
                fin.add(m.group());
               // System.out.println(m.group());
            }
            fin.remove(0);
            fin.remove(0);
            System.out.println(fin.get(0));






    }
}
