SELECT DEPARTMENT_NAME || q'[ Department Manager's ID: ]' || MANAGER_ID AS "Department and Manager" FROM DEPARTMENTS d;

SELECT SYSDATE AS "Current Date" FROM DUAL;

SELECT 2+2*4 FROM DUAL;
--DUAL is one row table used for executing sysdate like cmds

SELECT FIRST_NAME || ' '  || LAST_NAME AS "FULL NAME" FROM EMPLOYEES e;

SELECT  CONCAT(LAST_NAME, JOB_ID) AS HELLO FROM EMPLOYEES e ;

SELECT CONCAT(LAST_NAME, CONCAT('is a', JOB_ID)) AS RANDOM FROM EMPLOYEES e ; 

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE JOB_ID IN ('AD_VP', 'IT_PROG');

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE FIRST_NAME LIKE '_a%';

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE FIRST_NAME LIKE '__e%';

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE SALARY  > 1200
ORDER BY SALARY DESC;

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE SALARY > 1200
ORDER BY SALARY DESC, JOB_ID ASC;

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID 
FROM EMPLOYEES e 
WHERE SALARY > 1200
ORDER BY JOB_ID ASC, SALARY DESC;

SELECT * FROM ACCOUNT a;

--------------Assignment-------------
SELECT * FROM ACCOUNT a
WHERE EXTRACT (DAY FROM AOD) > 15;

SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP 
FROM DUAL;

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE, SYSDATE, MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12
FROM EMPLOYEES e;

SELECT ROUND(SYSDATE - HIRE_DATE) 
FROM EMPLOYEES e;

SELECT HIRE_DATE,LAST_DAY(HIRE_DATE)
FROM EMPLOYEES e;

----DD-Mon-YYYY, DD-MM-YYYY, DD-MM-YY
SELECT LAST_NAME, TO_CHAR(HIRE_DATE, 'DD-MM-YYYY')
FROM EMPLOYEES e 
WHERE HIRE_DATE < TO_DATE('01-03-14', 'DD-MM-RR'); 

---------------------NVL---------------------------
----problem
SELECT FIRST_NAME, SALARY, 12 * SALARY * COMMISSION_PCT AS "Annual Salary"
FROM EMPLOYEES e;

----solution
SELECT FIRST_NAME, SALARY, NVL(COMMISSION_PCT, 0) AS "Commission", SALARY + (SALARY * NVL(COMMISSION_PCT,0)/100) AS "Monthly Salary",
(SALARY + (SALARY * NVL(COMMISSION_PCT,0)/100))*12 AS "Annual Salary"
FROM EMPLOYEES e;

-------------------COALESCE-------------------------
SELECT FIRST_NAME, COALESCE (COMMISSION_PCT, MANAGER_ID, SALARY) 
FROM EMPLOYEES e;

SELECT last_name, salary, commission_pct,
COALESCE ((salary + (commission_pct * salary)), salary + 2000)
AS New_Salary
FROM EMPLOYEES e;
-------------------Aggregate Funs--------------------
SELECT COUNT(COMMISSION_PCT) 
FROM EMPLOYEES e;

SELECT MANAGER_ID, ROUND(AVG(SALARY)) 
FROM EMPLOYEES e 
GROUP BY MANAGER_ID;

SELECT DEPARTMENT_ID,MANAGER_ID , COUNT(SALARY)
FROM EMPLOYEES e 
GROUP BY DEPARTMENT_ID, MANAGER_ID 
ORDER BY COUNT(SALARY) DESC;

SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEES e 
WHERE DEPARTMENT_ID > 40
GROUP BY DEPARTMENT_ID, JOB_ID 
HAVING SUM(SALARY) > 10000
ORDER BY DEPARTMENT_ID;

SELECT JOB_ID, SUM(SALARY) 
FROM EMPLOYEES e 
HAVING SUM(SALARY) > 5000
GROUP BY JOB_ID 
ORDER BY SUM(SALARY) DESC;

---------------------JOINS-------------------------

---------Natural Join

SELECT  FIRST_NAME, JOB_TITLE 
FROM EMPLOYEES e 
NATURAL JOIN JOBS j ;

----------EQUI JOIN OR INNER JOIN

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
JOIN DEPARTMENTS d 
USING (DEPARTMENT_ID);

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
JOIN DEPARTMENTS d 
USING (MANAGER_ID);

