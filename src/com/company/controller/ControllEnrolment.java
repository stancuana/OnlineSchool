package com.company.controller;

import com.company.model.Course;
import com.company.model.Enrolment;
import com.company.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//CRUD -->CREATE READ UPDATE DELETE

public class ControllEnrolment {

    private ArrayList<Enrolment> enrolmenturi;

    public void load(){

        try{

            File file=new File("c:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Enrolmenturi");

            Scanner scanner=new Scanner(file);

            while (scanner.hasNextLine()) {

                String text = scanner.nextLine();
                Enrolment a=new Enrolment(text);

                this.enrolmenturi.add(a);

            }
        }catch (Exception a){

                a.printStackTrace();
        }
    }

    public ControllEnrolment(){

        this.enrolmenturi=new ArrayList<>();

        load();
    }

    public void addEnrolment(Enrolment enrolment){

        this.enrolmenturi.add(enrolment);
    }

    public void afisare(){

        for(int i=0; i<enrolmenturi.size();i++){

            System.out.println(enrolmenturi.get(i).descriere());
        }
    }

    public int pozEnrolment(int enrolmentId){

        int poz=-1;

        for(int i=0; i<enrolmenturi.size();i++){

            if(enrolmenturi.get(i).getId()==enrolmentId){

                poz=i;
            }
        }
        return poz;
    }

    public void updateAtributeEnrolment(Enrolment x){

        int poz=pozEnrolment(x.getId());

        if(poz!=-1){

            this.enrolmenturi.get(poz).setStudentId(x.getStudentId());
            this.enrolmenturi.get(poz).setCourseId(x.getCourseId());

        }
    }

    public Enrolment returnEnrolmentById(int id){

        for(int i=0; i<enrolmenturi.size();i++){

            if(enrolmenturi.get(i).getId()==id){

                return enrolmenturi.get(i);
            }
        }
        return null;
    }

    public void deleteEnrolment(int id){

        int poz=pozEnrolment(id);

        if(poz!=-1){

            enrolmenturi.remove(poz);

        }


    }

    public int nrEnrolmenturi(){

        int contor=0;

        for(int i=0; i<enrolmenturi.size();i++){

            contor++;
        }

        return contor;
    }

    public int nextAvailableId(){

        if(enrolmenturi.size()>0){
            return enrolmenturi.get(enrolmenturi.size()-1).getId()+1;
        }
        return 1;
    }

    // functie care arata cursurile la care este inscris un elev

    public ArrayList<Enrolment> inscrieriCursuri(int studentId){

         ArrayList<Enrolment>enrolments= new ArrayList<>();

        for(int i=0; i<enrolmenturi.size();i++){

            if(enrolmenturi.get(i).getStudentId()==studentId){
                enrolments.add(enrolmenturi.get(i));
            }
        }

        return enrolments;

    }

    public int nrInscrieriCursuri(int studentId){

        ArrayList lista=inscrieriCursuri(studentId);

        int contor=0;

        for(int i=0; i<lista.size();i++){

            contor++;
        }

        return contor;
    }

    // functie ce returneaza id-ul enrolmentului dupa Id-ul cursului

    public int returnIdEnrolmentByIdStudent(int studentId){

        for(int i=0; i<enrolmenturi.size();i++){

            if(enrolmenturi.get(i).getStudentId()==studentId){

                return enrolmenturi.get(i).getId();
            }

        }
        return 0;
    }

    private String toSave(){

        String text="";

        for(Enrolment enrolment: enrolmenturi){

            text+=enrolment.formatToSave()+"\n";
        }
        return text;

    }

    public void save(){


        try{

            File file=new File("c:\\mycode\\JavaBasics\\OOP\\incapsulare\\OnlineSchool\\src\\com\\company\\resources\\Enrolmenturi");

            FileWriter writer=new FileWriter(file);

            PrintWriter printWriter=new PrintWriter(writer);

            printWriter.print(this.toSave());

            printWriter.close();


        }catch (Exception e){

            e.printStackTrace();
        }

    }

    // functie care returneaza numarul de membrii la un curs

    public int nrMembrii(String courseName){

        ControllCourse controllCourse=new ControllCourse();

        int contor=0;

        for(int i=0; i<enrolmenturi.size();i++){

            if(enrolmenturi.get(i).getCourseId()==controllCourse.returnareCursByName(courseName).getId()){

                contor++;

            }
        }
        return contor;
    }

    // functie care returneaza numele elevilor inscrisi la cursul selectat

    public ArrayList numeEleviInscrisi(String numeCourse){

        ControllCourse controllCourse=new ControllCourse();
        ControllStudent controllStudent=new ControllStudent();
        ArrayList nume=new ArrayList();
        for(int i=0; i<enrolmenturi.size();i++){
            if(enrolmenturi.get(i).getCourseId()==controllCourse.returnareCursByName(numeCourse).getId()){

                nume.add(controllStudent.numeStudent(enrolmenturi.get(i).getStudentId()));
            }
        }
        return nume;
    }









}
