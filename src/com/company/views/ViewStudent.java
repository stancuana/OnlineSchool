package com.company.views;

import com.company.controller.ControllCourse;
import com.company.controller.ControllEnrolment;
import com.company.controller.ControllStudent;
import com.company.model.Course;
import com.company.model.Enrolment;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private ControllEnrolment controllEnrolment;
    private ControllCourse controllCourse;
    private Scanner scanner;
    private Student student;

    public ViewStudent(Student student){

         this.controllCourse=new ControllCourse();
         this.controllEnrolment=new ControllEnrolment();
         this.scanner=new Scanner(System.in);
         this.student= student;

    }

    public void meniu(){

        System.out.println("Bine ai venit! "+student.getLastName() );
        System.out.println("Apasati tasta 1 pentru a afisa toate cursurile");
        System.out.println("Apasati tasta 2 pentru a vedea toate cursurile la care sunteti inscris");
        System.out.println("Apasati tasta 3 pentru a va inscrie la curs");
        System.out.println("Apasati tasta 4 pentru a va dezabona de la un curs");
        System.out.println("Apasati tasta 5 pentru a va deloga");
        System.out.println("Apasati tasta 6 pentru a afisa numarul de membrii la cursul selectat");
        System.out.println("Apasati tasta 7 pentru a afisa numele studentilor inscrisi la cursul selectat");

    }

    public void play(){

        boolean running=true;

        while(running==true){

            meniu();

            int alegere=Integer.parseInt(scanner.nextLine());

            switch (alegere){

                case 0:
                    running=false;
                    break;
                case 1: controllCourse.afisare();
                break;
                case 2:showAllSubscribes();
                break;
                case 3:subscribe();
                break;
                case 4:unSubscribe();
                break;
                case 5:delogare();
                break;
                case 6: nrMembrii();
                break;
                case 7: nameStudentsSubscribedCourse();

                default:
                    meniu();


            }

        }
    }

    public void subscribe() {


        System.out.println("Introduceti numele cursului la care doriti sa va inscrieti.");


        String courseName = scanner.nextLine();
        Course course=controllCourse.returnareCursByName(courseName);
        Enrolment x=new Enrolment(controllEnrolment.nextAvailableId(),student.getId(),course.getId());
        controllEnrolment.addEnrolment(x);

        System.out.println("V-ati inscris la curs!");

    }

    public void unSubscribe(){

        System.out.println("Introduceti numele cursului de la care doriti sa va dezabonati");

        String courseName=scanner.nextLine();
        Course course=controllCourse.returnareCursByName(courseName);
        Enrolment enrolment=new Enrolment(controllEnrolment.returnIdEnrolmentByIdStudent(student.getId()),student.getId(),course.getId());

        controllEnrolment.deleteEnrolment(enrolment.getId());
        System.out.println("V-ati dezabonat de la cursul"+courseName);

    }

    public void showAllSubscribes(){


        ArrayList<Enrolment> enrolments=controllEnrolment.inscrieriCursuri(this.student.getId());

        for(Enrolment e :enrolments){

            System.out.println("Cursul " +controllCourse.retrunCursById(e.getCourseId()).getCourseName());

        }
    }

    public void delogare(){

        ViewLogin viewLogin=new ViewLogin();

        viewLogin.play();
    }

    public void nrMembrii(){

        System.out.println("Introduceti numele cursului");

        String courseName=scanner.nextLine();

        System.out.println("La cursul "+courseName+" sunt inscrisi "+controllEnrolment.nrMembrii(courseName)+" elevi");

    }

    public void nameStudentsSubscribedCourse(){

        System.out.println("Introduceti numele cursului");

        String courseName=scanner.nextLine();

        System.out.println("Elevii inscrisi la cursul "+courseName+" sunt");
        controllEnrolment.numeEleviInscrisi(courseName);
    }




}