SELECT *
FROM EMPLOYEES e 
NATURAL JOIN DEPARTMENTS d, JOBS j, JOB_HISTORY jh, LOCATIONS l, COUNTRIES c,REGIONS r;

------------------ON

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
JOIN DEPARTMENTS d 
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

----------------OUTER JOIN

-------LEFT OUTER JOIN (ALL THE EMPLOYEES WITH OR WITHOUT A DEPARTMENT WILL BE SHOWN)

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d 
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

-------RIGHT OUTER JOIN (ALL THE DEPARTMENTS WITH OR WITHOUT A EMPLOYEES WILL BE SHOWN)

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
RIGHT OUTER JOIN DEPARTMENTS d 
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

-------FULL OUTER JOIN (ALL THE EMPLOYEES AND DEPARTMENT WILL BE SHOWN)

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e 
FULL OUTER JOIN DEPARTMENTS d 
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

----------SELF JOIN

SELECT e2.FIRST_NAME || ' reports to ' || e1.FIRST_NAME
FROM EMPLOYEES e1 JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID ;

---------CROSS JOIN

SELECT * FROM EMPLOYEES e CROSS JOIN DEPARTMENTS d;

----------------------------SUB QUERY------------------------------

SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES e 
WHERE HIRE_DATE < 
(SELECT HIRE_DATE FROM EMPLOYEES e2 WHERE LOWER(FIRST_NAME) = 'neena')
ORDER BY HIRE_DATE;

SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES e 
WHERE JOB_ID =
(SELECT JOB_ID FROM EMPLOYEES e2 WHERE LOWER(FIRST_NAME) = 'neena');

SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES e 
WHERE HIRE_DATE IN 
(SELECT HIRE_DATE FROM EMPLOYEES e2 WHERE LOWER(FIRST_NAME) = 'david')
ORDER BY HIRE_DATE;

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES e 
WHERE SALARY  < 
(SELECT AVG(SALARY) FROM EMPLOYEES e2)
ORDER BY SALARY DESC;


----------Problem 5

SELECT c.CUSTID, c.FNAME, a.ACNUMBER, a.AOD
FROM CUSTOMER c FULL OUTER JOIN ACCOUNT a
ON (c.CUSTID = a.CUSTID)
WHERE EXTRACT (DAY FROM AOD) > 15;

----------Problem 6

SELECT * FROM CUSTOMER c ;


---------Problem 7

SELECT  c.CITY, COUNT(b.BID) AS "Count_Branch"
FROM CUSTOMER c FULL OUTER JOIN ACCOUNT a
ON  
;


---------Problem 8

SELECT a.ACNUMBER, c.FNAME, c.LTNAME
FROM ACCOUNT a FULL OUTER JOIN CUSTOMER c 
ON (c.CUSTID = a.CUSTID)
WHERE a.ASTATUS = 'Active';


-------------------------DML-----------------------------

---------------------UPDATE 

UPDATE EMPLOYEES 
SET SALARY = SALARY + SALARY 0.25
WHERE FIRST_NAME = 'Neena';

SELECT * FROM EMPLOYEES e WHERE FIRST_NAME = 'Neena';




-----------------COMMITS----------------------------

SELECT FIRST_NAME, SALARY 
FROM EMPLOYEES e 
WHERE EMPLOYEE_ID = 100;

UPDATE EMPLOYEES 
SET SALARY  = SALARY + 1000
WHERE EMPLOYEE_ID = 100;

ROLLBACK;

SELECT FIRST_NAME, SALARY 
FROM EMPLOYEES e 
WHERE EMPLOYEE_ID = 100;

UPDATE EMPLOYEES 
SET SALARY  = SALARY - 30000
WHERE EMPLOYEE_ID = 100;

SELECT FIRST_NAME, SALARY 
FROM EMPLOYEES e 
WHERE EMPLOYEE_ID = 100;


----------Problem 9

SELECT CUSTID, FNAME, BID, LOAN_AMOUNT
FROM CUSTOMER c NATURAL JOIN LOAN l;

----------Problem 10

SELECT c.CUSTID, c.FNAME, a.ACNUMBER 
FROM CUSTOMER c FULL OUTER JOIN ACCOUNT a 
ON (c.CUSTID = a.ACNUMBER) 
WHERE a.ASTATUS = 'Terminated';


