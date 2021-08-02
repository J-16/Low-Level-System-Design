package com.company.taxi;

import java.util.*;

public class taxiAllocator {

    private final int fixedPrice = 100;
    private final int chargePerKilometer = 10;

    public ArrayList<driver> drivers = taxis.drivers;

    private int getNearByTaxi(char location, char destination, int time){

        int taxiID=0;
        int lowBal = Integer.MAX_VALUE;
        //int min=location;
        int minDis=Integer.MAX_VALUE;
        int availabilityTime = -1;

        for(int i=0; i<drivers.size(); i++){
            if ( minDis >=  Math.abs(location - drivers.get(i).getcurrLocation()) && lowBal >= drivers.get(i).getBalance() && time > drivers.get(i).getAvailabilityTime().get(Calendar.HOUR) ){
                minDis =  Math.abs(location - drivers.get(i).getcurrLocation());
                taxiID = drivers.get(i).getTaxiID();
                lowBal = drivers.get(i).getBalance();
                availabilityTime = 1;
                if( minDis == 0 ) return taxiID;
            }
        }
        if(availabilityTime == -1) return -1;
        return taxiID;
    }


    private int calcPrice(char location, char destination){
        int km = Math.abs(location - destination) -1;
        int total = fixedPrice;
        if(km > 1){
            total = total + chargePerKilometer * km;
        }
        return total;
    }

    private void updateTaxi(String BookingID, long userId, int taxiId, int cost,char location, char destination,int pickuptime, int updatedTime){


        for(int i=0; i<drivers.size(); i++){
            if(taxiId == drivers.get(i).getTaxiID()) {
                System.out.println( taxiId + "  " + drivers.get(i).getTaxiID() );
                drivers.get(i).setcurrLocation(destination);
                drivers.get(i).setBalance(cost);
                drivers.get(i).setAvailabilityTime(updatedTime);
                drivers.get(i).travelHistory.add(new history(BookingID, userId, location, destination,pickuptime, updatedTime, cost));
                break;
            }
        }
    }

    public String bookingIdGenerator(){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder bookingId = new StringBuilder();
        Random random = new Random();
        for(int i=1; i<10;i++){
            int j = (int) (random.nextFloat() * abc.length() );
            bookingId.append(j);
        }
        return bookingId.toString();
    }


    public void book( long userId, char location, char destination, int time) throws InterruptedException {

        //TimeUnit.SECONDS.sleep(5);

        int taxiId = getNearByTaxi(location, destination, time);
        if(taxiId == -1){
            System.out.println("No taxi available at the moment please try again try!");
            return;
        }
        int cost  = calcPrice(location, destination);
        int updatedTime = time + Math.abs(location - destination);
        String BookingId = bookingIdGenerator();
        updateTaxi(BookingId, userId, taxiId, cost,location, destination, time, updatedTime);
        System.out.println("Your taxi is booked successfully..");
        System.out.println("TaxiID : " + taxiId + " Amount to be payed : Rs." + cost);

    }

}
