package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentWriteDao {
  
  public void saveStudent(Student student) {
	
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  //Start the transactions
	  transaction = session.beginTransaction();
	  
	  //Write/Insert student info
	  session.save(student);
	  
	  transaction.commit();
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
		e.printStackTrace();
	  }
	}
	
  }
  
  
}
