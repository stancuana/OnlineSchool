package com.company.controller;

import com.company.model.Course;
import com.company.model.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllCourse {

    private ArrayList<Course> cursurie;

    public void load(){

        try {

            File file=new File("c:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Cursuri.txt");

            Scanner scanner=new Scanner(file);

            while (scanner.hasNextLine()){

                String text=scanner.nextLine();
                Course x=new Course(text);

                this.cursurie.add(x);
            }



        }catch (Exception a){

            a.printStackTrace();
        }
    }

    public ControllCourse(){
        this.cursurie=new ArrayList<>();
        load();
    }

    public void addCourse(Course course) {

        this.cursurie.add(course);
    }

    public void afisare(){

        for(int i=0; i<cursurie.size();i++){

            System.out.println(cursurie.get(i).descriere());
        }
    }

    public int pozCource(int id){

        int poz=-1;

        for(int i=0; i<cursurie.size();i++){

            if(cursurie.get(i).getId()==id){

                poz=i;
            }
        }
        return poz;
    }

    public void updateCource(Course x){

        int poz=pozCource(x.getId());

        if(poz!=-1){

            this.cursurie.get(poz).setCourseName(x.getCourseName());
            this.cursurie.get(poz).setCourseDepartment(x.getCourseDepartment());
        }
    }

    public void deleteCource(int id){
        int poz=pozCource(id);
        if(poz!=-1){
            cursurie.remove(poz);
        }
    }

    // functie care primeste numele cursului si returneaza cursul

    public Course returnareCursByName(String courseName){

        for(int i=0; i<cursurie.size();i++){
            if(cursurie.get(i).getCourseName().equals(courseName)){

                return cursurie.get(i);
            }
        }
        return null;
    }

    // functie ce returneaza cursul dupa ID

    public Course retrunCursById(int courceId){


        for(int i=0; i<cursurie.size();i++){

            if(cursurie.get(i).getId()==courceId){

              return  cursurie.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        String text="";
        for(Course course:cursurie){
            text+=course.formatToSave()+"\n";
        }
        return text;
    }

    public void save(){

        try{

            File file=new File("c:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Cursuri.txt");

            FileWriter writer=new FileWriter(file);

            PrintWriter printWriter=new PrintWriter(writer);
            printWriter.print(this.toSave());

            printWriter.close();

        }catch (Exception x){

            x.printStackTrace();
        }
    }

    // functie care numara cursurile dintr-o lista

    public int nrCursuri(){

        int contor=0;

        for(int i=0; i<cursurie.size();i++){

            contor++;
        }

        return contor;
    }

    public int nextAvailableId(){


        if(cursurie.size()>0){
            return cursurie.get(cursurie.size()-1).getId()+1;
        }

        return 0;
    }

}
