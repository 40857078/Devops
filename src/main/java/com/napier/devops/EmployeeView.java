package com.napier.devops;

import java.sql.*;

public class EmployeeView {
    private Connection con;

    public void connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
        con = DriverManager.getConnection(url, "root", "password");
        System.out.println("Connected");
    }

    public void disconnect() throws Exception {
        con.close();
    }

    public Employee getEmployee(int ID) throws Exception {
        Statement stmt = con.createStatement();
        String sql = "SELECT e.emp_no, e.first_name, e.last_name, " +
                "t.title, s.salary, d.dept_name, " +
                "CONCAT(m.first_name, ' ', m.last_name) AS manager " +
                "FROM employees e " +
                "JOIN titles t ON e.emp_no = t.emp_no AND t.to_date = '9999-01-01' " +
                "JOIN salaries s ON e.emp_no = s.emp_no AND s.to_date = '9999-01-01' " +
                "JOIN dept_emp de ON e.emp_no = de.emp_no AND de.to_date = '9999-01-01' " +
                "JOIN departments d ON de.dept_no = d.dept_no " +
                "JOIN dept_manager dm ON de.dept_no = dm.dept_no AND dm.to_date = '9999-01-01' " +
                "JOIN employees m ON dm.emp_no = m.emp_no " +
                "WHERE e.emp_no = " + ID;
        ResultSet rset = stmt.executeQuery(sql);
        if (rset.next()) {
            Employee emp = new Employee();
            emp.emp_no = rset.getInt("emp_no");
            emp.first_name = rset.getString("first_name");
            emp.last_name = rset.getString("last_name");
            emp.title = rset.getString("title");
            emp.salary = rset.getInt("salary");
            emp.dept_name = rset.getString("dept_name");
            emp.manager = rset.getString("manager");
            return emp;
        }
        return null;
    }
}
