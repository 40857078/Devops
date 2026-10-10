Use Case 2: Salary Report by Department
Actor: HR Advisor
Goal: Produce salary report for employees in a department
Value: Support department financial reporting
Basic Flow:
1. Select department report option
2. Connect DB
3. Run SELECT ... WHERE d.dept_name = 'DepartmentName'
4. Format results
5. Display / print
Alternate: DB failure -> error + log
Pre: DB running, HR advisor logged in
Post: Department report shown, save/export available
