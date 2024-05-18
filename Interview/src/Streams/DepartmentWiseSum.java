package Streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;



public class DepartmentWiseSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise sum
				LinkedHashMap<String,Integer> departmentwisesortedsalinList1 = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
										.sum()) ));
				
				        
				departmentwisesortedsalinList1.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("sum: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});

		

	}

}
