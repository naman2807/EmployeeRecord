package querySource;

import employee.Employee;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: querySource
 * Project Name: JavaPracticalExam
 * Date: 18-03-2021
 */

public class DataSource {
    private static final String EMPLOYEE = "employee";
    private static final String EMP_ID = "emp_id";
    private static final String NAME = "name";
    private static final String MOBILE = "mobile";
    private static final String EMAIL = "email";

    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO " + EMPLOYEE + " VALUES(?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE TABLE " + EMPLOYEE + "SET ? = ? WHERE " + EMP_ID + " = ?";
    private static final String VIEW_RECORD_QUERY = "SELECT * FROM " + EMPLOYEE + " WHERE " + EMP_ID + " = ?";
    private static final String VIEW_ALL_RECORDS_QUERY = "SELECT * FROM " + EMPLOYEE;

    public static void addNewEmployee(Connection connection, Employee employee){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_QUERY);
            preparedStatement.setInt(1, employee.getEmpID());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, String.valueOf(employee.getMobileNumber()));
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Record added Successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Some error occurred");
        }
    }

    public static void updateEmployee(Connection connection, String recordToBeUpdated, String newValue, int empID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, recordToBeUpdated);
            preparedStatement.setString(2, newValue);
            preparedStatement.setInt(3, empID);
            preparedStatement.executeUpdate();
            System.out.println("Record Updated Successfully.");
        } catch (SQLException e) {
            System.err.println("Some error occurred");
        }
    }

    public static void viewRecordByEmployeeId(Connection connection, int empID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_RECORD_QUERY);
            preparedStatement.setInt(1, empID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                long number = Long.parseLong(resultSet.getString(3));
                String email = resultSet.getString(4);
                Employee employee = new Employee(id,name,number,email);
                System.out.println(employee);
            }
        } catch (SQLException e) {
            System.err.println("Some error occurred");
        }
    }

    public static void showAllRecords(Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_ALL_RECORDS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                long number = Long.parseLong(resultSet.getString(3));
                String email = resultSet.getString(4);
                Employee employee = new Employee(id,name,number,email);
                System.out.println(employee);
            }
        } catch (SQLException e) {
            System.err.println("Some error occurred");
        }
    }
}

























