package com.napier.devops;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        runSalaryByRole(args);
    }

    private static void runSalaryByRole(String[] args) {
        String role;
        int firstTitleArgument = args.length > 0 && "salary-by-role".equalsIgnoreCase(args[0]) ? 1 : 0;
        if (args.length > firstTitleArgument) {
            role = String.join(" ", Arrays.copyOfRange(args, firstTitleArgument, args.length)).trim();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter job title: ");
            role = scanner.nextLine().trim();
        }

        if (role.isEmpty()) {
            System.err.println("A job title is required.");
            return;
        }

        try {
            List<Employee> employees = new SalaryByRole().getEmployeesByRole(role);
            if (employees.isEmpty()) {
                System.out.println("No current employees found with title: " + role);
                return;
            }

            System.out.printf("Salary report for role: %s%n", role);
            System.out.printf("%-10s %-20s %-20s %-30s %12s%n",
                    "Employee", "First name", "Last name", "Title", "Salary");
            for (Employee employee : employees) {
                System.out.printf("%-10d %-20s %-20s %-30s %,12d%n",
                        employee.emp_no, employee.first_name, employee.last_name,
                        employee.title, employee.salary);
            }
        } catch (SQLException exception) {
            System.err.println("Unable to produce the salary report because the database query failed.");
            System.err.println(exception.getMessage());
        }
    }
}
