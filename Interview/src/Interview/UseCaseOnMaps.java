package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

 class Employee
{
	private int id;
	private int age;
	private int sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
}

public class UseCaseOnMaps {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList();
		Employee e1 = new Employee();
		e1.setAge(30);
		e1.setId(1);
		e1.setSal(1000);
		Employee e2 = new Employee();
		e2.setAge(40);
		e2.setId(2);
		e2.setSal(2000);
		Employee e3 = new Employee();
		e3.setAge(50);
		e3.setId(3);
		e3.setSal(3000);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		
		
		for(Employee employee:employeeList)
		{
			System.out.println(employee.getSal() +"   "+employee.getAge() +"   "+employee.getId());
		}
		
		System.out.println("-----------------------------------");
		
	List<Employee> afterModifyingList=	employeeList.stream().map(employeDta-> {
			
			if(employeDta.getSal()<=1000)
			{
				employeDta.setSal(9000);
			}
			 return employeDta;
				
		}).collect(Collectors.toList());
		

	
	for(Employee employee:afterModifyingList)
	{
		System.out.println(employee.getSal() +"   "+employee.getAge() +"   "+employee.getId());
	}
	
	System.out.println("=======================================================");
	
	List<Employee> usingfilter=	employeeList.stream().filter(employeDta-> {
		
		if(employeDta.getSal()<=1000)
		{
			employeDta.setSal(9000);
		}
		 return true;
			
	}).collect(Collectors.toList());
	
	
	
	for(Employee employee:usingfilter)
	{
		System.out.println(employee.getSal() +"   "+employee.getAge() +"   "+employee.getId());
	}
	
	}

}
