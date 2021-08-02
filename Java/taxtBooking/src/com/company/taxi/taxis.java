package com.company.taxi;

import java.util.ArrayList;
import java.util.HashMap;

public class taxis {

    public static ArrayList<driver> drivers;

    //Cache for location
    //ArrayList to ArrayList

    public static HashMap<String, driver> driverHistory = new HashMap<>();

    public taxis(){
        drivers = new ArrayList<driver>();
        driver driver1 = new driver(1001, 'A', 7);
        driver driver2 = new driver(1002, 'A', 7);
        driver driver3 = new driver(1003, 'A', 7);
        driver driver4 = new driver(1004, 'A', 7);

        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        drivers.add(driver4);
    }

}
