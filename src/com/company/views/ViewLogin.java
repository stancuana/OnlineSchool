package com.company.views;

import com.company.controller.ControllCourse;
import com.company.controller.ControllEnrolment;
import com.company.controller.ControllStudent;
import com.company.model.Student;

import java.util.Scanner;

public class ViewLogin {

    private Scanner scanner;
    private ControllStudent controllStudent;
    private ControllCourse controllCourse;
    private ControllEnrolment controllEnrolment;
    private Student student;


    public ViewLogin(){

        this.scanner=new Scanner(System.in);
        this.controllCourse=new ControllCourse();
        this.controllEnrolment=new ControllEnrolment();
        this.controllStudent=new ControllStudent();
        this.student=new Student(3,"Julia","Stebbings",3,"jstebbings2@plala.or.jp","z4RJwBfQiBj");
    }

    public void meniu(){

        System.out.println("Apasati tasta 0 pentru a va inregistra");
        System.out.println("Apasati tasta 1 pentru a va loga");

    }

    public void play(){


        boolean running=true;

        while(running==true){

            meniu();

            int alegere=Integer.parseInt(scanner.nextLine());

            switch (alegere){

                case 0: inregistrare();
                break;
                case 1: logare();
                break;

                default:
                meniu();

            }
        }
    }

    public void logare(){

        System.out.println("Introduceti adresa de email");

        String email=scanner.nextLine();

        System.out.println("Introduceti parola");

        String parola=scanner.nextLine();

        Student student=controllStudent.logare(email,parola);

        if(student!=null){

             ViewStudent viewStudent = new ViewStudent(student);
             viewStudent.play();

        }else{


            System.out.println("credentiale incorecte");
        }
    }

    public void inregistrare(){

        System.out.println("Introduceti numele");

        String nume=scanner.nextLine();

        System.out.println("Intruduceti prenumele ");

        String prenume=scanner.nextLine();

        System.out.println("Introduceti varsta");

        int varsta=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti adresa de email");

        String email=scanner.nextLine();

        System.out.println("Introduceti parola");

        String parola=scanner.nextLine();



        Student x=new Student(controllStudent.nextAvailableId(),nume,prenume,varsta,email,parola);

        controllStudent.addStudent(x);
        controllStudent.save();

        ViewStudent viewStudent=new ViewStudent(x);
        viewStudent.play();

    }




}
