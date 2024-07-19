import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> employees;


    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(int id,  Employee updateEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, updateEmployee);
                return;
            }
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public List<Employee> getEmployeeByType(Class<?> type) {
        return employees.stream().filter(type::isInstance).collect(Collectors.toList());
    }

}