----------------------DDL---------------------------------
DROP TABLE DEPT1;

CREATE TABLE DEPT1
(
	deptId NUMBER CONSTRAINT pkdeptId1 PRIMARY KEY,
	departmentName varchar2(20) NOT NULL,
	email varchar(20) CONSTRAINT emailUnique UNIQUE,
	gender varchar(20) CONSTRAINT genderCheck CHECK (gender IN ('Male', 'Female')),
	hire_date DATE DEFAULT sysdate
);


CREATE TABLE DEP
(
	deptId NUMBER,
	departmentName varchar2(20) NOT NULL,
	email varchar(20) ,
	hire_date DATE DEFAULT sysdate
);
SELECT  * FROM DEPT1 d;

DELETE  FROM DEPT1 d;

INSERT INTO dep(deptId, departmentName, email, HIRE_DATE)
	SELECT DEPARTMENT_ID, DEPARTMENT_NAME, EMAIL, HIRE_DATE 
	FROM EMPLOYEES e NATURAL JOIN DEPARTMENTS d;

INSERT INTO DEPT1 VALUES (2, 'HR', 'fandom@mail.com', 'Female', default);

ALTER TABLE DEPT1 DROP COLUMN gender ;

SELECT * FROM DEPT1;

CREATE TABLE DEPT2 
(
	deptId NUMBER CONSTRAINT pkdeptId1 PRIMARY KEY,
	hire_date DATE DEFAULT sysdate
);

CREATE TABLE DEPT3
(
	deptId NUMBER,
	hire_date DATE DEFAULT sysdate,
	CONSTRAINT pkdeptId2 PRIMARY KEY(deptId)
);

CREATE TABLE orders
(
	orderId NUMBER,
	shipmentId NUMBER,
	CONSTRAINT pk1 PRIMARY key(orderId,shipmentId)
)

INSERT INTO orders values(2,2)

SELECT * FROM orders;

----------------------------------FK-------------------------------

CREATE TABLE emp1 
(
	empId NUMBER PRIMARY KEY,
	empName varchar(20),
	deptId NUMBER
)

INSERT INTO emp1 VALUES (1009, 'Neha', 99);

UPDATE EMP1 SET DEPTID = 2;

SELECT * FROM EMP1;

ALTER TABLE EMP1 ADD CONSTRAINT fkdeptId1 FOREIGN KEY (deptId) REFERENCES dept1(deptId) ON DELETE CASCADE;

INSERT INTO emp1 VALUES (1131, 'Avnnie', 5);

INSERT INTO DEPT1 VALUES(5, 'Tech', 'samp@mail.com', default);


DELETE  FROM DEPT1 WHERE DEPTID = 2;

ALTER TABLE EMP1 DROP CONSTRAINT fkdeptId1;

---------------------------------SEQUENCE---------------------------

CREATE SEQUENCE dept_deptId_seq
				START WITH 1
				INCREMENT BY 1
				MAXVALUE 69
				NOCACHE
				NOCYCLE;

DROP SEQUENCE dept_deptId_seq;
			
INSERT INTO DEPT1 VALUES (dept_deptId_seq.NEXTVAL, 'IT', 'caala@mail.com', DEFAULT);

SELECT  * FROM dept1;

SELECT dept_deptId_seq.CURRVAL FROM DUAL;

ALTER SEQUENCE dept_deptId_seq SCALE EXTEND ;

DELETE FROM DEPT1 d WHERE DEPTID = 4;

CREATE SEQUENCE my_scale_seq1
				MINVALUE 1
				MAXVALUE 9999999999
				SCALE EXTEND;
			
SELECT my_scale_seq1.NEXTVAL AS scale_seq FROM DUAL;			
			
-------------------------------INDEX--------------------------------------

SELECT * FROM EMPLOYEES e WHERE FIRST_NAME LIKE 'T%';

SELECT INDEX_NAME, TABLE_NAME FROM USER_INDEXES WHERE UPPER(TABLE_NAME) = 'EMPLOYEES';

CREATE INDEX emp_last_name_idx ON employees(last_name);

CREATE INDEX emp_first_name_idx ON employees(first_name);

--------------------------------VIEWS--------------------------------------

SELECT * FROM USER_OBJECTS;

SELECT * FROM ALL_OBJECTS;

