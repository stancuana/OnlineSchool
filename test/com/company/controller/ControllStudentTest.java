package com.company.controller;

import com.company.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllStudentTest {

    @Test public void nextAvailableIdTest(){

        ControllStudent controllStudent=new ControllStudent();
        assertEquals(controllStudent.nrStudenti()+1,controllStudent.nextAvailableId());

    }

    @Test public void nrStudentiTest(){

        ControllStudent controllStudent=new ControllStudent();

        assertEquals(controllStudent.nextAvailableId()-1,controllStudent.nrStudenti());
    }

    @Test public void returnStudentById(){

        ControllStudent controllStudent=new ControllStudent();

        assertEquals("ID: 1\n" +
                "First name: Stancu\n" +
                "Last name: Ana\n" +
                "Age: 1\n" +
                "Email: hbeardon0@artisteer.com\n",controllStudent.returnStudentById(1).descriere());
    }

    @Test public void addStudentTest(){

        ControllStudent controllStudent=new ControllStudent();
        int nrInitialStudenti=controllStudent.nrStudenti();

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        controllStudent.addStudent(student);


        assertEquals(nrInitialStudenti+1,controllStudent.nrStudenti());
    }

    @Test public void pozStudentTest(){

        ControllStudent controllStudent=new ControllStudent();

        assertEquals(4,controllStudent.pozStudent(5));
    }

    @Test public void updateStudentTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        ControllStudent controllStudent=new ControllStudent();

        controllStudent.updateStudent(student);

        assertEquals(19,controllStudent.returnStudentById(1).getAge());
        assertEquals("anamaria@gmail.com",controllStudent.returnStudentById(1).getEmail());
        assertEquals("ggg",controllStudent.returnStudentById(1).getPassword());

    }

    @Test public void deleteStudentTest(){

        ControllStudent controllStudent=new ControllStudent();

        int nrInitialCursuri=controllStudent.nrStudenti();

        controllStudent.deleteStudent(2);

        assertEquals(nrInitialCursuri-1,controllStudent.nrStudenti());
    }

    @Test public void logareTest(){

        ControllStudent controllStudent=new ControllStudent();

        assertEquals("ID: 1\n" +
                "First name: Stancu\n" +
                "Last name: Ana\n" +
                "Age: 1\n" +
                "Email: hbeardon0@artisteer.com\n",controllStudent.logare("hbeardon0@artisteer.com","vhpEAi").descriere());
    }

    @Test public void saveTest(){

        ControllStudent controllStudent=new ControllStudent();

        Student student=new Student(controllStudent.nextAvailableId(),"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        int nrInitialCursuri=controllStudent.nrStudenti();

        controllStudent.addStudent(student);

        controllStudent.save();

        assertEquals(nrInitialCursuri+1,controllStudent.nrStudenti());
    }

    @Test public void numeStudentTest(){

        ControllStudent controllStudent=new ControllStudent();

        assertEquals("Stancu",controllStudent.numeStudent(1));
    }





}