package Com.epam.HomeTask.Collections;

import java.util.HashMap;
import java.util.Map;

class Student{
	String studentName;
	Integer rollNum;
	public Student(String studentName,Integer rollNum) {
		this.studentName=studentName;
		this.rollNum=rollNum;
	}
	@Override
	public String toString() {
		return "Student Name =" + studentName + ",	roll Number =" + rollNum;
	}
}
class Employee{
	String EmployeeName;
	Integer EmployeeID;
	public Employee(String employeeName, Integer employeeID) {
		EmployeeName = employeeName;
		EmployeeID = employeeID;
	}
	@Override
	public String toString() {
		return "Emplyee Name ="+this.EmployeeName+",	Employee ID ="+this.EmployeeID;
	}
}
public class CustomClassObjects_HomeTask {

	public static void main(String[] args) {
		Map<Student,Employee> hashmap=new HashMap<>();
		
		Student s1=new Student("Manoj",143);
		Student s2=new Student("Kumar",585);
		Student s3=new Student("shiva",254);
		Student s4=new Student("SriRam",735);
		
		Employee e1=new Employee("Durga",624353);
		Employee e2=new Employee("seetha",845794);
		Employee e3=new Employee("lakshmi",944886);
		Employee e4=new Employee("Hanuman",784363);
		hashmap.put(s1, e1);
		hashmap.put(s2, e2);
		hashmap.put(s3, e3);
		hashmap.put(s4, e4);
		for(Map.Entry<Student, Employee> itr:hashmap.entrySet()) {
		System.out.println(itr.getKey()+"	"+itr.getValue());
		}

	}

}
