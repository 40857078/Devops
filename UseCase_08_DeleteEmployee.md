Use Case 8: Delete Employee Record
Actor: HR Advisor
Goal: Delete an employee record
Value: Data retention compliance
Basic Flow:
1. Select delete option
2. Connect DB
3. SELECT ... WHERE e.emp_no = ID (verify exists)
4. DELETE FROM employees WHERE emp_no = ID
5. Confirm deletion
Alternate: DB failure / record not found -> error + log
Pre: DB running, HR advisor logged in, record exists
Post: Record removed, confirmation shown
