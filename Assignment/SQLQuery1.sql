
-- Assignment 1

/*
1.	Display the number of records in the [SalesPerson] table.  
*/

select count(*)NumberOfRecords from Sales.SalesPerson

/*
2.	Select both the FirstName and LastName of records from the
Person table where the FirstName begins with the letter ‘B’
*/

select FirstName,LastName from Person.Person
where FirstName like 'B%'

/*

3.	Select a list of FirstName and LastName for employees where 
Title is one of Design Engineer, Tool Designer or Marketing Assistant.
(Schema(s) involved: HumanResources, Person)
*/

select Person.person.FirstName,Person.person.LastName,HumanResources.Employee.JobTitle from Person.Person inner join HumanResources.Employee
on Person.Person.BusinessEntityID=HumanResources.Employee.BusinessEntityID
where JobTitle in('Tool Designer','Marketing Assistant','Design Engineer')

/*
4.	Display the Name and Color of the Product with the maximum weight.
*/
select Name,Color from Production.Product
where Weight=(select max(weight) from Production.Product)

/*
5.	Display Description and MaxQty fields from the SpecialOffer table. 
Some of the MaxQty values are NULL, in this case display the value 0.00 instead
*/

select Description,ISNULL(MaxQty,0.00) from Sales.SpecialOffer

select Description,coalesce(MaxQty,0.00) from Sales.SpecialOffer


/*
6.	Display the overall Average of the [CurrencyRate].[AverageRate] values for the 
exchange rate ‘USD’ to ‘GBP’ for the year 2005 i.e. FromCurrencyCode = ‘USD’ and 
ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 'Average exchange rate for the day.'
(Schema(s) involved: Sales)
*/

select avg(AverageRate) from Sales.CurrencyRate
where FromCurrencyCode='USD' and ToCurrencyCode='GBP' and datepart(YEAR from ModifiedDate)=2005 

/*
7.	Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’.
Display an additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)
*/

select ROW_NUMBER() over(order by FirstName) as Sequence_number, FirstName,LastName from Person.Person
where FirstName like '%ss%'

/*

8.	Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
CommissionPct	Commission Band
0.00	Band 0
Up To 1%	Band 1
Up To 1.5%	Band 2
Greater 1.5%	Band 3

Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above
*/


select BusinessEntityID
	,CommissionPct
	,'Band'=  Case when CommissionPct = 0 then 'band 0'
				   when CommissionPct > 0 and CommissionPct <= 0.01 then 'band 1'
				   when CommissionPct > 0.01 and CommissionPct <= 0.015 then 'band 2'
				   when CommissionPct > 0.015 then 'band 3' end
	from Sales.SalesPerson

/*

9.	Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez

*/

DECLARE @ID int;
SELECT @ID = BusinessEntityID 
FROM Person.Person 
WHERE FirstName = 'Ruth' 
	AND LastName = 'Ellerbrock'
	AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;

/*

10.	Display the ProductId of the product with the largest stock level.
Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. (Schema(s) involved: Production)

*/

select ProductID from Production.Product
where dbo.ufnGetStock(ProductID)=(select max(dbo.ufnGetStock(ProductID)) from Production.Product)




