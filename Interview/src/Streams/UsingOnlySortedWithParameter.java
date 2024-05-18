package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class UsingOnlySortedWithParameter {
	
	public static void main(String [] args)
	
	
	
	{
		
		ArrayList<Integer> integelist = new ArrayList();
		integelist.add(10);
		integelist.add(6);
		integelist.add(89);
		integelist.add(5);
		
		
		ArrayList<String> stringList = new ArrayList();
		stringList.add("Z");
		stringList.add("A");
		stringList.add("G");
		stringList.add("Y");
		
		
		List<Integer> integelistsalsortingorderwithparam=integelist.stream()
			    .sorted((a,b)->Integer.compare(a, b))
			    .collect(Collectors.toList());
		System.out.println("Integer List With param"+integelistsalsortingorderwithparam);
		 
				
		
		List<Integer> integelistsalsortingorder=integelist.stream()
			    .sorted()
			    .collect(Collectors.toList());
		System.out.println("Ineteger List Without Param"+integelistsalsortingorder);
		
		
		List<Integer> integelistsalsortingordercom=integelist.stream()
			    .sorted(Comparator.reverseOrder())
			    .collect(Collectors.toList());
		System.out.println("integelistsalsortingordercom"+integelistsalsortingordercom);
		
		
		
		
		
		
		List<String> stringListSortingorderparam=stringList.stream()
			    .sorted((a,b)->a.compareTo(b))
			    .collect(Collectors.toList());
		System.out.println("String List with Param"+stringListSortingorderparam);
		
		List<String> stringListSorting=stringList.stream()
			    .sorted()
			    .collect(Collectors.toList());
		System.out.println("String List without Param"+stringListSorting);
		
		List<String> stringListSortingcomp=stringList.stream()
			    .sorted(Comparator.reverseOrder())
			    .collect(Collectors.toList());
		System.out.println("stringListSortingcomp"+stringListSortingcomp);
		
		
		
		
		
		ArrayList<Employee> employeedata=EmployeedataUtility.employeeList();
		
		List<Integer> empsalsortingorder=employeedata.stream()
	    .mapToInt(empdata -> empdata.getSal())
	    .boxed()
	    .sorted(Comparator.reverseOrder())
	    .collect(Collectors.toList());
	    
		
		
		System.out.println("Emp sal soeting order----------"+empsalsortingorder);
		
		

		List<String> empdepartmentsortingorder=employeedata.stream()
	    .map(empdata -> empdata.getDept())
	    .sorted(Comparator.reverseOrder())
	    .collect(Collectors.toList());
	    
		System.out.println("Emp dep sorting order----------"+empdepartmentsortingorder);
		
		
		
		OptionalDouble  avg=employeedata.stream()
			    .mapToInt(empdata -> empdata.getSal())
			    .average();
		System.out.println("OptionalDouble---------"+avg);
		
		int  sum=employeedata.stream()
			    .mapToInt(empdata -> empdata.getSal())
			    .sum();
		System.out.println("int---------"+sum);
		
		OptionalInt  max=employeedata.stream()
			    .mapToInt(empdata -> empdata.getSal())
			    .max();
		System.out.println("OptionalInt---------"+max);
		
		
		//finding 8th highest sal 
		
		Optional<Integer> eighthhighestsal=employeedata.stream()
			    .mapToInt(empdata -> empdata.getSal())
			    .boxed()
			    .sorted()
			    .skip(7)
			    .findFirst();
		
		System.out.println("eight highest sal "+eighthhighestsal);
		
		
			    
		
		
		
 
				
		

	}

}
