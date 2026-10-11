package com.napier.devops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Produces salary reports for employees with a selected job title. */
public class SalaryByRole {
    private static final String SQL =
            "SELECT e.emp_no, e.first_name, e.last_name, t.title, s.salary " +
            "FROM employees e " +
            "JOIN salaries s ON e.emp_no = s.emp_no AND s.to_date = '9999-01-01' " +
            "JOIN titles t ON e.emp_no = t.emp_no AND t.to_date = '9999-01-01' " +
            "WHERE t.title = ? " +
            "ORDER BY e.emp_no ASC";

    /**
     * Returns employees with a current salary and the requested current title.
     * Database connection settings can be supplied with DB_URL, DB_USER, and DB_PASSWORD.
     */
    public List<Employee> getEmployeesByRole(String role) throws SQLException {
        String url = System.getenv().getOrDefault(
                "DB_URL", "jdbc:mysql://localhost:33060/employees?useSSL=false");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "example");

        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, role);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    Employee employee = new Employee();
                    employee.emp_no = results.getInt("emp_no");
                    employee.first_name = results.getString("first_name");
                    employee.last_name = results.getString("last_name");
                    employee.title = results.getString("title");
                    employee.salary = results.getInt("salary");
                    employees.add(employee);
                }
            }
        }
        return employees;
    }
}
