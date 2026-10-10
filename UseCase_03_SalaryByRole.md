Use Case 3: Salary Report by Job Title
Actor: Department Manager
Goal: Produce salary report for employees by role
Value: Department financial planning
Basic Flow:
1. Select role report option
2. Connect DB
3. Run SELECT ... WHERE t.title = 'RoleName'
4. Format results
5. Display / print
Alternate: DB failure -> error + log
Pre: DB running, manager logged in
Post: Role report shown, save/export available
