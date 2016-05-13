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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author rsawoniewski
 */
@ManagedBean
@SessionScoped
public class SubjectController implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_17331/NewWebService/NewWebService.wsdl")
    private NewWebService_Service service;

    String name;
    List<Subject> subjectList;

    /**
     * Creates a new instance of SubjectController
     */
    public SubjectController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        subjectList = getAllSubjects();
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public String deleteSubject(Subject subject) {
        deleteSubjectDTO2(subject);
        return "admin_panel";
    }

    public String addSubject(String name) {
        Subject subject = new Subject();
        subject.setName(name);
        saveSubjectDTO2(subject);
        return "admin_panel";
    }

    public String updateSubject(String id, String name1) {
        int id1 = Integer.parseInt(id);
        Subject subject = new Subject();
        subject = getSubjectById(id1);
        subject.setName(name1);
        updateSubjectDTO2(subject);
        return "admin_panel";
    }

    private java.util.List<gradeservice.webservices.Subject> getAllSubjects() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getAllSubjects();
    }

    private String deleteSubjectDTO2(gradeservice.webservices.Subject entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.deleteSubjectDTO2(entity);
    }

    private String saveSubjectDTO2(gradeservice.webservices.Subject subject) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.saveSubjectDTO2(subject);
    }

    private Subject getSubjectById(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.getSubjectById(id);
    }

    private String updateSubjectDTO2(gradeservice.webservices.Subject entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        gradeservice.webservices.NewWebService port = service.getNewWebServicePort();
        return port.updateSubjectDTO2(entity);
    }

}
