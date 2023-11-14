package org.example;

public class Employee {
    private String name;
    private int age;
    private String occupation;
    private int salary;
    private String company;

    public Employee(String name, int age, String occupation, int salary, String company) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.company = company;
    }

    public String getCSV() {
        return name + "," + age + "," + occupation
                    + "," + salary + "," + company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return getName() + "," + getAge() + "," +
                getOccupation() + "," + getSalary() + "," + getCompany();
    }
}
