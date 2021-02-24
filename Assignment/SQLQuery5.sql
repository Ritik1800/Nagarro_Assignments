/*Write a Procedure supplying name information from the Person.
Person table and accepting a filter for the first name.
Alter the above Store Procedure to supply Default Values if user does not enter any value*/

-- creating procedure
create proc person.sp_getname
@type char(2) 
as
BEGIN
	select * from Person.Person
	where PersonType =@type
end

--executing procedure
exec person.sp_getname @type='EM'

--alter procedure
alter proc person.sp_getname
@type char(2)='EM' 
as
BEGIN
	select * from Person.Person
	where PersonType = @type
end

exec Person.sp_getname @type='IN' --executing procedure with parameter
exec Person.sp_getname			   --executing procedure with default values
