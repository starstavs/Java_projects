package edu.tekwill.akademy.person;

public class Person {
    String name;
    String soname;
    int age;

    public String getName(String soname) {
        this.soname = soname;
        return (soname);
    }

    public void printName(String name) {

        System.out.println("Hallo " + soname + " " + name);
    }
}
