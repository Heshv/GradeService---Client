/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeservice.test;

import gradeservice.controller.MarkController;
import gradeservice.webservices.Mark;
import gradeservice.webservices.Student;
import gradeservice.webservices.Subject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rsawoniewski
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testMarkController() {
        MarkController mc = new MarkController();
       // String result = mc.displayMarks();
        //Logger.getLogger(MarkController.class.getName()).log(Level.INFO, "Display" instanceof + result);
    }

    @Test
    public void testWS() {
        Student student = new Student();
        student = getStudentById(1);
        Logger.getLogger(ControllerTest.class.getName()).log(Level.INFO, student.getFirstName() + " " + student.getLastName());
        student.setFirstName("xx");
        student.setLastName("xx");
        student.setAddress("xx");
        updateStudentDTO2(student);
    }
    

    private static Student getStudentById(int id) {
        gradeservice.webservices.NewWebService_Service service = new gradeservice.webservices.NewWebService_Service();
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getStudentById(id);
    }

    private static String updateStudentDTO2(gradeservice.webservices.Student student) {
        gradeservice.webservices.NewWebService_Service service = new gradeservice.webservices.NewWebService_Service();
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.updateStudentDTO2(student);
    }



}
