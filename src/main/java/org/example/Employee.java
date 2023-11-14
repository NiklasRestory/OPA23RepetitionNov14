package org.example;

public class Employee extends ObjectWithId {
    private String name;
    private int age;
    private String occupation;
    private int salary;
    private String company;

    static int nextId = 1;

    // This constructor should be used when reading in already existing employees.
    // They have a set id, and we take that and send along to the id-containing class.
    public Employee(int id, String name, int age, String occupation, int salary, String company) {
        super(id);
        // The automatically generated id then must be adjusted.
        // The id should always be unique. So if the id is equal or higher than the id we read in,
        // that means we should adjust the nextId, the id of the next item to be created.
        if (id >= nextId) {
            nextId = id + 1; // If we get someone with the id 8, we set the nextId to 9.
        }
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.company = company;
    }
    // This constructor is used when we create new items.
    // The id is automatically given by nextId, and then nextId increases by 1.
    // The newest item will always be given the highest id.
    public Employee(String name, int age, String occupation, int salary, String company) {
        super(nextId);
        nextId++;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.company = company;
    }

    public String getCSV() {
        return getId() + "," + name + "," + age + "," + occupation
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
        return getId() +","+ getName() + "," + getAge() + "," +
                getOccupation() + "," + getSalary() + "," + getCompany();
    }
}