SELECT * FROM USER_CONSTRAINTS;

SELECT TABLE_NAME FROM USER_TABLES;

SELECT * FROM USER_TAB_COLUMNS;


CREATE OR REPLACE VIEW emp_my_dept
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES e 
WHERE DEPARTMENT_ID = 80
AND (MANAGER_ID = 100 AND SALARY > 10);

SELECT * FROM EMP_MY_DEPT;

SELECT * FROM EMP_MY_DEPT WHERE SALARY > 12000;

UPDATE EMP_MY_DEPT SET DEPARTMENT_ID = 60 WHERE EMPLOYEE_ID = 145;




----------------------------------HANDS-ON 30 MINUTES------------------------------------
CREATE TABLE MEMBER
(
	Member_Id NUMBER(5),
	Member_Name CHAR(25),
	Acc_Open_Date DATE,
	Max_Books_Allowed NUMBER(2),
	Penalty_Amount NUMBER(7,2)
);

CREATE TABLE BOOK 
(
	Book_No NUMBER(6),
	Book_Name VARCHAR2(30),
	Author CHAR(30),
	Cost NUMBER(7,2),
	Category CHAR(10)
);

CREATE TABLE ISSUE 
(
	Lib_Issue_Id NUMBER(10),
	Book_No NUMBER(6),
	Member_Id NUMBER(5),
	Issue_Date DATE,
	Return_Date DATE
);

ALTER TABLE ISSUE ADD (Comments VARCHAR2(100));

ALTER TABLE MEMBER MODIFY (MEMBER_NAME CHAR(30));

ALTER TABLE ISSUE ADD (REFERENCE CHAR(30));

ALTER TABLE ISSUE DROP COLUMN REFERENCE;

ALTER TABLE ISSUE RENAME TO Lib_Issue;

INSERT INTO MEMBER VALUES(1, 'Richa Sharma', '10-Dec-05', 5,50);
INSERT INTO MEMBER VALUES(2, 'Garima Sen', SYSDATE, 3,NULL);
INSERT INTO MEMBER VALUES(3, 'Rohit Jain', NULL, 5,50);
INSERT INTO MEMBER VALUES(4, 'Vishu Kumar', '13-Jun-09', NULL,50);
INSERT INTO MEMBER VALUES(5, 'Ayushi Oberoi', '14-Feb-15', NULL,50);
INSERT INTO MEMBER VALUES(6, 'Sushi Namma', NULL, 5,50);
INSERT INTO MEMBER VALUES(7, 'Pappu Paanwala', '17-Aug-01', 5,NULL);

ALTER TABLE MEMBER MODIFY (MEMBER_NAME CHAR(20));
----cannot decrease column length because some value is too big, already exisiting values are too big

INSERT INTO MEMBER VALUES(8, 'Seemu Paul', '12-Jun-06', 110,NULL);
----value larger than specified precision allowed for this column, value is above the constraint

CREATE TABLE MEMBER101 AS (SELECT * FROM "MEMBER" m);

INSERT INTO BOOK VALUES(101, 'Let us C', 'Denis Ritchie', 450, 'System');
INSERT INTO BOOK VALUES(102, 'Oracle - Complete Ref', 'Loni', 550, 'Database');
INSERT INTO BOOK VALUES(103, 'Mastering SQL', 'Loni', 250, 'Database');
INSERT INTO BOOK VALUES(104, 'PL SQL-Ref', 'Scott Urman', 750, 'Database');

SELECT  * FROM BOOK b;





-------------------------------------------------SCRIPTING PL/SQL--------------------------------------------------------------------------------

-----------ADD TWO NUMBERS
DECLARE
num1 NUMBER := 100;
num2 NUMBER := 200;
res NUMBER := 0;
BEGIN
		res := num1 + num2;
		dbms_output.put_line('The sum is : ' || res);
END;


----------IF ELSE


DECLARE
v_date NUMBER := TO_CHAR(SYSDATE, 'DD');
BEGIN
	IF v_date > 12
	THEN
		dbms_output.put_line('Off Peak');
	ELSE
		dbms_output.put_line('Peak');
	END IF;
END;

BEGIN
	FOR v_loopCounter IN 1..5 LOOP
		dbms_output.put_line('Loop Counter is ' || v_loopCounter);
	END LOOP;
END;

