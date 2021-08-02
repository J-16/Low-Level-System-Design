package com.company.taxi;

public class history {


    //TravelDetails
    private String BookingID;
    private long CustomerID;
    private char from;
    private char to;
    private int pickupTime;
    private int dropTime;
    private int tripAmount;

    public history(String BookingID, long customerID, char from, char to, int pickupTime, int dropTime, int tripAmount){
        this.BookingID = BookingID;
        this.CustomerID = customerID;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.tripAmount = tripAmount;
    }

    public void setBookingID(){

    }
    public String getBookingID(){
        return BookingID;
    }

    public void setCustomerID(){

    }
    public long getCustomerID(){
        return CustomerID;
    }

    public void setFrom(){

    }
    public char getFrom(){
        return from;
    }

    public void setTo(){

    }
    public char getTO(){
        return to;
    }

    public void setPickupTime(){

    }
    public int getPickupTime(){
        return pickupTime;
    }

    public void setDropTime(){

    }
    public int getDropTime(){
        return dropTime;
    }

    public void setTripAmount(){

    }
    public int getTripAmount(){
        return tripAmount;
    }

}
