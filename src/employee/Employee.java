package employee;

import java.util.Objects;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: employee
 * Project Name: JavaPracticalExam
 * Date: 18-03-2021
 */

public class Employee {
    private int empID;
    private String name;
    private long mobileNumber;
    private String email;

    public Employee(int empID, String name, long mobileNumber, String email) {
        this.empID = empID;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empID == employee.empID && mobileNumber == employee.mobileNumber && Objects.equals(name, employee.name) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, name, mobileNumber, email);
    }

    @Override
    public String toString() {
        return "Employee Id: " + empID +
                "\nName: " + name + "\n" +
                "Mobile Number: " + mobileNumber +
                "\nEmail: " + email + "\n " + "*".repeat(100);
    }
}
