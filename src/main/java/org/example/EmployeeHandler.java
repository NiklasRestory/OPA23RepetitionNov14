package org.example;

import java.io.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHandler {
    ArrayList<Employee> employeeList = new ArrayList<>();
    ArrayList<Shop> shopList = new ArrayList<>();

    public EmployeeHandler() {
        folder.mkdir(); // Creates a directory.
        if (!employeeFile.exists()) { // If employees-file doesn't exist, create some objects.
            employeeList.add(new Employee("Jim", 23, "Artist", 200000, "Jim CO"));
            employeeList.add(new Employee("Jake", 26, "Painter", 5000, "Jake CO"));
        }
        else {
            Load();
        }
    }


    // I have added a comment!
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
                    AddEmployee();
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

    private void AddEmployee() {
        try {
            System.out.println("Input name:");
            String name = scanner.nextLine();
            System.out.println("Input age:");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Input occupation:");
            String occupation = scanner.nextLine();
            System.out.println("Input salary: ");
            int salary = Integer.parseInt(scanner.nextLine());
            System.out.println("Input company: ");
            String company = scanner.nextLine();

            Employee e = new Employee(name, age, occupation, salary, company);
            employeeList.add(e);
        }
        catch (Exception e) {
            System.out.println("That needed a number.");
        }
    }

    File folder = new File("folder");
    File employeeFile = new File("folder/employees.txt"); // Path is the folders on the way to the file as well as the file-name.
    // To save, we want to have the files prepared. File-objects take the path
    // where the file is located and then loads those in. These files are then taken by the FileWriter/FileReader.
    private void Save() {
        try {
            // FileWriter creates a stream to the file we're writing to.
            FileWriter fw = new FileWriter(employeeFile);
            BufferedWriter bw = new BufferedWriter(fw); // BufferedWriter takes that stream and writes using it.
            for(Employee employee : employeeList) {
                bw.write(employee.getCSV()); // Loops through all employees and writes their CSV.
                bw.newLine(); // Creates a new line.
            }
            bw.close();
        } catch (IOException e) {

        }
    }
    // CSV works in the way that each individual row is one object.
    // In that row, each variable is separated by a single sign. Like a comma.

    private void Load() {
        try {
            // FileReader opens a stream for reading to the indicated file.
            // It only reads byte-arrays, however, so we use BufferedReader to actually read strings.
            FileReader fr = new FileReader(employeeFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); // readLine gives the next line in the file, or null if there is none.
            while (line != null) {
                try {
                    // The line is a row of values separated by ",". I use split to make a string-array for the different things.
                    String[] strings = line.split(",");

                    // I know exactly where each of the values are stored and in what order.
                    // After split, I can retrieve each one by one.
                    int id = Integer.parseInt(strings[0]);
                    String name = strings[1];
                    int age = Integer.parseInt(strings[2]);
                    String occupation = strings[3];
                    int salary = Integer.parseInt(strings[4]);
                    String company = strings[5];

                    // Then I can create an object using them.
                    Employee employee = new Employee(id, name, age, occupation, salary, company);
                    employeeList.add(employee);
                }
                catch (Exception e) {

                }

                line = br.readLine();
            }
        } catch (IOException e) {

        }
    }

    private void ViewEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee.getDescription());
        }
    }
}

// Addad a comment on main!