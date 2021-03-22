package main;

import connection.DatabaseConnection;
import employee.Employee;
import querySource.DataSource;

import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: Main
 * Project Name: JavaPracticalExam
 * Date: 18-03-2021
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase();
        int choice;
        boolean isProcess = true;
        while (isProcess){
            instruction();
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> addRecord();
                case 2 -> updateRecord();
                case 3 -> viewRecordById();
                case 4 -> showAllRecords();
                case 5 -> isProcess = false;
            }
        }
    }

    private static void showAllRecords() {
        DataSource.showAllRecords(DatabaseConnection.getConnection());
    }

    private static void viewRecordById() {
        System.out.println("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        DataSource.viewRecordByEmployeeId(DatabaseConnection.getConnection(), id);
    }

    private static void updateRecord() {
        System.out.println("Enter field of employee to be updated: ");
        String field = scanner.nextLine();
        System.out.println("Enter value to be placed: ");
        String value = scanner.nextLine();
        System.out.println("Enter employee id of employee whose data has to be updated: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        DataSource.updateEmployee(DatabaseConnection.getConnection(), field,value,id);
    }

    private static void addRecord() {
        System.out.println("Enter employee Id: ");
        int empID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter name of employee: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone Number of employee: ");
        long number = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Email of employee: ");
        String email = scanner.nextLine();
        DataSource.addNewEmployee(DatabaseConnection.getConnection(), new Employee(empID,name,number,email));
    }

    private static void instruction(){
        System.out.println("Press between 1 to 5 to do the following operations\n" +
                            "1. Add new Record\n" +
                            "2. Update a record\n" +
                            "3. View Record By ID\n" +
                            "4. Show All Records\n" +
                            "5. Exit");
    }
}
