package dao;

/**
* Проект     : demopersons
* Document   : RoleDbDAO.java
* Create on  : 06.07.2023
* Author     : Dolzhenko A.
*/

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import domain.Role;
import jakarta.persistence.criteria.CriteriaQuery;
import util.HibernateUtil;
import util.HibernateUtil1;


public class RoleDao {

    /**
     * Save Role
     * @param role
     */
    public void saveRole(Role role) {
        Transaction transaction = null;
        try (Session session = HibernateUtil1.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.persist(role);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Role
     * @param Role
     */
    public void updateRole(Role role) {
        Transaction transaction = null;
        try (Session session = HibernateUtil1.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.merge(role);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Role
     * @param id
     */
    public void deleteRole(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil1.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Role role = session.get(Role.class, id);
            if (role != null) {
                session.remove(role);
                System.out.println("role is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Role By ID
     * @param id
     * @return
     */
    public Role findRoleById(int id) {

        Transaction transaction = null;
        Role role = null;
        try (Session session = HibernateUtil1.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            role = session.get(Role.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return role;
    }

    /**
     * Get all Roles
     * @return
     */
    
    public List<Role> findAllRole() {
    	
        Transaction tx = null;
        List <Role> results = null;
        
        //
        try {
        	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    		Session session = sessionFactory.getCurrentSession();
    		tx = session.beginTransaction();
    		
    		Query<Role> query = session.createQuery("from Role");
    		results = query.list();
             
            tx.commit();
            session.close(); 
            return results;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
