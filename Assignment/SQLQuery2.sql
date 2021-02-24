
-- Assignment 2
/*
Write separate queries using 
a join 
, a subquery
, a CTE, and 
, then an EXISTS to list all AdventureWorks customers who have not placed an order.
*/


--SUB QUERY
SELECT CustomerID FROM Sales.Customer
WHERE CustomerID NOT IN (SELECT CustomerID FROM Sales.SalesOrderHeader);

--EXIST
SELECT c.CustomerID FROM Sales.Customer c
WHERE NOT EXISTS (SELECT s.CustomerID 
				FROM Sales.SalesOrderHeader AS s
				WHERE s.CustomerID = c.CustomerID);


--JOINS
SELECT *
FROM Sales.Customer c
	left JOIN Sales.SalesOrderHeader s ON s.CustomerID = c.CustomerID
WHERE SalesOrderID IS NULL;

--CTE
WITH CustomersWithoutOrder 
AS 
(
	SELECT CustomerID FROM Sales.Customer
	WHERE CustomerID NOT IN (SELECT CustomerID FROM Sales.SalesOrderHeader)
)
SELECT * FROM CustomersWithoutOrder;

