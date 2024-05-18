package Streams;

import java.util.ArrayList;


public class EmployeedataUtility {

    public static ArrayList<Employee> employeeList() {
        ArrayList<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setAge(30);
        e1.setId(1);
        e1.setSal(1000);
        e1.setDept("A");
        employeeList.add(e1);

        Employee e2 = new Employee();
        e2.setAge(40);
        e2.setId(2);
        e2.setSal(2000);
        e2.setDept("B");
        employeeList.add(e2);

        Employee e3 = new Employee();
        e3.setAge(50);
        e3.setId(3);
        e3.setSal(3000);
        e3.setDept("C");
        employeeList.add(e3);

        Employee e4 = new Employee();
        e4.setAge(50);
        e4.setId(3);
        e4.setSal(5000);
        e4.setDept("A");
        employeeList.add(e4);

        Employee e5 = new Employee();
        e5.setAge(50);
        e5.setId(3);
        e5.setSal(9000);
        e5.setDept("B");
        employeeList.add(e5);

        Employee e6 = new Employee();
        e6.setAge(50);
        e6.setId(3);
        e6.setSal(3000);
        e6.setDept("C");
        employeeList.add(e6);

        Employee e7 = new Employee();
        e7.setId(7);
        e7.setAge(28);
        e7.setSal(1200);
        e7.setDept("B");
        employeeList.add(e7);

        Employee e8 = new Employee();
        e8.setId(8);
        e8.setAge(38);
        e8.setSal(2500);
        e8.setDept("C");
        employeeList.add(e8);

        Employee e9 = new Employee();
        e9.setId(9);
        e9.setAge(48);
        e9.setSal(3500);
        e9.setDept("A");
        employeeList.add(e9);

        Employee e10 = new Employee();
        e10.setId(10);
        e10.setAge(32);
        e10.setSal(1800);
        e10.setDept("B");
        employeeList.add(e10);

        return employeeList;
    }

	 
}
