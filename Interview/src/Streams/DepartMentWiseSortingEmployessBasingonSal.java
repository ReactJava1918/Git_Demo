package Streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DepartMentWiseSortingEmployessBasingonSal {

	public static void main(String[] args) {
		
		
ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		//departmentwise sum
				LinkedHashMap<String,List<Employee>> departmentwisesortedsalinList1 = employeedata.stream()
						.collect(Collectors.groupingBy(a->a.getDept(),()->new LinkedHashMap(),
								Collectors.collectingAndThen(Collectors.toList(),
										employeeList -> employeeList.stream().sorted((a,b)->Integer.compare(b.getSal(), a.getSal())).collect(Collectors.toList()))));
				
				        
				departmentwisesortedsalinList1.forEach((key, value) -> {
				    System.out.println("Department: " + key);
				    
				    value.forEach(a->{
				    	System.out.println(key+"--------------------"+a.getAge() +"  "+a.getDept()+"   "+a.getSal()+"  "+a.getId());
				    	
				    });
				    
				   
				      // Added for clarity
				});
				

	}

}
