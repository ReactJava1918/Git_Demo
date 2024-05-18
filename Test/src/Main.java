public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee employee1 = new Employee(1, "John Doe", 60000.0);
        Employee employee2 = new Employee(2, "Jane Smith", 70000.0);

        // Create departments
        Department hrDepartment = new Department(101, "Human Resources");
        Department itDepartment = new Department(102, "Information Technology");

        // Associate employees with departments
        employee1.setDepartment(hrDepartment);
        employee2.setDepartment(itDepartment);

        // Add employees to departments
        hrDepartment.addEmployee(employee1);
        itDepartment.addEmployee(employee2);

        // Print information about employees and departments
        System.out.println("Employee 1: " + employee1);
        System.out.println("Employee 2: " + employee2);
        System.out.println("HR Department: " + hrDepartment);
        System.out.println("IT Department: " + itDepartment);
    }
}
