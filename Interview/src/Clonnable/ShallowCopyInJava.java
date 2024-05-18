package Clonnable;
class Department {
    String empId;
 
    String grade;
 
    String designation;
 
    public Department(String empId, String grade, String designation) {
        this.empId = empId;
 
        this.grade = grade;
 
        this.designation = designation;
    }

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
    
    
}
 
class Employee implements Cloneable {
    int id;
 
    String name;
 
    Department dept;
 
    public Employee(int id, String name, Department dept) {
        this.id = id;
 
        this.name = name;
 
        this.dept = dept;
    }
 
    
 
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Department getDept() {
		return dept;
	}



	public void setDept(Department dept) {
		this.dept = dept;
	}



	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
 
public class ShallowCopyInJava {
 
    public static void main(String[] args) {
 
        Department dept1 = new Department ("1", "A", "AVP");
 
        Employee emp1 = new Employee (111, "John", dept1);
 
        Employee emp2 = null;
 
        try {
            // Creating a clone of emp1 and assigning it to emp2
 
            emp2 = (Employee) emp1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
 
        // Printing the designation of 'emp1'
 
        System.out.println(emp1.dept.designation); // Output : AVP
 
        // Changing the designation of 'emp2'
 
        emp2.dept.designation = "Director";
        emp2.id=6;
 
        // This change will be reflected in original Employee 'emp1'
 
        System.out.println(emp1.dept.designation);// Output : Director
        System.out.println(emp1.id);
        
        
        
        System.out.println("---------------hascode---------------");
        System.out.println(emp1);
        System.out.println(emp2);
    }
}