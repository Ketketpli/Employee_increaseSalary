import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        boolean idExists;

        // PART 1 - READING DATA:
        
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i+1) + ": ");
            System.out.print("Id: ");
            int id = sc.nextInt();

            do {
                idExists = false;

                for (Employee e : list) {
                    if (e.getId() == id) {
                        idExists = true;
                        System.out.print("ID already exists, enter again: ");
                        id = sc.nextInt();
                        break;
                    }
                }
            } while (idExists);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        // PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:

        System.out.print("Enter the employee id that will have salary increase : ");
        int id = sc.nextInt();
        idExists = false;

        for (Employee e : list) {

            if (e.getId() == id) {
                idExists = true;
                System.out.print("Enter the percentage: ");
                double increase = sc.nextDouble();
                e.increaseSalary(increase);
                break;
            }
        }

        if (!idExists) {
            System.out.println("This ID does not exist!");
        }

        // PART 3 - LISTING EMPLOYEES:
        
        System.out.println();
        System.out.println("List of employees: ");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }
}


