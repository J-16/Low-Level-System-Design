package com.company.geolocation;

import java.util.ArrayList;

public class locationDb {

    public static ArrayList<location> locations;

    public static void locationDb(){

        locations = new ArrayList<location>();
        location loc1 = new location("A");
        location loc2 = new location("B");
        location loc3 = new location("C");
        location loc4 = new location("D");
        location loc5 = new location("F");
        location loc6 = new location("E");
        location loc7 = new location("G");

        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        locations.add(loc5);
        locations.add(loc6);
        locations.add(loc7);
    }


}
