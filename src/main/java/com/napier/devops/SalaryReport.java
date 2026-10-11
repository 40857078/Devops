package com.napier.devops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Produces a report containing every employee's current salary. */
public class SalaryReport {
    private static final String SQL =
            "SELECT e.emp_no, e.first_name, e.last_name, s.salary " +
            "FROM employees e " +
            "JOIN salaries s ON e.emp_no = s.emp_no " +
            "WHERE s.to_date = '9999-01-01' " +
            "ORDER BY e.emp_no ASC";

    /**
     * Returns all employees with a current salary, ordered by employee number.
     * Database connection settings can be supplied with DB_URL, DB_USER, and DB_PASSWORD.
     */
    public List<Employee> getAllSalaries() throws SQLException {
        String url = System.getenv().getOrDefault(
                "DB_URL", "jdbc:mysql://localhost:33060/employees?useSSL=false");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "example");

        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                Employee employee = new Employee();
                employee.emp_no = results.getInt("emp_no");
                employee.first_name = results.getString("first_name");
                employee.last_name = results.getString("last_name");
                employee.salary = results.getInt("salary");
                employees.add(employee);
            }
        }
        return employees;
    }
}
