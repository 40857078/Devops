Use Case 7: Update Employee Record
Actor: HR Advisor
Goal: Update an employee's details
Value: Keep records current
Basic Flow:
1. Select update option
2. Connect DB
3. SELECT ... WHERE e.emp_no = ID (find record)
4. UPDATE employees SET ... WHERE emp_no = ID
5. Confirm update success
6. Display updated record
Alternate: DB failure / record not found -> error + log
Pre: DB running, HR advisor logged in, employee exists
Post: Record updated, confirmation shown
