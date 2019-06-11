package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentUpdateDao {
  
  public void updateStudent(Student student) {
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  //Start transactions
	  
	  transaction = session.beginTransaction();
	  
	  session.saveOrUpdate(student);
	  
	  transaction.commit();
	  
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
	  }
	  e.printStackTrace();
	  
	  
	}
	
	
  }
  
  
}
