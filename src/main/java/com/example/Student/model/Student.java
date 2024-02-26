package com.example.Student.model;



public class Student {
    
    public String id;
    public String name;
    public int age;
    public String adhar;
    public String university;

    public Student(String id, String name, int age, String adhar, String university){
        this.id = id;
        this.age = age;
        this.name = name;
        this.adhar = adhar;
        this.university = university;
    }
}
