package com.company;

import com.company.geolocation.location;
import com.company.geolocation.locationDb;
import com.company.taxi.driver;
import com.company.taxi.taxiAllocator;
import com.company.taxi.taxis;
import com.company.users.userDb;

import java.util.*;

public class Main {
    public static taxis taxi = new taxis();

    public static ArrayList<driver> drivers = taxi.drivers;

    private static taxiAllocator taxiAllocator = new taxiAllocator();

    private static userDb userinfo = new userDb();

    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);
        int c;

        do{

            System.out.println("Select any Option: \n" +
                    "1.Book\n"+
                    "2.Cancel\n"+
                    "3.Check history\n" +
                    "4.Check Near By taxi\n" +
                    "5.Enter TaxiID");
            c = s.nextInt();
            switch(c){
                case 1 :
                    System.out.println("ID : ");
                    long mobileNo = s.nextLong();
                    if( userinfo.isValidUser(mobileNo) ){
                        userinfo.setUser(mobileNo);
                    }
                    System.out.println("Enter Location:");
                    char location = s.next().charAt(0);
                    System.out.println("Enter Destination");
                    char destination = s.next().charAt(0);
                    System.out.println("Enter time");
                    int time = s.nextInt();
                    System.out.println("Please Wait while booking your taxi..");
                    if(location == destination) System.out.println("You are already there in the location");
                    else taxiAllocator.book(mobileNo, location, destination, time);
                    break;
                case 2 :
                    System.out.println("Call cancel..");
                    break;
                case 3 :
                    getTravelHistory();
                    break;
                case 4 :
                    getTaxiDetails();
                    break;
                case 5:
                    System.out.println("Enter your Taxi ID:");
                    int id = s.nextInt();
                    getTaxiDetailsById(id);
                    break;
                default:
                    System.out.println("Enter A valid option or 0 to exit");
            }

        }while(c!=0);

    }

    public static void getTaxiDetails(){
        System.out.println( "___________________________________________________________" );
        System.out.println( "|     TAXI ID       |    LOCATION   |     Available TIme  |" );
        System.out.println( "-----------------------------------------------------------" );
        for(int i=0; i<drivers.size();i++){
            Calendar c = drivers.get(i).getAvailabilityTime();
            System.out.println( "|      " + drivers.get(i).getTaxiID() + "         |       "
                    + drivers.get(i).getcurrLocation() + "       |         "
                    + c.get(Calendar.HOUR) + " "
                    + c.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()) + "        |" ) ;
        }
        System.out.println( "-----------------------------------------------------------" );
    }

    public static void getTaxiDetailsById(int id){
        System.out.println( "___________________________________________________________" );
        System.out.println( "|     BookingID      |    CustomerID   |     From   |     To   |      PickUp Time   |     Drop Tme   |     Amount   |" );
        System.out.println( "-----------------------------------------------------------" );
        for(int i=0; i<drivers.size(); i++){
            if( id == drivers.get(i).getTaxiID() ){
                System.out.println( drivers.get(i).getTaxiID() );
                for(int j=0;j<drivers.get(i).travelHistory.size();j++){
                    System.out.println( drivers.get(i).travelHistory.get(j).getBookingID() + " " + drivers.get(i).travelHistory.get(j).getCustomerID() + "  " + drivers.get(i).travelHistory.get(j).getFrom() +  "  " +
                            drivers.get(i).travelHistory.get(j).getTO() + "  " +  drivers.get(i).travelHistory.get(j).getPickupTime() + "  " +  drivers.get(i).travelHistory.get(j).getDropTime() + "  " + drivers.get(i).travelHistory.get(j).getTripAmount() );
                }
            }
        }

    }

    public static void getTravelHistory(){
        System.out.println("IMPLEMENT..");
    }

}
