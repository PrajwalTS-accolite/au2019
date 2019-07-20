use hr;
-- 1. Display the first name and join date of the employees who joined between 2002 and 2005.
select first_name, start_date
from employees, job_history
where start_date > "2002-01-01" and start_date < "2005-12-31";

-- 2. Display details of departments in which the maximum salary is more than 10000.
select D.department_name, max(E.salary) as max_salary,concat(E.first_name,' ',E.last_name) as manager_name , concat(L.street_address,', ',L.postal_code,', ',L.city,', ', L.state_province, ', ', C.country_name) as Address
from departments D, employees E, locations L, countries C 
where D.department_id = E.department_id
and D.manager_id = E.employee_id
and D.location_id = L.location_id
and C.country_id = L.country_id
group by E.department_id
having max(E.salary) > 10000;

-- 3. Display city, departments, number of employee in each department.
select D.department_name, L.city, count(E.employee_id)
from departments D, locations L, employees E
where D.department_id = E.department_id
and L.location_id = D.location_id
group by D.department_id;

-- 4. Display Departments where there are more then 5 employees.
select D.department_name, count(E.employee_id) as no_of_employees,concat(E.first_name,' ',E.last_name) as manager_name , concat(L.street_address,', ',L.postal_code,', ',L.city,', ', L.state_province, ', ', C.country_name) as Address
from departments D, employees E, locations L, countries C 
where D.department_id = E.department_id
and D.location_id = L.location_id
and C.country_id = L.country_id
group by E.department_id
having count(E.employee_id) > 5;

-- Create two tables - Color (Color_id,Color_Name) populate it with 5-6 color data
--                     Sizes (Size_code,Description) e.g.('M',Medium) populate table with sizes XS,S,M,L,XL,XXL.
drop table if exists color ;
create table color(Color_id int, Color_Name varchar(256));

drop table if exists sizes ;
create table sizes (Size_code int,Description varchar(256));

insert into color values(1, 'blue');
insert into color values(2, 'red');
insert into color values(3, 'green');
insert into color values(4, 'magenta');
insert into color values(5, 'cyan');

insert into sizes values(1, 'XS');
insert into sizes values(2, 'S'); 
insert into sizes values(3, 'M'); 
insert into sizes values(4, 'L'); 
insert into sizes values(5, 'XL');
insert into sizes values(6, 'XXL'); 

-- 5 Q) Write Query to Display all possible combinations of color and size.
select Color_Name as Color, Description as Size
from color
cross join sizes;

-- 6) Create a table  Cricket_Match with following columns and populate it with data given. 
-- -------------------------------------
--  Match Player Score
-- -------------------------------------	
--  1      A      0
-- 	1      B      101
-- 	1      C      55
-- 	1      D      23
-- 	1      E      12
-- 	1      F      100
-- 	2      A      146
-- 	2      B      120
-- 	2      C      104
-- 	2      D      3
-- 	2      E      54
-- 	2      F      111
-- ------------------------------------

drop table if exists Cricket_Match;
create table Cricket_Match(Match_ int, Player varchar(256), Score int);

insert into Cricket_Match values(1, 'A', 0);
insert into Cricket_Match values(1, 'B', 101);
insert into Cricket_Match values(1, 'C', 55);
insert into Cricket_Match values(1, 'D', 23);
insert into Cricket_Match values(1, 'E', 12);
insert into Cricket_Match values(1, 'F', 100);
insert into Cricket_Match values(2, 'A', 146);
insert into Cricket_Match values(2, 'B', 120);
insert into Cricket_Match values(2, 'C', 104);
insert into Cricket_Match values(2, 'D', 3);
insert into Cricket_Match values(2, 'E', 54);
insert into Cricket_Match values(2, 'F', 111);

-- 6Q) Write query to display players who have scored century in both the games.
select Player
from Cricket_Match
where Score >= 100
group by Player
having count(*)=2;

-- 6Q) Write query to display players who have scored century in match 1 OR match 2 but not in both.
select Player, Match_ 
from Cricket_Match
where Score >= 100
group by Player
having count(*)=1;

-- 7)  Create a table friend_list(Name, Friend_Name)
-- Populate it with following data:
--         ------------------ 
-- 	Name | Friend_Name 
--         ------------------
-- 	Sam      Ram
-- 	Sam      Vamsi
-- 	Vamsi    Ram
-- 	Vamsi    Jhon
-- 	Ram      Vijay
-- 	Ram      Anand

drop table if exists friend_list;
create table friend_list(Name varchar(256), Friend_Name varchar(256));

insert into friend_list values("Sam","Ram");
insert into friend_list values("Sam","Vamshi");
insert into friend_list values("Vamshi","Ram");
insert into friend_list values("Vamshi","Jhon");
insert into friend_list values("Ram","Vijay");
insert into friend_list values("Ram","Anand");

-- 7 Q)write a query to find friends of friends of sam. 
select f1.Name, f2.Friend_name
from friend_list f1
join friend_list f2
on f1.Friend_name=f2.Name
where f1.Name = "Sam";

-- 8) Create a function to calculate new salary of an employee from hr.employees table by a certain percentage.
--    Two IN parameters (Employee_id,Hike_pct) 
--    One OUT parameter (New_Salary) 

Drop function if exists hiked_new_salary;
DELIMITER //
CREATE FUNCTION hiked_new_salary(Employe_id int,Hike_pct int) returns decimal
deterministic
BEGIN
		DECLARE New_Salary, old_salary float;
        select salary into old_salary from employees where employee_id = Employe_id;
        set New_Salary = old_salary + old_salary * (Hike_Pct /100);
        return New_Salary;
END //

Delimiter ;

select concat(first_name, " ", last_name) as Name, salary as Old_Salary , hiked_new_salary(employee_id, 20) as Hiked_salary
from employees;

-- 9) Create a stored procedure to update the salary of an employee by 13% in hr.employees table.
--   One IN parameter - emp_id 

drop procedure if exists update_hiked_salary;
DELIMITER //
CREATE PROCEDURE update_hiked_salary
(IN emp_id int)
BEGIN
	declare new_salary decimal; 
    set new_salary = hiked_new_salary(emp_id, 13);
  update employees 
  set salary = new_salary
  where employee_id = emp_id;
END //
DELIMITER ;
-- To call the store procedure
Call update_hiked_salary(104);