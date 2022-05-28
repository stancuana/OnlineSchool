package com.company.controller;

import com.company.model.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllCourseTest {

    @Test public void nrCursuriTest(){

        ControllCourse controllCourse=new ControllCourse();

        assertEquals(controllCourse.nextAvailableId()-1,controllCourse.nrCursuri());
    }

    @Test public void addCourseTest(){

        ControllCourse controllCourse=new ControllCourse();
        int nrInitialCursuri=controllCourse.nrCursuri();

        Course course=new Course(1,"HHHH","KKKK");
        controllCourse.addCourse(course);


        assertEquals(nrInitialCursuri+1,controllCourse.nrCursuri());
    }

    @Test public void pozCourseTest(){

        ControllCourse controllCourse=new ControllCourse();

        assertEquals(4,controllCourse.pozCource(5));
    }

    @Test public void updateCourseTest(){

        Course course=new Course(1,"JJJ","KKK");

        ControllCourse controllCourse=new ControllCourse();

        controllCourse.updateCource(course);

        assertEquals("JJJ",controllCourse.retrunCursById(1).getCourseName());
        assertEquals("KKK",controllCourse.retrunCursById(1).getCourseDepartment());
    }

    @Test public void deleteCourseTest(){

        ControllCourse controllCourse=new ControllCourse();

        int nrInitialCursuri=controllCourse.nrCursuri();

        controllCourse.deleteCource(2);

        assertEquals(nrInitialCursuri-1,controllCourse.nrCursuri());
    }

    @Test public void returnareCursByName(){

        ControllCourse controllCourse=new ControllCourse();

        assertEquals("Course ID: 3\n" +
                "Course name: Diovan\n" +
                "Course department: Job\n",controllCourse.returnareCursByName("Diovan").descriere());

    }

    @Test public void returnareCursById(){

        ControllCourse controllCourse=new ControllCourse();

        assertEquals("Course ID: 3\n" +
                "Course name: Diovan\n" +
                "Course department: Job\n",controllCourse.retrunCursById(3).descriere());


    }

    @Test public void saveTest(){

        ControllCourse controllCourse=new ControllCourse();

        Course course=new Course(controllCourse.nextAvailableId(),"HHHH","KKKK");

        int nrInitialCursuri=controllCourse.nrCursuri();

        controllCourse.addCourse(course);

        controllCourse.save();

        assertEquals(nrInitialCursuri+1,controllCourse.nrCursuri());
    }

    @Test public void nextAvailableIdTest(){

        ControllCourse controllCourse=new ControllCourse();
        assertEquals(controllCourse.nrCursuri()+1,controllCourse.nextAvailableId());

    }





}