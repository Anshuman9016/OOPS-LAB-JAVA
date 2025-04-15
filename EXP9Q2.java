import java.util.ArrayList;
import java.util.Iterator;

class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EXP9Q2 {

    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Arun", 101, 50000));
        employeeList.add(new Employee("Kunal", 102, 60000));
        employeeList.add(new Employee("Chetan", 103, 55000));

        for (Employee emp : employeeList) {
            if (emp.id == 102) {
                emp.salary = 65000;
                System.out.println("Updated salary for Kunal.");
                break;
            }
        }

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == 103) {
                iterator.remove();
                System.out.println("Removed Chetan from the list.");
                break;
            }
        }

        System.out.println("\nRemaining Employees:");
        for (Employee emp : employeeList) {
            emp.display();
        }
    }
}
