package com.company.taxi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class driver {

    private int taxiID;
    private char currLocation;
    private boolean isAvailable;
    private Calendar availabilityTime;
    private int balance;

    public ArrayList<history> travelHistory;

    public driver(int taxiID, char curLocation, int availabilityTime ){
        travelHistory = new ArrayList<>();
        this.taxiID = taxiID;
        this.currLocation = curLocation;
        this.balance = 0;
        this.availabilityTime = getTime(availabilityTime);
    }

    public int getTaxiID(){
        return taxiID;
    }

    public char getcurrLocation(){
        return currLocation;
    }

    public void setcurrLocation(char currLocation){
        this.currLocation = currLocation;
    }

    public Calendar getAvailabilityTime(){
        return availabilityTime;
    }

    public void setAvailabilityTime(int availabilityTime){
        this.availabilityTime = getTime( this.availabilityTime.get(Calendar.HOUR) - availabilityTime);
    }

    public void setBalance(int balance){
        this.balance = this.balance + balance;
    }

    public int getBalance(){
        return balance;
    }

    public Calendar getTime(int availabilityTime){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, availabilityTime);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.AM_PM, Calendar.AM);

        return c;
    }





}
