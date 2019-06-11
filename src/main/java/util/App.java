package util;

import dao.*;
import model.Student;


public class App {
  
  public static void main(String[] args) {
	
	Student studentOne = new Student("Josh", "Jorden", null);
	Student studentTwo = new Student("Jems", "Smith", "js@gmail.com");
	Student studentThree = new Student("Mike", "Jorden", "j@test.com");
	Student studentFour = new Student("Testuser", "Smith", "js@gmail.com");


	StudentWriteDao writeDao = new StudentWriteDao();
	writeDao.saveStudent(studentOne);
	writeDao.saveStudent(studentTwo);
	writeDao.saveStudent(studentThree);
	writeDao.saveStudent(studentFour);

	StudentReadDao readDao = new StudentReadDao();
//	readDao.getByIdSudent(1);
	readDao.loadStudent(2);
//	readDao.loadStudent(3);
//	readDao.loadStudent(5);
//	readDao.getStudent(6);
	
	studentTwo.setFirstName("Jimmy");
 
	StudentUpdateDao updateDao = new StudentUpdateDao();
	updateDao.updateStudent(studentTwo);
 
	readDao.getByIdSudent(2);
 
	StudentRemoveDao removeDao = new StudentRemoveDao();
	removeDao.deleteStudent(2);


//	readDao.loadStudent(2);

	
	
  }
  
  
}
