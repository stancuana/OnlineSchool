package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test public void descriereConstructorAtributeTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        assertEquals("ID: 1\n" +
                "First name: Stancu\n" +
                "Last name: Ana\n" +
                "Age: 19\n" +
                "Email: anamaria@gmail.com\n",student.descriere());

    }

    @Test public void descriereConstructorTextTest(){

        Student student=new Student("1,Stancu,Ana,19,anamaria@gmail.com,ggg");

        assertEquals("ID: 1\n" +
                "First name: Stancu\n" +
                "Last name: Ana\n" +
                "Age: 19\n" +
                "Email: anamaria@gmail.com\n",student.descriere());



    }



    @Test public void setPlusGetIdTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setId(3);

        assertEquals(3,student.getId());
    }

    @Test public void setPlusGetFirstNameTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setFirstName("Ganea");

        assertEquals("Ganea",student.getFirstName());
    }

    @Test public void setPlusGetLastNameTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setLastName("Ioana");

        assertEquals("Ioana",student.getLastName());
    }

    @Test public void setPlusGetAgeTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setAge(22);

        assertEquals(22,student.getAge());
    }

    @Test public void setPlusGetEmailTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setEmail("ganeaioana@gmail.com");

        assertEquals("ganeaioana@gmail.com",student.getEmail());
    }

    @Test public void setPlusGetPasswordTest(){

        Student student=new Student(1,"Stancu","Ana",19,"anamaria@gmail.com","ggg");

        student.setPassword("RRRRR");

        assertEquals("RRRRR",student.getPassword());
    }


    @Test public void formatToSave(){

        Student student=new Student("1,Stancu,Ana,19,anamaria@gmail.com,ggg");

        assertEquals("1,Stancu,Ana,19,anamaria@gmail.com,ggg",student.formatToSave());



    }







}