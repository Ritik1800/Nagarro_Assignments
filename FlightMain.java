package flightsearch;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Created by Ritik on 24/03/21
*/
public class FlightMain {
   public static void main(String args[]) throws FileNotFoundException, ParseException {

	   
       ReadCSVThread thread=new ReadCSVThread();
       thread.start();
	   
      
       Scanner sc=new Scanner(System.in);
       String dept_loc,arrival_loc,date;
       int choiceCode;
      
       ArrayList<String> CSV_data=ReadCSVThread.getCSVData();     
       System.out.print("Enter Departure Location  : ");
       dept_loc=sc.nextLine().toUpperCase();
       System.out.print("Enter Arrival Location  : ");
       arrival_loc=sc.nextLine().toUpperCase();
       System.out.print("Enter Date   : ");
       date=sc.nextLine().toUpperCase();
       System.out.print("Enter Output Preference :   1. Fare \t 2. Flight Duration \nEnter Preference Choice Code : ");
       choiceCode=sc.nextInt();
       CSV_data=ReadCSVThread.getCSVData();
       FlightController fc=new FlightController();
       fc.searchFlight(CSV_data,dept_loc,arrival_loc,date);
       fc.updateView(choiceCode);
    
   }

}