----------------------Table of 9----------------------------------------
DECLARE
tableOf NUMBER := 9;
BEGIN
	FOR i IN 1..10 LOOP
		dbms_output.put_line(tableOf || ' x ' || i || ' = ' || tableOf * i);
	END LOOP;
END;

----------------& operator takes input in sql plus
DECLARE
tableOf NUMBER := &num;
BEGIN
	FOR i IN 1..10 LOOP
		dbms_output.put_line(tableOf || ' x ' || i || ' = ' || tableOf * i);
	END LOOP;
END;


DECLARE
v_fname EMPLOYEES.first_name%type := 'NA';
sal EMPLOYEES.salary%type := 0;
BEGIN
	SELECT first_name,salary INTO v_fname, sal FROM EMPLOYEES e WHERE EMPLOYEE_ID = 101;
	dbms_output.put_line('The first is : ' || v_fname);
	dbms_output.put_line('The salary is : ' || sal);
END;


---VARIABLE :bind_variable NUMBER
---LIKE A GLOBAL VARIABLE

DECLARE 
	num NUMBER := 20;
BEGIN
		IF num > 20 THEN
			dbms_output.put_line('Greater!');
		ELSIF num < 20 THEN 
			dbms_output.put_line('Lesser!');
		ELSE
			dbms_output.put_line('Its ' || num);
		END IF;
END;

  DECLARE
    v_countryid    locations.country_id%TYPE := 'CA';
    v_loc_id       locations.location_id%TYPE;
    v_counter		  NUMBER(2) := 1;
    v_new_city     locations.city%TYPE := 'Montreal';
  BEGIN
    SELECT MAX(location_id) INTO v_loc_id FROM locations
    WHERE country_id = v_countryid;
  -----------------------DO WHILE LOOP
    LOOP
      INSERT INTO locations(location_id, city, country_id)   
      VALUES((v_loc_id + v_counter), v_new_city, v_countryid);
      v_counter := v_counter + 1;
      EXIT WHEN v_counter > 30;
    END LOOP;
  DBMS_OUTPUT.PUT_LINE(v_counter-1||' rows added.');
  END;

  SELECT * FROM LOCATIONS l ;
 
 
---------------------------------------------------------------------------------------------
--------------------CONTINUE-------------------------
DECLARE
  v_total SIMPLE_INTEGER := 0;
