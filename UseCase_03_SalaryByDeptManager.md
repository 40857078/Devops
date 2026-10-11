Use Case 3: Salary Report for Manager's Department
Actor: Department Manager
Goal: Produce a salary report for employees in the manager's department
Value: Support financial reporting for the manager's department
Basic Flow:
1. Select the department salary report option
2. Connect to the database
3. Identify the manager's department
4. Run a salary query for current employees in that department
5. Format and display the report
Alternate: Database failure -> show an error and log the failure; no department assigned -> show an explanatory message
Pre: Database running, department manager logged in, manager assigned to a department
Post: Salary report for the manager's department is displayed
