/*
 * File: Activity.java
 * Author: Rishi Zaveri sage0@uab.edu
 * Assignment:  sage0-p5 - EE333 Fall 2019
 * Vers: 1.0.0 11/03/2019 rz - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.sage0.sage0.p5;

/**
 *
 * @author Rishi Zaveri sage0@uab.edu
 */
public class Activity {

    // Variables
    private String year = null;
    private int intYear = 0; //even = 0, odd = 1, or each
    private String month = null; //January - December
    private int intMonth = 0; //
    private String role = null;
    private String description = null;
    
    // Constructors
    
    public Activity(String year, int intYear, String month, int intMonth, String role, String activityDesc) {
        this.year = year;
        this.intYear = intYear;
        this.month = month;
        this.intMonth = intMonth;
        this.role = role;
        this.description = activityDesc;
        
    }
    
    // Methods
    public void setYear(String year) {
        this.year = year;
        
        if (year.toLowerCase().trim().equals("even")) {
            intYear = 0;
        } else if(year.toLowerCase().trim().equals("odd")) {
            intYear = 1;
        } else if(year.toLowerCase().trim().equals("each")) {
            intYear = 10;
        } else {
            System.out.println("ERROR: Year value must be \"even\", \"odd\", or \"each\".\n");
        }
    }
    public void setMonth(String month) {
        this.month = month;
        
        // also sets intMonth based on month
        if (month.toLowerCase().trim().equals("january")) {
            intMonth = 1;
        } else if (month.toLowerCase().trim().equals("february")) {
            intMonth = 2;
        } else if (month.toLowerCase().trim().equals("march")) {
            intMonth = 3;
        } else if (month.toLowerCase().trim().equals("april")) {
            intMonth = 4;
        } else if (month.toLowerCase().trim().equals("may")) {
            intMonth = 5;
        } else if (month.toLowerCase().trim().equals("june")) {
            intMonth = 6;
        } else if (month.toLowerCase().trim().equals("july")) {
            intMonth = 7;
        } else if (month.toLowerCase().trim().equals("august")) {
            intMonth = 8;
        } else if (month.toLowerCase().trim().equals("september")) {
            intMonth = 9;
        } else if (month.toLowerCase().trim().equals("october")) {
            intMonth = 10;
        } else if (month.toLowerCase().trim().equals("november")) {
            intMonth = 11;
        } else if (month.toLowerCase().trim().equals("december")) {
            intMonth = 12;
        }
    }
    
    public String getYear() {
        return this.year.toLowerCase().trim();
    }
    
    public int getIntYear() {
        return this.intYear;
    }
    
    public String getMonth() {
        return this.month;
    }
    
    public int getIntMonth() {
        return this.intMonth;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public String getDesc() {
        return this.description;
    }
    
    /*
    private String year = null;
    private int intYear = 0; //even = 0, odd = 1, or each
    private String month = null; //January - December
    private int intMonth = 0; //
    private String role = null;
    private String description = null;
    */
    
}
