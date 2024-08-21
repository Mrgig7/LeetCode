/* Write your PL/SQL query statement below */
select employeeuni.unique_id, employees.name from
employeeuni
right join 
employees on
employeeuni.id = employees.id;