package com.napier.devops;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        if (args.length > 0 && "salary-by-role".equalsIgnoreCase(args[0])) {
            runSalaryByRole(args);
            return;
        }

        runMongoExample();
    }

    private static void runSalaryByRole(String[] args) {
        String role;
        if (args.length > 1) {
            role = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length)).trim();
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

    private static void runMongoExample() {
        MongoClient mongoClient = new MongoClient("localhost");
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "Kevin Sim")
                .append("class", "DevOps")
                .append("year", "2024")
                .append("result", new Document("CW", 95).append("EX", 85));
        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        mongoClient.close();
    }
}
