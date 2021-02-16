import java.util.Scanner;

abstract class TaxCalculator
{
	protected String itemName;
	protected double itemPrice;
	protected int itemQuantity;
	protected String itemType;
	public void setData(String itemName,double itemPrice,int itemQuantity,String itemType)
	{
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemQuantity=itemQuantity;
		this.itemType=itemType;
	}
	public abstract double getTax();
}
class Raw extends TaxCalculator
{	
	public double getTax()
	{
		double tax=0.0;
		double taxPercent=12.5;
		tax=this.itemPrice*(taxPercent/100);
		return tax*this.itemQuantity;
	}
}

class Manufactured extends TaxCalculator
{
	public double getTax()
	{
		double tax=0.0;
		double taxPercent=12.5;
		double extraPercent=2.0;
		tax=this.itemPrice*(taxPercent/100);
		tax=tax+((tax+this.itemPrice)*(extraPercent/100));
		return tax*this.itemQuantity;
	}
}

class Imported extends TaxCalculator
{
	public double getTax()
	{
		double tax=0.0;
		double importDuty=10.0;
		double surchargeRupee=0.0;
		double surchargePercentage=0.0;
		tax=this.itemPrice*(importDuty/100);
		if((this.itemPrice+tax)<=100)
		{
			surchargeRupee=5.0;
			tax=tax+surchargeRupee;
		}
		else if((this.itemPrice+tax)<=200)
		{
			surchargeRupee=10.0;
			tax=tax+surchargeRupee;
		}
		else
		{
			surchargePercentage=5.0;
			tax=tax+((this.itemPrice+tax)*(surchargePercentage/100));
		}
		return tax*this.itemQuantity;
	}
}
class Invalid extends TaxCalculator
{
	public double getTax()
	{
		System.out.print("Given Type is invalid");
		return 0.0;
	}
}

class ObjectCreater
{
	public TaxCalculator getInstance(String str)
	{
		if(str.trim().equalsIgnoreCase("raw"))
			return new Raw();
		else if(str.trim().equalsIgnoreCase("manufactured"))
			return new Manufactured();
		else if(str.trim().equalsIgnoreCase("imported"))
			return new Imported();
		else
			return new Invalid();
	}
}

public class Application
{
	public static void main(String... args)
	{
		Scanner sc=new Scanner(System.in);
		int flag = 0;
		String itemName="";
		double itemPrice=0.0;
		int itemQuantity=0;
		String itemType="";
		int error=0;
		
		while(true)
		{
			if(flag==1)
			{
				System.out.print("Enter your input here : ");
				String inp=sc.nextLine();
				args=inp.split(" ");

			}
			try 
			{
				itemName=args[0];
				itemPrice=Double.parseDouble(args[1]);
				itemQuantity=Integer.parseInt(args[2]);
				itemType=args[3];	
			}
			catch(NumberFormatException e)
			{
				System.out.println("Number is Required...");
				error=1;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Given data is not sufficient");
				System.out.println("Must enter exactly 4 arguments(item name, item price, item quantity, item type )");
				error=1;
			}
			catch(Exception e) 
			{
				System.out.println("The elements you entered are invalid");
				error=1;
			}
			if(args.length>4)
			{
				System.out.println("Too much data...");
				System.out.println("Must enter exactly 4 arguments(item name, item price, item quantity, item type");
				error=1;
			}
			if(error==1)
			{
				error=0;
				System.out.print("Do you want to enter details of any other item (Y/N) : ");
				String ans=sc.nextLine();
				if(ans.trim().equalsIgnoreCase("y"))
				{
					flag=1;
					System.out.println("You selected yes ");
					continue;
				}
				else if(ans.trim().equalsIgnoreCase("n"))
				{
					System.out.println("You selected no ");
					break;
				}
				else
				{
					System.out.println("Invalid input...");
					break;
				}
				
			}
			
			ObjectCreater osf=new ObjectCreater();
			TaxCalculator calculator= osf.getInstance(itemType);
			calculator.setData(itemName, itemPrice, itemQuantity, itemType);
			double itemTax=calculator.getTax();
			
			if(itemTax>0)
			{
				System.out.println("Item : "+itemName);
				System.out.println("Price : "+(itemPrice*itemQuantity));
				System.out.println("Tax : "+itemTax);
				System.out.println("Final price : "+((itemPrice*itemQuantity)+itemTax));
			}
			
			System.out.print("Do you want to enter details of any other item (Y/N) : ");
			
			
			String ans=sc.nextLine();
			
			
			if(ans.trim().equalsIgnoreCase("y"))
			{
				flag=1;
				System.out.println("You selected yes ");
				continue;
			}
			else if(ans.trim().equalsIgnoreCase("n"))
			{
				System.out.println("You selected no ");
				break;
			}
			else
			{
				System.out.println("Invalid input...");
				break;
			}

		}	
	}
}


