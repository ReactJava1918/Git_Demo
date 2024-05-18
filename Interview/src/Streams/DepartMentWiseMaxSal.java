package Streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class DepartMentWiseMaxSal {
	public static void main(String [] args)
	{
ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise max sal
				LinkedHashMap<String,OptionalInt> departmentwisemaxsal = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
												.max())));
				
				        
				departmentwisemaxsal.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("sum: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});
				
				
				
				//departmentwise min sal
				LinkedHashMap<String,OptionalInt> departmentwiseminsal = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
												.min())));
				
				        
				departmentwiseminsal.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    System.out.println("sum: " + value);
				    System.out.println("------------------------"); // Added for clarity
				});
				
	}

}
