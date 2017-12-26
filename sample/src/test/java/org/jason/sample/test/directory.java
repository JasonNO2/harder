package org.jason.sample.test;

public class directory {
    public static void main (String[] args){
        //相对路径
        System.out.println(System.getProperty("user.dir"));
        System.out.println(directory.class.getResource("").getPath());
        System.out.println(directory.class.getResource("/").getPath());

    }
}
