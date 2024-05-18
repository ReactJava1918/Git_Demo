package Streams;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMap {
    private int id;
    private String name;

    public EmployeeMap(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<EmployeeMap> employees = List.of(
                new EmployeeMap(1, "John"),
                new EmployeeMap(2, "Jane"),
                new EmployeeMap(3, "Doe")
        );

        // Collecting employees into a Map using their ID as the key
        Map<Integer, EmployeeMap> employeeMap = employees.stream()
                .collect(Collectors.toMap(employee->employee.getId(), employee -> employee));

        // Displaying the result
        System.out.println(employeeMap);
    }
}