BEGIN
  FOR i IN 1..10 LOOP
    v_total := v_total + i;
    DBMS_OUTPUT.PUT_LINE
     ('Total is: '|| v_total);
    CONTINUE WHEN i > 5;
    v_total := v_total + i; 
    DBMS_OUTPUT.PUT_LINE
     ('Out of Loop Total is:
      '|| v_total);    
  END LOOP;
END;


--------------------------------------COLLECTIONS----------------------------------
-------------CREATING RECORD----------------
DECLARE
  TYPE t_rec IS RECORD
    (
	 v_first_name employees.first_name%type,
	 v_sal number(8),
	 v_hire_date employees.hire_date%type,
	 );
  v_myrec t_rec;
 
BEGIN
	SELECT first_name,salary, hire_date INTO v_myrec
      FROM employees WHERE employee_id = 100;
  	  DBMS_OUTPUT.PUT_LINE('First Name: '||v_myrec.v_first_name ||'Salary: '||v_myrec.v_sal ||'Hire Date:
 '|| v_myrec.v_hire_date);
END;

-----------------------%ROWTYPE
DECLARE
  TYPE t_rec IS RECORD
    (v_sal number(8),
     v_minsal number(8) default 1000,
     v_hire_date employees.hire_date%type,
     v_rec1 employees%rowtype);
  v_myrec t_rec;
BEGIN
  v_myrec.v_sal := v_myrec.v_minsal + 500;
  v_myrec.v_hire_date := sysdate;
  SELECT * INTO v_myrec.v_rec1
      FROM employees WHERE employee_id = 100;
  DBMS_OUTPUT.PUT_LINE(v_myrec.v_rec1.last_name ||' '||
  v_myrec.v_hire_date ||' '|| v_myrec.v_sal);
 DBMS_OUTPUT.PUT_LINE('Printing data from db');
  DBMS_OUTPUT.PUT_LINE(v_myrec.v_rec1.last_name ||' '||
  v_myrec.v_rec1.hire_date ||' '|| v_myrec.v_rec1.salary);
END;

SELECT * FROM DEPARTMENTS d WHERE DEPARTMENT_ID = 100;

DECLARE
 TYPE t_rec IS RECORD
 ( 	
	v_rec departments%rowtype
 );
 v_myrec t_rec;
BEGIN
	SELECT * INTO v_myrec.v_rec FROM DEPARTMENTS d WHERE DEPARTMENT_ID = 100;
	dbms_output.put_line('Department Id is : ' || v_myrec.v_rec.department_id);
	dbms_output.put_line('Department Name is : ' || v_myrec.v_rec.department_name);
	dbms_output.put_line('Manager Id is : ' || v_myrec.v_rec.manager_id);
	dbms_output.put_line('Location Id is : ' || v_myrec.v_rec.location_id);
END;

------------With Single Variable

DECLARE
	v_rec departments%rowtype;
BEGIN
	SELECT * INTO v_rec FROM DEPARTMENTS d WHERE DEPARTMENT_ID = 100;
	dbms_output.put_line('-------------------------------------------------------------------------------------------');
	dbms_output.put_line('Department Id is : ' || v_rec.department_id);
	dbms_output.put_line('Department Name is : ' || v_rec.department_name);
	dbms_output.put_line('Manager Id is : ' || v_rec.manager_id);
	dbms_output.put_line('Location Id is : ' || v_rec.location_id);	
	dbms_output.put_line('-------------------------------------------------------------------------------------------');
END;

---------------------------------------------------------------------------------------------------
--------------------ARRAY/ TABLE OF

--------------------Associative Arrays

DECLARE
  TYPE email_table IS TABLE OF
    employees.email%TYPE 
    INDEX BY PLS_INTEGER;
    email_list       email_table; 
BEGIN
   email_list(1) := 'tufailahmedkhan@gmail.com';
  	email_list(2) := 'tarun@gmail.com';
  	email_list(3) := 'neha@gmail.com';
   DBMS_OUTPUT.PUT_LINE(email_list(1)); 
   DBMS_OUTPUT.PUT_LINE(email_list(2)); 
   DBMS_OUTPUT.PUT_LINE(email_list(3)); 
END; 


-----------------------

DECLARE
TYPE dept_table_type IS TABLE OF 
  departments%ROWTYPE 
  INDEX BY PLS_INTEGER;
  dept_table dept_table_type;
  -- Each element of dept_table is a record
BEGIN
   SELECT * INTO dept_table(1) FROM departments 
   WHERE department_id = 10;
   DBMS_OUTPUT.PUT_LINE(dept_table(1).department_id ||' '||
   dept_table(1).department_name ||' '||           
   dept_table(1).manager_id);
END;

-------------------------------------------------
DECLARE
   TYPE emp_table_type IS TABLE OF
      employees%ROWTYPE INDEX BY PLS_INTEGER;
   my_emp_table  emp_table_type;
   max_count         NUMBER(3):= 104; 
BEGIN
  FOR i IN 100..max_count
  LOOP
   SELECT * INTO my_emp_table(i) FROM employees
   WHERE employee_id = i;
  END LOOP;
  FOR i IN my_emp_table.FIRST..my_emp_table.LAST 
  LOOP
     DBMS_OUTPUT.PUT_LINE(my_emp_table(i).last_name);
  END LOOP;
END; 



------------------------------------CURSOR--------------------------------------------------------

DECLARE
	CURSOR my_cursor IS
	SELECT employee_id, first_name, salary
	FROM EMPLOYEES;
	rec my_cursor%rowtype;
BEGIN
	OPEN my_cursor;
	LOOP
		FETCH my_cursor INTO rec;
		dbms_output.put_line('---------------------------------------------------');
		dbms_output.put_line(rec.employee_id);
		dbms_output.put_line(rec.first_name);
		dbms_output.put_line(rec.salary);
	EXIT WHEN my_cursor%NOTFOUND;	
	END LOOP;
END;


------------------CURSOR PARAMS---------------------

DECLARE
	CURSOR emp_name_salary (m_id number) IS
	SELECT employee_id,first_name,salary
	FROM EMPLOYEES WHERE manager_id = m_id;
	employee_record emp_name_salary%rowtype;
BEGIN
	OPEN emp_name_salary(100);
	LOOP
		FETCH emp_name_salary INTO employee_record;
		EXIT WHEN emp_name_salary%NOTFOUND;
		dbms_output.put_line(employee_record.employee_Id || ' ' || employee_record.first_name || ' ' || employee_record.salary || ' ' );
	END LOOP;
	CLOSE emp_name_salary;
	dbms_output.put_line('Printing the details about manager id : 101');
	OPEN emp_name_salary(101);
	LOOP
		FETCH emp_name_salary INTO employee_record;
		EXIT WHEN emp_name_salary%NOTFOUND;
		dbms_output.put_line(employee_record.employee_Id || ' ' || employee_record.first_name || ' ' || employee_record.salary || ' ' );
	END LOOP;
	CLOSE emp_name_salary;
END;


--------------------------EXCEPTION HANDLING-------------------------------------------------

DECLARE
	v_lname varchar2(15);
	searchName varchar2(20) := 'Ayush';
BEGIN
	SELECT last_name INTO v_lname
	FROM EMPLOYEES e 
	WHERE first_name = searchName;
	dbms_output.put_line(searchName || ' last name is ' || v_lname);

	EXCEPTION
	WHEN TOO_MANY_ROWS THEN dbms_output.put_line('There are many ' || searchName);
	WHEN NO_DATA_FOUND THEN dbms_output.put_line('No user with ' || searchName);
	WHEN OTHERS THEN dbms_output.put_line('Some other error occurred!');
END;


--Create a PL-SQL program for retrieving the name and salary of two employees with employee id (say 100 and 101)
--Check whose salary is greater and print the name of the employee who is getting higher salary.
--
--NB : Handle exceptions if no employee exists for a particular employee id
--
--expected output : 
--
--1)steven is getting higher salary than neena
--2)neena is getting higher salary john
--
--20 minutes

