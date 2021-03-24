package flightsearch;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Ritik on 24/03/21.
 */
public class FlightModel {

    private String flightNum;
    private String departLoc;
    private String arrivalLoc;
    private String date;
    private int fare;
    private float duration;

    public FlightModel(){}

    public FlightModel(String flightNum, String departLoc, String arrivalLoc, String date, int fare, float duration) {
        this.flightNum = flightNum;
        this.departLoc = departLoc;
        this.arrivalLoc = arrivalLoc;
        this.date = date;
        this.fare = fare;
        this.duration = duration;
    }

    public String getFlightNum()
    {
        return flightNum;
    }
    public void setFlightNum(String flightNum)
    {
        this.flightNum=flightNum;
    }

    public String getDepartLoc()
    {
        return departLoc;
    }
    public void setDepartLoc(String departLoc)
    {
        this.departLoc=departLoc;
    }

    public String getArrivalLoc()
    {
        return arrivalLoc;
    }
    public void setArrivalLoc(String arrivalLoc)
    {
        this.arrivalLoc=arrivalLoc;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date=date;
    }

    public int getFare()
    {
        return fare;
    }
    public void setFare(int fare)
    {
        this.fare=fare;
    }

    public float getDuration()
    {
        return duration;
    }
    public void setDuration(float duration)
    {
        this.duration=duration;
    }

}