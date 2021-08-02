package com.company.users;

import java.util.ArrayList;
import java.util.HashMap;

public class userDb {


    private ArrayList<Long> userDB = new ArrayList<>();

    private ArrayList<String> bookingHistory;

    public void setUser(Long mobileNumber){
        userDB.add(mobileNumber);
    }

    public boolean isValidUser(long mobileNO){
        return userDB.contains(mobileNO);
    }

}
