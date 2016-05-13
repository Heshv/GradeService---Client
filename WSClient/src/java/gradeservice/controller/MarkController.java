/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeservice.controller;

import gradeservice.webservices.Mark;
import gradeservice.webservices.NewWebService_Service;
import gradeservice.webservices.Student;
import gradeservice.webservices.Subject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author rsawoniewski
 */
@ManagedBean(name = "markController")
@SessionScoped
public class MarkController implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_17331/NewWebService/NewWebService.wsdl")
    private NewWebService_Service service;

    int grade;
    Student student;
    Subject subject;
    String forwhat;
    List<Mark> marklist;

    /**
     * Creates a new instance of MarkController
     */
    public MarkController() {

    }

    public String getHello() {
        return "hello";
    }

    public String displayMarks() {
        marklist = getAllMarksSQL(1);
        String result = new String();
        for (Mark m : marklist) {
            result = m.getName();
        }

        return result;
    }

    public List<Mark> getMarklist() {
        marklist = getAllMarksSQL(1);
        return marklist;
    }

    public List<Mark> getMarklist(int id, int id2) {
        marklist = getAllMarksSQLStudentAndSubject(id, id2);
        return marklist;
    }
    
    public Double getAverageMark(int id, int id2) {
        List<Mark> list = getAllMarksSQLStudentAndSubject(id, id2);
        return getAverageGrade(list);
    }
    
    public Double getAverageSemesterMark(int id) {
        List<Mark> list = getAllMarksSQL(id);
        return getAverageGrade(list);
    }
    
     public String deleteMark(int id) {
        deleteMark_1(id);
        return "admin_panel";
    }

    public String addMark(int studentid, int subjectid, String forwhat1, Double grade1) {
        Mark mark = new Mark();
        Student student2 = new Student();
        student2 = getStudentById(studentid);
        Subject subject2 = new Subject();
        subject2 = getSubjectById(subjectid);
        mark.setStudent(student2);
        mark.setSubject(subject2);
        mark.setName(forwhat1);
        mark.setMark(grade1);
        saveMarkDTO2(mark);
        return "admin_panel";
    }

    public String updateMark(int id, int studentid, int subjectid, String forwhat1, Double grade1) {
        Mark mark = new Mark();
        mark = getMarkById(id);
        Student student2 = new Student();
        student2 = getStudentById(studentid);
        Subject subject2 = new Subject();
        subject2 = getSubjectById(subjectid);
        mark.setStudent(student2);
        mark.setSubject(subject2);
        mark.setName(forwhat1);
        mark.setMark(grade1);
        updateMarkDTO2(mark);
        return "admin_panel";
    }
    

    public void setMarklist(List<Mark> marklist) {
        this.marklist = marklist;
    }

    private java.util.List<gradeservice.webservices.Mark> getAllMarksSQL(int studentId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getAllMarksSQL(studentId);
    }

    private java.util.List<gradeservice.webservices.Mark> getAllMarksSQLStudentAndSubject(int studentId, int subjectId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getAllMarksSQLStudentAndSubject(studentId, subjectId);
    }

    private Double getAverageGrade(java.util.List<gradeservice.webservices.Mark> marklist) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getAverageGrade(marklist);
    }

    private String deleteMarkDTO2(gradeservice.webservices.Mark entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.deleteMarkDTO2(entity);
    }

    private String deleteMark_1(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.deleteMark(id);
    }

    private Mark getMarkById(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getMarkById(id);
    }

    private String saveMarkDTO2(gradeservice.webservices.Mark mark) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.saveMarkDTO2(mark);
    }

    private String updateMarkDTO2(gradeservice.webservices.Mark entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.updateMarkDTO2(entity);
    }

    private Student getStudentById(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getStudentById(id);
    }

    private Subject getSubjectById(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getSubjectById(id);
    }

}
