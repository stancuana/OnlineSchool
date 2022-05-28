package com.company.model;

public class Course {

    private int id;
    private String courseName;
    private String courseDepartment;

    public Course(String atribute){

        this.id=Integer.parseInt(atribute.split(",")[0]);
        this.courseName=atribute.split(",")[1];
        this.courseDepartment=atribute.split(",")[2];
    }

    public Course(int id, String courseName, String courseDepartment){

        this.id=id;
        this.courseName=courseName;
        this.courseDepartment=courseDepartment;
    }


    public void setId(int id){

        this.id=id;
    }

    public int getId(){

        return this.id;
    }

    public void setCourseName(String courseName){

        this.courseName=courseName;
    }

    public String getCourseName(){

        return this.courseName;
    }

    public void setCourseDepartment(String courseDepartment){

        this.courseDepartment=courseDepartment;
    }

    public String getCourseDepartment(){

        return this.courseDepartment;
    }


    public String descriere(){

        String text="Course ID: "+getId()+"\n";
        text+="Course name: "+getCourseName()+"\n";
        text+="Course department: "+getCourseDepartment()+"\n";

        return text;
    }

    public String formatToSave(){
        return this.getId()+","+this.getCourseName()+","+this.courseDepartment;
    }


}
