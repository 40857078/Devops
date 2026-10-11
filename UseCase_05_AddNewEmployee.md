Use Case 5: Add New Employee
Actor: HR Advisor
Goal: Add new employee details
Value: Ensure new employee is paid
Basic Flow:
1. Select add option
2. Connect DB
3. INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (...)
4. Confirm insertion success
5. Show new record / confirmation message
Alternate: DB failure / duplicate emp_no -> error + log
Pre: DB running, HR advisor logged in
Post: New record in DB, confirmation displayed
