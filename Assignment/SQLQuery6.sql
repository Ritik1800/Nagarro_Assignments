--select * from Production.Product as p

create trigger on_updateListPrice
on Production.Product
after update
as
begin
	update Production.Product
	set ListPrice = IIF((i.ListPrice-d.ListPrice)>(d.ListPrice*0.15),d.listprice,i.listprice )
	from 
	deleted as d , Product as p
	inner join inserted as i on i.ListPrice=p.ListPrice

	select * from inserted
	select * from deleted

end


alter trigger on_updateListPrice
on Production.Product
after update
as
BEGIN
	IF UPDATE(ListPrice)
		BEGIN
			update Production.Product
			set ListPrice = IIF((i.ListPrice-d.ListPrice)>(d.ListPrice*0.15),d.listprice,i.listprice )
			from 
			deleted as d , Product as p
			inner join inserted as i on i.ListPrice=p.ListPrice
		END
END

update Production.Product
set ListPrice=3000
where ProductID=761

select ListPrice from Production.Product
where ProductID=761 


