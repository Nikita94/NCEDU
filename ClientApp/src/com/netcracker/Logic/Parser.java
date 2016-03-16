package com.netcracker.Logic;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 3/12/2016.
 */
public class Parser {
    ArrayList<String> fin=new ArrayList<String>();

//{"dependenciesJars":{"infoAboutDependencies":"All dependencies are met","setDep":[]}}





    public void result(String out){
        Pattern pattern= Pattern.compile("[(\"[a-zA-Z]\\s+[0-9]+.+\")]+");

        Matcher m = pattern.matcher(out);
            while (m.find()) {
                fin.add(m.group());
               // System.out.println(m.group());
            }
        for(int i=0;i<fin.size();i++){
            String tmp=fin.get(i).replaceAll("\"","");
            fin.set(i,tmp);
        }





            System.out.println(fin.get(2));
        if(fin.size()>4){
            System.out.println("you need this JAR's to work:");

            for(int i=0;i<fin.size()-4;i++){
                System.out.println(fin.get(4+i));
            }
        }








    }
}
