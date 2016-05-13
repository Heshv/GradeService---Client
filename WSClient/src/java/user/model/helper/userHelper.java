/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.model.helper;

import gradeservice.util.NewHibernateUtil;
import org.hibernate.Query;

import org.hibernate.Session;
import user.model.Users;

/**
 *
 * @author rsawoniewski
 */
public class userHelper {
    
     Session session = null;

    public userHelper() {
        this.session = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Users getMarkById(int id) {
        if (session.isOpen() == false) {
            NewHibernateUtil.getSessionFactory().openSession();
        }
        if (session.getTransaction().wasCommitted()) {
            session.getTransaction().commit();
        }
        Users entity = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Users S where S.id =" + id);
            entity = (Users) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (session.isOpen() == true) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session.isOpen() == true) {
                session.close();
            }
        }
        return entity;
    }
}
