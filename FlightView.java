package flightsearch;

import java.util.ArrayList;

/**
 * Created by Ritik on 24/03/21.
 */
public class FlightView {

    public void viewFlights(ArrayList<FlightModel> flightList)
    {
        System.out.println("\n \t\t ***** FLIGHT INFORMATION *****");
        System.out.println("FLIGHT_NO|DEP_LOC        |ARR_LOC        |VALID_TILL | FARE     |DURATION|");
        for(FlightModel f:flightList)
        {
            System.out.print(" "+f.getFlightNum());
            System.out.print("\t |\t"+f.getDepartLoc());
            System.out.print("\t |\t"+f.getArrivalLoc());
            System.out.print("\t |"+f.getDate());
            System.out.print(" | "+f.getFare());
            System.out.println("\t|  "+f.getDuration()+"\t |");
    }
    if(flightList.isEmpty())
    {
        System.out.println("Flights Not Available.");
    }
    }
}