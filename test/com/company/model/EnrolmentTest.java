package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnrolmentTest {


    @Test public void descriereConstructorAtributeTest(){

        Enrolment enrolment=new Enrolment(1,1,4);

        assertEquals("ID: 1\n" +
                "Student ID: 1\n" +
                "Course ID: 4\n",enrolment.descriere());

    }

    @Test public void descriereConstructorTextTest(){

        Enrolment enrolment=new Enrolment("1,1,4");

        assertEquals("ID: 1\n" +
                "Student ID: 1\n" +
                "Course ID: 4\n",enrolment.descriere());



    }


    @Test public void setIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);
        enrolment.setId(3);

        assertEquals("ID: 3\n" +
                "Student ID: 1\n" +
                "Course ID: 4\n",enrolment.descriere());
    }

    @Test public void setStudentIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);
        enrolment.setStudentId(77);

        assertEquals("ID: 1\n" +
                "Student ID: 77\n" +
                "Course ID: 4\n",enrolment.descriere());
    }

    @Test public void setCourseIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);
        enrolment.setCourseId(44);

        assertEquals("ID: 1\n" +
                "Student ID: 1\n" +
                "Course ID: 44\n",enrolment.descriere());
    }


    @Test public void getIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);
        assertEquals(1,enrolment.getId());

    }

    @Test public void getStudentIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);

        assertEquals(1,enrolment.getStudentId());
    }

    @Test public void getCourseIdTest(){

        Enrolment enrolment=new Enrolment(1,1,4);

        assertEquals(4,enrolment.getCourseId());

    }


    @Test public void formatToSaveTest(){

        Enrolment enrolment=new Enrolment("1,1,4");

        assertEquals("1,1,4",enrolment.formatToSave());


    }



}