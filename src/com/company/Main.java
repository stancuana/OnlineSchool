package com.company;

import com.company.controller.ControllCourse;
import com.company.controller.ControllEnrolment;
import com.company.controller.ControllStudent;
import com.company.model.Course;
import com.company.model.Enrolment;
import com.company.model.Student;
import com.company.views.ViewLogin;
import com.company.views.ViewStudent;

public class Main {

    public static void main(String[] args) {

//        ControllEnrolment x=new ControllEnrolment();
//
//        //System.out.println(x.inscrieriCursuri(3));;
//        ViewLogin a=new ViewLogin();
//
//        a.play();

        ControllStudent controllStudent=new ControllStudent();

//        Student student=new Student(31,"RRR","MMM",12,"dbdshdk@gmail.com","sdfush");
//
//
//        controllStudent.addStudent(student);

//        controllStudent.save();


      //controllStudent.afisare();


     // Enrolment enrolment=new Enrolment(1,2,5);

      //  System.out.println(enrolment.formatToSave());;


        //Student student=new Student(32,"ggg","uuu",21,"jgg","jhgbgg");

        //ControllStudent controllStudent1=new ControllStudent();

        //controllStudent1.addStudent(student);
        //controllStudent1.save();

       /* Course course=new Course(31,"mmm", "mmmm");

        ControllCourse controllCourse=new ControllCourse();

        controllCourse.addCourse(course);
        controllCourse.save();




        Enrolment enrolment=new Enrolment(11,2,4);
        ControllEnrolment controllEnrolment=new ControllEnrolment();

        controllEnrolment.addEnrolment(enrolment);
        controllEnrolment.save();




        ViewLogin viewLogin=new ViewLogin();

        viewLogin.play();





        ControllEnrolment controllEnrolment=new ControllEnrolment();

        System.out.println(controllEnrolment.nrMembrii("EQUUS CABALLUS SKIN"));




        */


        Student student=new Student(19,"Linoel","Kynton",19,"lkyntoni@biblegateway.com","ydwg8o");

        //ViewStudent viewStudent=new ViewStudent(student);

        //viewStudent.play();





        ControllEnrolment controllEnrolment=new ControllEnrolment();

        //controllEnrolment.numeEleviInscrisi("EQUUS CABALLUS SKIN");

        ControllCourse controllCourse=new ControllCourse();
        controllCourse.afisare();


        System.out.println(controllEnrolment.returnEnrolmentById(1));
    }
}
