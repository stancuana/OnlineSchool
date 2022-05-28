package com.company.controller;

import com.company.model.Enrolment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllEnrolmentTest {

    @Test public void pozEnrolmentTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals(4, controllEnrolment.pozEnrolment(5));
    }

    @Test public void returnEnrolmentById() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals("ID: 1\n" +
                "Student ID: 6\n" +
                "Course ID: 20\n", controllEnrolment.returnEnrolmentById(1).descriere());
    }

    @Test public void updateTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        Enrolment enrolment = new Enrolment(1, 2, 3);

        controllEnrolment.updateAtributeEnrolment(enrolment);

        assertEquals(2, controllEnrolment.returnEnrolmentById(1).getStudentId());
        assertEquals(3, controllEnrolment.returnEnrolmentById(1).getCourseId());
    }

    @Test public void nextAvailableId() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals(controllEnrolment.nrEnrolmenturi() + 1, controllEnrolment.nextAvailableId());
    }

    @Test public void nrEnrolmenturiTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals(controllEnrolment.nextAvailableId() - 1, controllEnrolment.nrEnrolmenturi());

    }

    @Test public void deleteTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();
        int nrInitialEnrolmenturi = controllEnrolment.nrEnrolmenturi();

        controllEnrolment.deleteEnrolment(1);

        assertEquals(nrInitialEnrolmenturi - 1, controllEnrolment.nrEnrolmenturi());


    }

    @Test public void inscrieriCursuriTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals(4, controllEnrolment.nrInscrieriCursuri(3));


    }

    @Test public void returnIdEnrolmentByIdStudent() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        assertEquals(2, controllEnrolment.returnIdEnrolmentByIdStudent(10));
    }

    @Test public void saveTest() {

        ControllEnrolment controllEnrolment = new ControllEnrolment();

        int nrInitialEnrolmenturi = controllEnrolment.nrEnrolmenturi();

        Enrolment enrolment = new Enrolment(controllEnrolment.nextAvailableId(), 11, 4);

        controllEnrolment.addEnrolment(enrolment);
        controllEnrolment.save();

        assertEquals(nrInitialEnrolmenturi + 1, controllEnrolment.nrEnrolmenturi());
    }

}