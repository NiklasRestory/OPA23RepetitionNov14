package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHandler {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public EmployeeHandler() {
        employeeList.add(new Employee("Jim", 23, "Artist", 200000, "Jim CO"));
        employeeList.add(new Employee("Jake", 26, "Painter", 5000, "Jake CO"));
    }

    Scanner scanner = new Scanner(System.in);
    public void mainMenu() {
        while (true)
        {
            System.out.println("What would you like to do?");
            System.out.println("1. View Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Save.");
            System.out.println("0. Quit");

            // We don't need to create a scanner and such in C#, just Console.ReadLine() to get user input.
            String input = scanner.nextLine();

            // switch-case statements are the same.
            switch (input)
            {
                case "1":
                    ViewEmployees();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    Save();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Not applicable");
                    break;
            }
        }
    }

    private void Save() {
        // Implement this later.
    }

    private void ViewEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee.getDescription());
        }
    }
}

// Addad a comment on main!