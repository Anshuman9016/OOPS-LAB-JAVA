class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double salary;
    private static int totalEmployees = 0;

    public Employee() {
        this.employeeID = 0;
        this.name = "Default Name";
        this.department = "General";
        this.salary = 30000.0; // Default salary
        totalEmployees++;
    }

    public Employee(int employeeID, String name, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++;
    }

    public double calculateSalary() {
        return this.salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Name: " + this.name);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: " + this.salary);
        System.out.println("---------------------------");
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class Q5EXP4 {
    public static void main(String[] args) {
 
        Employee emp1 = new Employee();
        Employee emp2 = new Employee(101, "Aditya", "HR", 50000.0);
        Employee emp3 = new Employee(102, "Rahul", "IT", 70000.0);
        Employee emp4 = new Employee(103, "Chetan", "Finance", 60000.0);
        
        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
        emp3.displayEmployeeInfo();
        emp4.displayEmployeeInfo();

        Employee.displayTotalEmployees();
    }
}
