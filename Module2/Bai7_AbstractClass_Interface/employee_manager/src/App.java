import java.util.List;
import java.util.Scanner;

public class App {
    private static EmployeeManager manager = new EmployeeManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayEmployeeCount();
                    break;
                case 6:
                    displayEmployeesByType();
                    break;
                case 7:
                    displayAllEmployees();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Search Employee");
        System.out.println("5. Display Employee Count");
        System.out.println("6. Display Employees by Type");
        System.out.println("7. Display All Employees");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Employee Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Employee Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Employee Type (1-Office, 2-Factory, 3-Delivery): ");
        int type = Integer.parseInt(scanner.nextLine());

        Employee employee;
        switch (type) {
            case 1:
                employee = new OfficeEmployee(id, name, phone, position);
                break;
            case 2:
                System.out.print("Enter Factory ID: ");
                int factoryID = scanner.nextInt();
                System.out.print("Enter Type: ");
                String factoryType = scanner.nextLine();
                employee = new FactoryEmployee(id, name, phone, position, factoryID, factoryType);
                break;
            case 3:
                System.out.print("Enter Vehicle Type: ");
                String vehicleType = scanner.nextLine();
                employee = new DeliveryEmployee(id, name, phone, position, vehicleType);
                break;
            default:
                System.out.println("Invalid Employee Type.");
                return;
        }

        manager.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee existingEmployee = manager.getEmployee(id);
        if (existingEmployee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new Employee Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter new Employee Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new Employee Position: ");
        String position = scanner.nextLine();

        if (existingEmployee instanceof OfficeEmployee) {
            OfficeEmployee updatedEmployee = new OfficeEmployee(id, name, phone, position);
            manager.updateEmployee(id, updatedEmployee);
        } else if (existingEmployee instanceof FactoryEmployee) {
            System.out.print("Enter new Factory Code: ");
            int factoryCode = scanner.nextInt();
            System.out.print("Enter new Type: ");
            String factoryType = scanner.nextLine();
            FactoryEmployee updatedEmployee = new FactoryEmployee(id, name, phone, position, factoryCode, factoryType);
            manager.updateEmployee(id, updatedEmployee);
        } else if (existingEmployee instanceof DeliveryEmployee) {
            System.out.print("Enter new Vehicle Type: ");
            String vehicleType = scanner.nextLine();
            DeliveryEmployee updatedEmployee = new DeliveryEmployee(id, name, phone, position, vehicleType);
            manager.updateEmployee(id, updatedEmployee);
        }

        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        Employee employee = manager.getEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Are you sure you want to delete this employee? (yes/no): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            manager.deleteEmployee(id);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee deletion canceled.");
        }
    }

    private static void searchEmployee() {
        System.out.println("Search by: 1-Employee ID, 2-Employee Type");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                int id = scanner.nextInt();
                Employee employee = manager.getEmployee(id);
                if (employee != null) {
                    System.out.println(employee);
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            case 2:
                System.out.print("Enter Employee Type (1-Office, 2-Factory, 3-Delivery): ");
                int type = Integer.parseInt(scanner.nextLine());
                Class<?> employeeClass = getClassByType(type);
                if (employeeClass != null) {
                    List<Employee> employees = manager.getEmployeeByType(employeeClass);
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                } else {
                    System.out.println("Invalid Employee Type.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Class<?> getClassByType(int type) {
        switch (type) {
            case 1:
                return OfficeEmployee.class;
            case 2:
                return FactoryEmployee.class;
            case 3:
                return DeliveryEmployee.class;
            default:
                return null;
        }
    }

    private static void displayEmployeeCount() {
        System.out.println("Total Employees: " + manager.getAllEmployees().size());
        System.out.println("Office Employees: " + manager.getEmployeeByType(OfficeEmployee.class).size());
        System.out.println("Factory Employees: " + manager.getEmployeeByType(FactoryEmployee.class).size());
        System.out.println("Delivery Employees: " + manager.getEmployeeByType(DeliveryEmployee.class).size());
    }

    private static void displayEmployeesByType() {
        System.out.print("Enter Employee Type (1-Office, 2-Factory, 3-Delivery): ");
        int type = Integer.parseInt(scanner.nextLine());
        Class<?> employeeClass = getClassByType(type);
        if (employeeClass != null) {
            List<Employee> employees = manager.getEmployeeByType(employeeClass);
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Invalid Employee Type.");
        }
    }

    private static void displayAllEmployees() {
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}
