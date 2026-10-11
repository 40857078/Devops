Use Case 4: Salary Report by Role
Actor: HR Advisor
Goal: Produce a salary report for employees with a given role
Value: Support financial reporting of the organisation
Basic Flow:
1. Select the salary-by-role report option
2. Connect to the database
3. Choose a job title
4. Run a salary query for current employees with that title
5. Format and display the report
Alternate: Database failure -> show an error and log the failure; no matching employees -> show an empty-result message
Pre: Database running, HR advisor logged in
Post: Salary report for the selected role is displayed
