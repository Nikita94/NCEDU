package com.netcracker;

import com.netcracker.Client.Client;
import com.netcracker.Logic.CurrentPath;
import com.netcracker.Logic.FilesInclude;
import com.netcracker.Logic.JarDiscovery;
import com.netcracker.Logic.Parser;

import java.io.IOException;
import java.lang.String;

import static java.nio.file.Files.newDirectoryStream;

class Main {


    public static void main(String[] args) {
        CurrentPath way; //determine work folder
        FilesInclude fileList;
        JarDiscovery jar;
        System.out.println("Hello, this is a jar dependency checker.");//Console app
        way=new CurrentPath();
        way.setManner();



        System.out.print("You're in ");
        System.out.println(way.getAddress().getFileName().toString()); //check your work folder
        System.out.println("Let's begin to work.");
        try{Thread.sleep(1000);
        }catch (InterruptedException e){}
        System.out.print("Folder scan...\n");

        fileList=new FilesInclude(way.getAddress());
        //fileList.printFilesList();

        jar = new JarDiscovery(way.getAddress(), fileList.getJarAddressList());
        jar.jarExplore();

        try {

            Client sendJson = new Client("127.0.0.1", 5555, jar.getVerList());
            String out=sendJson.connection(jar.getVerList());
            Parser ans=new Parser();
            ans.resultGson(out);
            ans.result(out);

        }catch (IOException e){
            System.out.println("No such array");
        }












    }


}






        /*
        ArrayList<String> fileList;

        String vl=null;
        File fl=null;
        try {

             fl = new File("");
            vl = fl.getName();
            System.out.println("file name"+vl);
        }catch (Exception e)
                {
                 e.printStackTrace();
                }
        }
        */

        /*
        for(int i=0; i<fList.length; i++)
        {
            //����� ������ ����� � ����� isFile() ����� isDirectory()
            if(fList[i].isFile())
                System.out.println(String.valueOf(i) + " - " + fList[i].getName());
        }
        */


/* format
1 String FileName(space)v.(version)(4 numbers with dots)
Cernel v10.15.15.1000
 */


 /*
        Path address =Paths.get("");
        address.toAbsolutePath();


        ArrayList files[];
        try (DirectoryStream<Path> dirStream = newDirectoryStream(address)) {
            for (Path path : dirStream) {
                if (isRegularFile(path)) {
                    out.print("  ");
                    out.println(path.getFileName());

                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    */


