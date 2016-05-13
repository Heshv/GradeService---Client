/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeservice.controller;

import gradeservice.webservices.NewWebService_Service;
import gradeservice.webservices.Student;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author rsawoniewski
 */
@Named(value = "studentController")
@SessionScoped
public class StudentController implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_17331/NewWebService/NewWebService.wsdl")
    private NewWebService_Service service;

    String firstName;
    String lastName;
    String Address;
    List<Student> studentList;

    /**
     * Creates a new instance of StudentController
     */
    public StudentController() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public List<Student> getStudentList() {
        studentList = getAllStudents();
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String deleteStudent(Student student) {
        deleteStudentDTO2(student);
        return "admin_panel";
    }

    public String addStudent(String firstName1, String lastName1, String address1) {
        Student student = new Student();
        student.setFirstName(firstName1);
        student.setLastName(lastName1);
        student.setAddress(address1);
        saveStudentDTO2(student);
        return "admin_panel";
    }

    public String updateStudent(String id,String firstName1, String lastName1, String address1) {
        int id1 = Integer.parseInt(id);
        Student student = new Student();
        student = getStudentById(id1);
        student.setFirstName(firstName1);
        student.setLastName(lastName1);
        student.setAddress(address1);
        updateStudentDTO2(student);
        return "admin_panel";
    }

    private String deleteStudentDTO2(gradeservice.webservices.Student entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.deleteStudentDTO2(entity);
    }

    private java.util.List<gradeservice.webservices.Student> getAllStudents() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getAllStudents();
    }

    private Student getStudentById(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getStudentById(id);
    }

    private String saveStudentDTO2(gradeservice.webservices.Student student) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.saveStudentDTO2(student);
    }

    private String updateStudentDTO2(gradeservice.webservices.Student student) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.updateStudentDTO2(student);
    }
}
