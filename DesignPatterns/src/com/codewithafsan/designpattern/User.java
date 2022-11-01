package com.codewithafsan.designpattern;

public class User {
    public String name;

    public User(String name){
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hi, this is "+name);
    }

}
