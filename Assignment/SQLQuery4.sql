/*create function OrderDetail(@SalesOrderID int ,@CurrencyCode char(3), @date date )

returns TABLE
as
return 
	with productDetail
	as
	(
		select * from sales.SalesOrderDetail
		where SalesOrderID = @SalesOrderID
	)
	select  pd.OrderQty
			,pd.ProductID
			,pd.UnitPrice
			,pd.UnitPrice*CurrencyRate.EndOfDayRate as unitPriceConversion
			from productDetail as pd
					,Sales.CurrencyRate

					where CurrencyRate.ToCurrencyCode=@CurrencyCode
					and
					CurrencyRate.CurrencyRateDate=@date
*/

SELECT * FROM OrderDetail(43659, 'CNY', '2005-07-01 00:00:00.000');

select * from Sales.SalesOrderDetail