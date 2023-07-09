package managerdb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import domain.*;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;


public class RoleManager {

	public RoleManager() {
		// TODO Auto-generated constructor stub
	}
	
	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
     }
 
    // Добавление должности в базу данных
    protected void create(String namerole) throws IllegalStateException, SystemException {
        // code to save a Role
    	Role role = new Role(null, namerole);
    	role.setNamerole(namerole);
     
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
			tx = (Transaction) session.beginTransaction();
			// do some work
			session.persist(role);
			tx.commit();
		}

		catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
    }
 
	// Чтение должности из базы данных по id
    protected Role find(Long id) throws IllegalStateException, SystemException {
		// code to get a role
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Role role = null;

		try {
			tx = (Transaction) session.beginTransaction();
			// do some work
			role = session.find(Role.class, id);
			tx.commit();
		}

		catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}
 
   
	// Обновление должности в базе данных
    protected void update(Role role) throws IllegalStateException, SystemException {
        // code to modify a role
		Transaction tx = null;
        Session session = sessionFactory.openSession();
        
        try {
			tx = (Transaction) session.beginTransaction();
			// do some work
			session.merge(role);
			tx.commit();
		}

		catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
     }
 
    protected void delete(Role role) throws IllegalStateException, SystemException {
        // code to remove a role
    	Transaction tx = null;
        Session session = sessionFactory.openSession();
        
        try {
			tx = (Transaction) session.beginTransaction();
			// do some work
			session.remove(role);
			tx.commit();
		}

		catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
    }

    //public static void main(String[] args) {
        // code to run the program
    //}

}
