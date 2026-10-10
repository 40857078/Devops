Use Case 6: View Employee Record
Actor: HR Advisor or Department Manager
Goal: View an employee's record
Value: Support promotion request
Basic Flow:
1. Select view option
2. Connect DB
3. SELECT ... WHERE e.emp_no = ID
4. Display employee details (name, title, salary, dept, manager)
5. Confirm view complete
Alternate: DB failure -> error + log; employee not found -> message
Pre: DB running, user logged in
Post: Employee details shown on screen
