package Interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class EmpData implements Comparable<EmpData>
{
	private int id;
	private int age;
	private int sal;
	private String dept;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
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
	 
	@Override
	public int compareTo(EmpData o) {
		return Integer.compare(this.age, o.age);
	
	}
	
	
	
}


public class FindNthHighestAge {

	public static void main(String[] args) {
		
		ArrayList<EmpData> listData	=employeeList();
		
		//departmentwise sum
		LinkedHashMap<String, List<Integer>> departmentwisesortedsalinList1 = listData.stream()
		        .collect(Collectors.groupingBy(
		                EmpData::getDept,
		                () -> new LinkedHashMap<>(),
		                Collectors.collectingAndThen(
		                        Collectors.mapping(EmpData::getSal, Collectors.toList()),
		                        obtainedList -> obtainedList.stream()
		                                .sorted()
		                                .collect(Collectors.toList())
		                )
		        ));

		departmentwisesortedsalinList1.forEach((key, values) -> {
		    System.out.println("Department: " + key);
		    System.out.println("Sorted Salaries: " + values);
		    System.out.println("------------------------"); // Added for clarity
		});

		
		
		
		
		
	 

				
				
		
		
		
		
		//departmentwise sum
		LinkedHashMap<String, Integer> departmentwisesum=listData.stream().
				collect(Collectors.groupingBy(data1->data1.getDept(),() -> new LinkedHashMap(),
				Collectors.collectingAndThen(Collectors.toList(),
						obtainedList->obtainedList.stream()
						.mapToInt(empdat2->empdat2.getSal())
						.sum())));
		
		
		departmentwisesum.forEach((key, values) -> {
		    System.out.println("Department: " + key);
		    System.out.println("sum: " + values);
		    System.out.println("------------------------"); // Added for clarity
		});
		
		
		
		
		
	 


		
		
		// department wise avg
		LinkedHashMap<String, OptionalDouble> departmentwiseavg = listData.stream()
		        .collect(Collectors.groupingBy(
		                EmpData::getDept,
		                () -> new LinkedHashMap<>(),
		                Collectors.collectingAndThen(
		                        Collectors.mapping(EmpData::getSal, Collectors.averagingInt(Integer::intValue)),
		                        OptionalDouble::of
		                )
		        ));

		departmentwiseavg.forEach((key, values) -> {
		    System.out.println("Department: " + key);
		    System.out.println("Average: " + (values.isPresent() ? values.getAsDouble() : "N/A"));
		    System.out.println("------------------------");
		});

		
		
		
		// department wise max
		LinkedHashMap<String, Integer> departmentwisemax = listData.stream()
		        .collect(Collectors.groupingBy(
		                EmpData::getDept,
		                () -> new LinkedHashMap<>(),
		                Collectors.collectingAndThen(
		                        Collectors.mapping(empData -> empData.getSal(), Collectors.toList()),
		                        obtainedList -> obtainedList.stream()
		                                .mapToInt(empData -> empData)
		                                .max()
		                                .orElse(0)
		                )
		        ));

		departmentwisemax.forEach((key, max) -> {
		    System.out.println("Department: " + key);
		    System.out.println("Max: " + max);
		    System.out.println("------------------------");
		});

		
		
		//departwise min
		
		LinkedHashMap<String, Integer> departmentwisemin = listData.stream()
		        .collect(Collectors.groupingBy(
		                EmpData::getDept,
		                () -> new LinkedHashMap<>(),
		                Collectors.collectingAndThen(
		                        Collectors.mapping(empData -> empData.getSal(), Collectors.toList()),
		                        obtainedList -> obtainedList.stream()
		                                .mapToInt(empData -> empData)
		                                .min()
		                                .orElse(0)
		                )
		        ));

		departmentwisemin.forEach((key, max) -> {
		    System.out.println("Department: " + key);
		    System.out.println("min: " + max);
		    System.out.println("------------------------");
		});

		
		
		// department wise second highest salary
		LinkedHashMap<String, Integer> departmentwisensecondHighest = listData.stream()
		        .collect(Collectors.groupingBy(
		                EmpData::getDept,
		                () -> new LinkedHashMap<>(),
		                Collectors.collectingAndThen(
		                        Collectors.mapping(empData -> empData.getSal(), Collectors.toList()),
		                        obtainedList -> obtainedList.stream()
		                                .mapToInt(empData -> empData)
		                                .sorted()
		                                .skip(1)
		                                .limit(1)
		                                .findFirst()
		                                .orElse(0)
		                )
		        ));

		departmentwisensecondHighest.forEach((key, secondHighest) -> {
		    System.out.println("Department: " + key);
		    System.out.println("Second Highest: " + secondHighest);
		    System.out.println("------------------------");
		});

	

	}

	public static ArrayList<EmpData> employeeList() {
		ArrayList<EmpData> employeeList = new ArrayList();
		EmpData e1 = new EmpData();
		e1.setAge(30);
		e1.setId(1);
		e1.setSal(1000);
		employeeList.add(e1);
		e1.setDept("A");
		EmpData e2 = new EmpData();
		e2.setAge(40);
		e2.setId(2);
		e2.setSal(2000);
		e2.setDept("B");
		employeeList.add(e2);
		EmpData e3 = new EmpData();
		e3.setAge(50);
		e3.setId(3);
		e3.setSal(3000);
		e3.setDept("C");
		employeeList.add(e3);
		EmpData e4 = new EmpData();
		e4.setAge(50);
		e4.setId(3);
		e4.setSal(5000);
		e4.setDept("A");
		employeeList.add(e4);
		EmpData e5 = new EmpData();
		e5.setAge(50);
		e5.setId(3);
		e5.setSal(9000);
		e5.setDept("B");
		employeeList.add(e5);
		EmpData e6 = new EmpData();
		e6.setAge(50);
		e6.setId(3);
		e6.setSal(3000);
		e6.setDept("C");
		employeeList.add(e6);
		EmpData e7 = new EmpData();
		e7.setId(7);
		e7.setAge(28);
		e7.setSal(1200);
		e7.setDept("B");
		employeeList.add(e7);

		EmpData e8 = new EmpData();
		e8.setId(8);
		e8.setAge(38);
		e8.setSal(2500);
		e8.setDept("C");
		employeeList.add(e8);

		EmpData e9 = new EmpData();
		e9.setId(9);
		e9.setAge(48);
		e9.setSal(3500);
		e9.setDept("A");
		employeeList.add(e9);

		EmpData e10 = new EmpData();
		e10.setId(10);
		e10.setAge(32);
		e10.setSal(1800);
		e10.setDept("B");
		employeeList.add(e10);
		
		return employeeList;
	}

}
