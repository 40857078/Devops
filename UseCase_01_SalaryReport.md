Use Case 1: Salary Report (All Employees)
Actor: HR Advisor
Goal: Produce salary report for all employees
Value: Support financial reporting
Basic Flow:
1. Select option
2. Connect DB
3. Run SELECT ... WHERE to_date = '9999-01-01'
4. Format results
5. Display / print
Alternate: DB failure -> error + log
Pre: DB running, HR advisor logged in
Post: Report shown, save/export available
