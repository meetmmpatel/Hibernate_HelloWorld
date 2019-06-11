package dao;


import model.Student;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentReadDao {
  
  
  //Session.byId();
  public void getByIdSudent(int id) {
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  //Start the transaction
	  transaction = session.beginTransaction();
	  
	  //get/red Student values
	  
	  Student student = session.byId(Student.class).getReference(id);
	  System.out.println(student.getFirstName());
	  System.out.println(student.getLastName());
	  System.out.println(student.getEmail());
	  
	  transaction.commit();
	  
	} catch (Exception e) {
	  
	  if (transaction != null) {
		transaction.rollback();
	  }
	  
	  e.printStackTrace();
	  
	}
	
	
  }
  
  //Session.get()
  public void getStudent(int id) {
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  //Start the transactions
	  transaction = session.beginTransaction();
	  
	  //read student info
	  Student student = session.get(Student.class, id);
	  System.out.println(student.getFirstName());
	  System.out.println(student.getLastName());
	  System.out.println(student.getEmail());
	  transaction.commit();
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
		e.printStackTrace();
	  }
	  System.out.println("this catch block for get method");
	}
	
	
  }
  
  //Session.load()
  public void loadStudent(int id) {
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  //Start the transactions
	  transaction = session.beginTransaction();
	  
	  //read student info
	  Student student = session.load(Student.class, id);
	  System.out.println(student.getFirstName());
	  System.out.println(student.getLastName());
	  System.out.println(student.getEmail());
	  transaction.commit();
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
		e.printStackTrace();
	  }
	  System.out.println("this is load method catch block");
	}
	
  }
  
  
}
