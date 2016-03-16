package com.netcracker.Logic;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.Files.isRegularFile;

/**
 * Created by Admin on 2/26/2016.
 */
public class CurrentPath {
    private Path address;

    public void setManner(){
        Scanner arrow;
        arrow =new Scanner(System.in);
        System.out.println("To continue choose option.\n" +
                "1.Search in program folder\n" +
                "2.Search in upper folder\n" +
                "3.Search in custom folder\n" +
                "4. ../testJars\n" +
                "0. Exit");
        int n=arrow.nextInt();

        switch (n){
            case 1: this.address=this.getPathToWork();
                break;
            case 2: this.address=this.getUpperPathToWork();
                break;
            case 3:
                this.getCustomPath();
                break;
            case 4:
                this.SpecialPath1();
                break;

            case 0:return;
            default:this.address=this.getPathToWork();
                break;
        }
    }

    private void getCustomPath() {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String path = null;
            while ((path = br.readLine()) != null) {
                if (path.equalsIgnoreCase("quite")) {
                    break;//how to avoid it????
                }
                this.address = Paths.get(path);
            }
        } catch (IOException ioe) {
            System.out.println("  ");
        }
    }

    private void SpecialPath1(){
        //this.address=Paths.get("E:\\Windows\\Documents\\NEC\\ClientServer\\ClientServer\\testJars");
        Scanner scan=new Scanner(System.in);
        System.out.println("1. Correct TestJars\n2.Wrong TestJars\n3.No dependencies");
        int key=scan.nextInt();
        switch ( key) {
            case 1:
                this.address = Paths.get("E:\\Windows\\Documents\\NEC\\ClientServer\\ClientServer\\testJars");
                break;
            case 2:
                //this code shows how to go to another folder. To go to any folder
                //we should add visitor here.
                this.address=Paths.get("");
                this.address=address.toAbsolutePath();
                String tmp;
                tmp=address.toString();
                tmp=tmp.concat("\\ClientApp\\testJars");
                address=Paths.get(tmp);
                break;
            case 3:
                this.address = Paths.get("E:\\Windows\\Documents\\NEC\\ClientServer\\ClientServer\\testJars1");
                break;

        }


    }
    private Path getPathToWork() {
        this.address = Paths.get("");
        this.address.toAbsolutePath();
        this.address = this.address.toAbsolutePath();
        return address;
    }
    private Path getUpperPathToWork(){
        address = Paths.get("");
        address=address.toAbsolutePath().getParent();
        return address;

    }

    public Path getAddress() {
        return address;
    }

}

  /* public void getFilesList(Path workDir) {

        try (DirectoryStream<java.nio.file.Path> dirStream = newDirectoryStream(workDir))

        {
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