DECLARE
	emp1salary NUMBER(8);
	emp2salary NUMBER(8);
	emp1name varchar2(30);
	emp2name varchar2(30);
BEGIN
	SELECT salary, first_name INTO emp1salary, emp1name FROM EMPLOYEES e WHERE EMPLOYEE_ID = 100;
	SELECT salary, first_name INTO emp2salary, emp2name FROM EMPLOYEES e WHERE EMPLOYEE_ID = 101;
	IF emp1salary > emp2salary THEN
		dbms_output.put_line(emp1name || ' is getting higher salary then ' || emp2name);
	ELSE
		dbms_output.put_line(emp2name || ' is getting higher salary then ' || emp1name);
	END IF;
	EXCEPTION
	WHEN NO_DATA_FOUND THEN dbms_output.put_line('NO RECORD FOUND!!!');
END;

--------------------------------------User defined Exception Handling--

DECLARE
	v_lname VARCHAR2(15);

searchName varchar(20) := 'Neena';

sal employees.salary%TYPE;

invalid_salary EXCEPTION;
-- DECLARE THE EXCEPTION
BEGIN
	SELECT
	last_name,
	salary
INTO
	v_lname,
	sal
FROM
	employees
WHERE
	first_name = searchName ;

IF sal < 5000 THEN
    RAISE invalid_salary;
END IF;

DBMS_OUTPUT.PUT_LINE (searchName || ' last name is :' || v_lname);

EXCEPTION
WHEN TOO_MANY_ROWS THEN dbms_output.put_line('There are many ' || searchName );
WHEN NO_DATA_FOUND THEN dbms_output.put_line('No user with ' || searchName);
WHEN invalid_salary THEN dbms_output.put_line('Your salary is invalid in accordance with company policy');
WHEN OTHERS THEN dbms_output.put_line('Some other error occurred');
END;


CREATE OR REPLACE PROCEDURE cal
AS
BEGIN --PROCEDURE BGEIN
	dbms_output.put_line('working function!!');
END; --PROCEDURE END

BEGIN
	cal;
END;

CREATE OR REPLACE PROCEDURE addNumbers
AS
BEGIN --PROCEDURE BGEIN
	DECLARE --WORKING FUNCTION START
		num1 NUMBER := 5;
		num2 NUMBER := 10;
	BEGIN
		dbms_output.put_line(num1 + num2);
	END; --WORKING FUNCTION END
END; --PROCEDURE END

BEGIN 
	addNumbers;
	cal;
END;


----------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE myTable
( num IN NUMBER )
AS
BEGIN
BEGIN
	FOR i IN 1..10 LOOP
		dbms_output.put_line(num ||' x ' || i || ' = ' || num * i);
	END LOOP;
