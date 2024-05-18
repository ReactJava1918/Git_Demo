package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentwiseSalsorted {
	
	public static void main(String [] args)
	{
		
		
ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise sum
				LinkedHashMap<String,List<Integer>> departmentwisesortedsalinList1 = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
												.boxed().sorted().collect(Collectors.toList()))));
				
				        
				departmentwisesortedsalinList1.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("sum: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});
				
				
		//in Reverse Order
				
				
				LinkedHashMap<String,List<Integer>> departmentwisesortedsalinListR11 = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
												.boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()))));
				
				        
				departmentwisesortedsalinListR11.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("sum: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});
	
		
	}

}
