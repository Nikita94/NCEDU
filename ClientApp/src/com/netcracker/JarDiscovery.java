package com.netcracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;


import static java.lang.System.out;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.newDirectoryStream;

/**
 * Created by Admin on 2/26/2016.
 */
public class JarDiscovery {
    private Path address;
    private ArrayList<Path> jarLoc;
    private ArrayList<String> fileList;


    public JarDiscovery(Path add, ArrayList<Path> files) {
        address = add;
        jarLoc = files;
        check();


    }



    void check() {
        System.out.println(address);
        for (int i = 0; i < jarLoc.size(); i++) {
            System.out.println(jarLoc.get(i));
        }

    }

    public void getManifestInfo(){
        try {


            for (int i = 0; i < jarLoc.size(); i++) {


                File file = new File(jarLoc.get(i).toString());
                InputStream input = new FileInputStream(file);
                JarInputStream in = new JarInputStream(input);
                Manifest manifest =in.getManifest();
                Attributes infoJ=manifest.getMainAttributes();

                System.out.println(infoJ.getValue("Version"));


            }
        }catch (IOException e) {
            System.out.println("oooopss!");
        }
        }


//        try (JarInputStream<Path> dirStream = newDirectoryStream(folderAddress))
//
//        {
//            for (Path path : dirStream) {
//                if (isRegularFile(path)) {
//                    out.print("  ");
//                    out.println(path.getFileName());
//                }
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//
//
//    }


}
//
//
//    }//All is ok. Great!

//    void fillLoc(){
//        try (DirectoryStream<Path> dirStream = newDirectoryStream(address))
//
//        {
//            for (Path path : dirStream) {
//                int i=0;
//
//                if (isRegularFile(path)) {
//
//                    if (fileList.contains(path.getFileName().toString())) {
//                        //jarLoc.add(path.toAbsolutePath());
//                        //System.out.println(jarLoc.size());
//                        //System.out.println(jarLoc.get(i));
//                        i++;
//                    }
//                }
//
//
//                }
//
//
//        } catch (IOException e) {
//            System.err.println(e);
//        }

//    }
