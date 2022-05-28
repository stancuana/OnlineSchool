package com.company.model;

public class Enrolment {


    private  int id;
    private int studentId;
    private int courseId;


    public Enrolment(int id, int studentId, int courseId){

        this.id=id;
        this.studentId=studentId;
        this.courseId=courseId;
    }

    public Enrolment(String atribute){

        this.id=Integer.parseInt(atribute.split(",")[0]);
        this.studentId=Integer.parseInt(atribute.split(",")[1]);
        this.courseId=Integer.parseInt(atribute.split(",")[2]);
    }


    public void setId(int id){

        this.id=id;
    }

    public int getId(){

        return this.id;
    }

    public void setStudentId(int studentId){

        this.studentId=studentId;
    }

    public int getStudentId(){

        return this.studentId;
    }

    public void setCourseId(int courseId){

        this.courseId=courseId;
    }

    public int getCourseId(){

        return this.courseId;
    }


    public String descriere(){

        String text="ID: "+getId()+"\n";
        text+="Student ID: "+getStudentId()+"\n";
        text+="Course ID: "+getCourseId()+"\n";

        return text;
    }

    public String formatToSave(){

        return this.getId()+","+this.getStudentId()+","+this.getCourseId();
    }


}
