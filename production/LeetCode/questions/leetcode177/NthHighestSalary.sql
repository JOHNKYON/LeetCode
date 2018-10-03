CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
      SELECT Salary
      FROM
      (SELECT DISTINCT Salary, ROW_NUMBER() over (ORDER BY Salary DESC) AS row_id
       FROM Employee
       GROUP BY Salary) t
      WHERE t.row_id = @N
    );
END