END;
END;


DECLARE
num NUMBER := &num;
BEGIN
	myTable(num);
END;

--------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE searchEmployee
( num IN NUMBER)
AS
BEGIN
DECLARE
v_fname1 EMPLOYEES.first_name%type := 'NA';
sal1 EMPLOYEES.salary%type :=0;
BEGIN
	SELECT first_name,salary INTO v_fname1,sal1 FROM EMPLOYEES e 
	WHERE EMPLOYEE_ID =num;
	dbms_output.put_line('The first name is : '|| v_fname1);
	dbms_output.put_line('The salary is : '|| sal1);
	EXCEPTION
	WHEN NO_DATA_FOUND THEN dbms_output.put_line('No Record Found!');
	WHEN OTHERS THEN dbms_output.put_line('Some other error!!!');
END;
END;

-------------execute


BEGIN
	searchEmployee(&num);
END;



-----------------------------------------------------------------------------------------------------------------------------------
------------------OUT parameter



CREATE OR REPLACE PROCEDURE query_emp
 (p_id     IN  employees.employee_id%TYPE,
  p_fname  OUT employees.first_name%TYPE,
  p_email   OUT employees.email%TYPE,
  p_salary OUT employees.salary%TYPE,
  p_mid OUT employees.manager_id%TYPE,
  p_deptid OUT employees.department_id%TYPE,
  p_error OUT VARCHAR) IS
BEGIN
  SELECT  first_name, email, salary, manager_id, department_id INTO p_fname, p_email, p_salary, p_mid, p_deptid
  FROM    employees
  WHERE   employee_id = p_id;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN p_error := ('Employee Id ' || p_id || ' does not exist');
END query_emp;

------------executing
CREATE OR REPLACE PROCEDURE display
(
	p_id   IN  employees.employee_id%TYPE
)AS
  v_emp_name employees.last_name%TYPE;
  v_emp_sal  employees.salary%TYPE;
BEGIN
  query_emp(p_id, v_emp_name, v_emp_sal);
  DBMS_OUTPUT.PUT_LINE(v_emp_name||' earns '|| to_char(v_emp_sal, '$999,999.00'));
END display;

--------------------------
BEGIN
	display(101);
END;

---------------------------------------------------------------------------------------------
------------------OUT parameter

CREATE OR REPLACE PROCEDURE query_emp
 (p_id     IN  employees.employee_id%TYPE,
  p_name   OUT employees.last_name%TYPE,
  p_salary OUT employees.salary%TYPE) IS
BEGIN
  SELECT  last_name, salary INTO p_name, p_salary
  FROM    employees
  WHERE   employee_id = p_id;
END query_emp;

------------executing
CREATE OR REPLACE PROCEDURE display
(
	p_id   IN  employees.employee_id%TYPE
)AS
  v_emp_name employees.last_name%TYPE;
  v_emp_sal  employees.salary%TYPE;
BEGIN
  query_emp(p_id, v_emp_name, v_emp_sal);
  DBMS_OUTPUT.PUT_LINE(v_emp_name||' earns '|| to_char(v_emp_sal, '$999,999.00'));
END display;

--------------------------
BEGIN
	display(101);
END;


SELECT * FROM EMPLOYEES e WHERE FIRST_NAME = 'Shubham';
SELECT * FROM DEPARTMENTS d ;

SELECT * FROM PRODUCTS;

 CREATE SEQUENCE user_Seq
  MINVALUE 100
  MAXVALUE 999999999999999999999999999
  START WITH 101
  INCREMENT BY 1
  CACHE 20;
 
SELECT * FROM USERDETAILS;
DROP TABLE USERDETAILS;
SELECT * FROM PRODUCTS;

DELETE FROM products;

CREATE TABLE product200
(
	productId NUMBER,
	productName varchar(20),
	quantityOnHand NUMBER,
	price number
);


SELECT * FROM product200;

CREATE TABLE CUSTOMERS (
	CUSTOMER_ID INT PRIMARY KEY,
	FIRST_NAME VARCHAR2(20),
	LAST_NAME VARCHAR2(20),
	EMAIL_ID VARCHAR2(20),
	PHONE_NUMBER NUMBER(10)
);

SELECT * FROM CUSTOMERS;






































































