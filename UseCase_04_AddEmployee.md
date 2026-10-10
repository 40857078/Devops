Use Case 4: Add New Employee
Actor: HR Advisor
Goal: Add new employee details
Value: Ensure new employee is paid
Basic Flow:
1. Select add employee option
2. Connect DB
3. INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (...)
4. Confirm insertion
5. Display confirmation / new record
Alternate: DB failure / duplicate ID -> error + log
Pre: DB running, HR advisor logged in
Post: New employee record created, confirmation shown
