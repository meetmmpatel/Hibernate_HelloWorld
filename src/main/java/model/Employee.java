package model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "employee" ,
		uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL")
		})
public class Employee implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true ,nullable = false)
  private Long empID;
  
  
  @Column (name = "First_Name", unique = false , nullable = false, length = 100)
  private String firstName;
  
  @Column (name = "Last_Name", unique = false , nullable = false, length = 100)
  private String lastName;
  
  @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
  private String address;
  
  
  public Employee() {
  }
  
  public Employee(String firstName, String lastName, String address) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
  }
  
  public Long getEmpID() {
	return empID;
  }
  
  public void setEmpID(Long empID) {
	this.empID = empID;
  }
  
  public String getFirstName() {
	return firstName;
  }
  
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  
  public String getLastName() {
	return lastName;
  }
  
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  
  public String getAddress() {
	return address;
  }
  
  public void setAddress(String address) {
	this.address = address;
  }
  
  @Override
  public String toString() {
	return "Employee{" +
			"empID=" + empID +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", address='" + address + '\'' +
			'}';
  }
}
