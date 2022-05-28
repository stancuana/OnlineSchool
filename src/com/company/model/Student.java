package com.company.model;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;


    public Student(int id, String firstName, String lastName, int age,String email, String password){

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.email=email;
        this.password=password;
    }

    public Student(String atribute){

        this.id=Integer.parseInt(atribute.split(",")[0]);
        this.firstName=atribute.split(",")[1];
        this.lastName=atribute.split(",")[2];
        this.age=Integer.parseInt(atribute.split(",")[3]);
        this.email=atribute.split(",")[4];
        this.password=atribute.split(",")[5];
    }


    public void setFirstName(String nume){

        this.firstName=nume;
    }

    public String getFirstName(){

        return this.firstName;
    }

    public void setLastName(String prenume){

        this.lastName=prenume;
    }

    public String getLastName(){

        return this.lastName;
    }

    public void setId(int id){

        this.id=id;
    }

    public int getId(){

        return this.id;
    }

    public void setAge(int varsta){

        this.age=varsta;
    }

    public int getAge(){

        return this.age;
    }

    public void setEmail(String email){

        this.email=email;
    }

    public String getEmail(){

        return this.email;
    }

    public void setPassword(String password){

        this.password=password;
    }

    public String getPassword(){

        return this.password;
    }

    public String descriere(){

        String text="ID: "+getId()+"\n";
        text+="First name: "+getFirstName()+"\n";
        text+="Last name: "+getLastName()+"\n";
        text+="Age: "+getAge()+"\n";
        text+="Email: "+getEmail()+"\n";

        return text;
    }

    public String formatToSave(){

       return  this.id+","+ this.getFirstName()+","+this.getLastName()+","+this.getAge()+","+this.getEmail()+","+this.getPassword();

    }



}
