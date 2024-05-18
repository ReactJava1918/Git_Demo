package Streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class DepartmentwisesecondHighestsal {

	public static void main(String[] args) {
		
		ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise sum
		LinkedHashMap<String,OptionalInt> departmentwisesortedsalinList1 = employeedata.stream()
				.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
						Collectors.collectingAndThen(Collectors.toList(),
								employeeList -> employeeList.stream().mapToInt(empsal->empsal.getSal())
										.sorted().skip(1).findFirst())));
		
		        
		departmentwisesortedsalinList1.forEach((key, value) -> {
		    System.out.println("Department: " + key);
		    System.out.println("second highest sal " + value);
		    System.out.println("------------------------"); // Added for clarity
		});
		

	}

}
