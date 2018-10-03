SELECT D.Name AS Department, E.Name AS Employee, E.Salary
FROM Department AS D, Employee AS E
WHERE ( SELECT COUNT(DISTINCT(Salary))
        FROM Employee
        WHERE DepartmentId = D.Id AND Salary > E.salary) < 3
    AND E.DepartmentId = D.Id
    ORDER BY E.DepartmentId, E.Salary DESC;