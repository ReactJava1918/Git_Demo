package Streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class DepartMentwiseAvg {

	public static void main(String[] args) {
	
		
ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise sum
				LinkedHashMap<String,OptionalDouble> departmentwisesortedsalinList1 = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
										.average()) ));
				
				        
				departmentwisesortedsalinList1.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("avg: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});


	}

}
