package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentRemoveDao {
  
  public void deleteStudent(int id){
  
	Transaction transaction = null;
	
	try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	  transaction = session.beginTransaction();
	  
	 
	  //Delete object
	  Student student = session.get(Student.class, id);
	  
	  if(student != null){
	    session.delete(student);
		System.out.println("Student info is deleted");
	  }
	  
	  transaction.commit();
	  
	}catch (Exception e){
	  if (transaction != null){
	    transaction.rollback();
	    
	  }
	  e.printStackTrace();
	  
	}
  
  
  
  
  }
}
