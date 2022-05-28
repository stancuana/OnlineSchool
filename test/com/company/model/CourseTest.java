package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test public void descriereConstructorAtributeTest(){

        Course course=new Course(1,"HHHH","KKKK");

       assertEquals("Course ID: 1\n" +
               "Course name: HHHH\n" +
               "Course department: KKKK\n",course.descriere());

    }

    @Test public void descriereConstructorTextTest(){

        Course course=new Course("1,HHHH,KKKK");

        assertEquals("Course ID: 1\n" +
                "Course name: HHHH\n" +
                "Course department: KKKK\n",course.descriere());
    }


    @Test public void setCourseIdTest(){

        Course course=new Course(1,"HHHH","KKKK");

        course.setId(3);

        assertEquals("Course ID: 3\n" +
                "Course name: HHHH\n" +
                "Course department: KKKK\n",course.descriere());
    }

    @Test public void setCourseNameTest(){

        Course course=new Course(1,"HHHH","KKKK");

        course.setCourseName("Math");

        assertEquals("Course ID: 1\n" +
                "Course name: Math\n" +
                "Course department: KKKK\n",course.descriere());
    }

    @Test public void setCourseDepartmentTest(){

        Course course=new Course(1,"HHHH","KKKK");

        course.setCourseDepartment("PPP");

        assertEquals("Course ID: 1\n" +
                "Course name: HHHH\n" +
                "Course department: PPP\n",course.descriere());
    }


    @Test public void getCourseIdTest(){

        Course course=new Course(1,"HHHH","KKKK");

        assertEquals(1,course.getId());

    }

    @Test public void getCoursenameTest(){

        Course course=new Course(1,"MMM","HHH");

        assertEquals("MMM",course.getCourseName());
    }

    @Test public void getCourseDepartmentTest(){

        Course course=new Course(1,"HHHH","KKKK");

        assertEquals("KKKK",course.getCourseDepartment());

    }


    @Test public void formatToSaveTest(){

        Course course=new Course("1,HHHH,KKKK");

        assertEquals("1,HHHH,KKKK",course.formatToSave());


    }




}