package com.company.controller;

import com.company.model.Course;
import com.company.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllStudent {

    private ArrayList<Student> studenti;

    // CRUD

    public void load(){

        try {

            File file=new File("C:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Studenti");

            Scanner scanner=new Scanner(file);

            while (scanner.hasNextLine()){

                String text=scanner.nextLine();
                Student x=new Student(text);

                this.studenti.add(x);

            }



        }catch (Exception a){

            a.printStackTrace();
        }

    }

    public ControllStudent(){

        this.studenti=new ArrayList<>();

        load();


    }

    public void addStudent(Student student){

        this.studenti.add(student);
    }

    public void afisare(){

        for(int i=0; i<studenti.size();i++){

            System.out.println(studenti.get(i).descriere());
        }
    }

    public int pozStudent(int studentId){

        int poz=-1;

        for(int i=0; i<studenti.size();i++){

            if(studenti.get(i).getId()==studentId){

                poz=i;
            }
        }
        return  poz;
    }

    public void updateStudent(Student x){

        int poz=pozStudent(x.getId());

        if(poz!=-1){

            this.studenti.get(poz).setAge(x.getAge());
            this.studenti.get(poz).setEmail(x.getEmail());
            this.studenti.get(poz).setPassword(x.getPassword());
        }
    }

    public void deleteStudent(int studentId){

        int poz=pozStudent(studentId);

        if(poz!=-1){
            studenti.remove(poz);
        }
    }

    public int nextAvailableId(){

        if(studenti.size()>0){

            return studenti.get(studenti.size()-1).getId()+1;
        }

        return 1;
    }

    // functie ce primeste email-ul si parola si returneaza parola

    public Student logare(String email, String parola){


        for(int i=0; i<studenti.size();i++) {

            if (studenti.get(i).getPassword().equals(parola) && studenti.get(i).getEmail().equals(email)) {

                return studenti.get(i);
            }
        }

        return null;
    }

    private  String toSave(){

        String text="";


        for(Student student:studenti){

            text+=student.formatToSave()+"\n";
        }


        return  text;

    }

    public  void save() {
        try {

            File file = new File("c:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Studenti");


            FileWriter writer = new FileWriter(file);

            PrintWriter printWriter= new PrintWriter(writer);
            printWriter.print(this.toSave());

            printWriter.close();

        }catch (Exception e){


            e.printStackTrace();
        }


    }

    // functie care primeste id-ul studentului si returmeaza numele

    public String numeStudent(int id){


        for(int i=0; i<studenti.size();i++){

            if(studenti.get(i).getId()==id){

                return studenti.get(i).getFirstName();
            }
        }
        return null;
    }

    public int nrStudenti(){

        int contor=0;

        for(int i=0; i<studenti.size();i++){

            contor++;
        }

        return contor;
    }

    public Student returnStudentById(int studentId){

        for(int i=0; i<studenti.size();i++){

            if(studenti.get(i).getId()==studentId){

                return studenti.get(i);
            }
        }

        return null;
    }








}
