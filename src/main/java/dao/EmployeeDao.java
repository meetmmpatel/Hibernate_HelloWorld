package dao;

import model.Employee;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDao {
  
  public void readWriteEmployee() {
	
	Employee employeeOne = new Employee
			("Josh", "Smith", "jsmith@gmail.com");
	
	Employee employeeTwo = new Employee(
			"Mike", "Miller", "mmiller@gmail.com");
	
	
	Transaction transaction = null;
	
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  //Start the transaction
	  transaction = session.beginTransaction();
	  
	  //save the students info
	  session.save(employeeOne);
	  session.save(employeeTwo);
	  
	  //commit the transactions
	  transaction.commit();
	  
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
		e.printStackTrace();
	  }
	  
	}
	
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  List<Student> studentsList =
			  session.createQuery("from Student", Student.class).list();
	  
	  studentsList.forEach(stuOne -> System.out.println(employeeOne.getFirstName()
			  + " " + employeeOne.getLastName()));
	  
	  studentsList.forEach(stuTwo -> System.out.println(employeeTwo.getFirstName()
			  + " " + employeeTwo.getLastName()));
	  
	  
	} catch (Exception e) {
	  
	  if (transaction != null) {
		transaction.rollback();
		e.printStackTrace();
	  }
	  
	}
	
	
  }
}
