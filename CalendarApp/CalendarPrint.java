/*
 * File: CalendarPrint.java
 * Author: Rishi Zaveri sage0@uab.edu
 * Assignment:  sage0-p5 - EE333 Fall 2019
 * Vers: 1.0.0 11/05/2019 rz - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.sage0.sage0.p5;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Rishi Zaveri sage0@uab.edu
 */
public class CalendarPrint { // Process csv text file data
    
    private String year = null;
    private int intYear = 0;
    private String month = null;
    private int intMonth = 0;
    private String role = null;
    private String description = null;
    
    private int lineNumber = 0;
    
    private ArrayList<Activity> activityList = new ArrayList<>();
    private ArrayList<Activity> formattedActivityList = new ArrayList<>();
    
    // Constructor
    public CalendarPrint(String filePath) {
        
        if (filePath.endsWith(".txt")) {
            File file = new File(filePath);
            
            try {
                
                Scanner input = new Scanner(file);
                input.useDelimiter(",");
                
                while(input.hasNextLine()) {
                    String stringLine = input.nextLine();
                    lineNumber++;
                    
                    String[] tokens = stringLine.split(",", 4);
                    
                    if(tokens.length != 4) {
                        this.formatError();
                        System.out.println("Each line must have 4 items");
                        // skip while iteration
                        continue; // does not create activity object for this line
                    }
                    
                    year = tokens[0];
                    month = tokens[1];
                    role = tokens[2];
                    description = tokens[3];
                    
                    // Year Formatting
                    
                    if (year.toLowerCase().trim().equals("even")) {
                        intYear = 0;
                    } else if(year.toLowerCase().trim().equals("odd")) {
                        intYear = 1;
                    } else if(year.toLowerCase().trim().equals("each")) {
                        intYear = 10;
                    } else {
                        
                        this.formatError();
                        System.out.println("Year value must be \"even\", \"odd\", or \"each\".\n");
                    }
                    
                    // Month Formatting + Make Activity Objects
                    String[] monthTokens = month.split("/");
                    int monthTokensCount = monthTokens.length;
                    
                    for(int idx = 0; idx < monthTokensCount; idx++ ) {
                        
                        intMonth = monthToIntMonth(monthTokens, idx);
                        
                        this.activityList.add(new Activity(year, intYear, monthTokens[idx], intMonth, role, description));
                        
                    }
                }
                
                Calendar cal = new Calendar(activityList);
                
                formattedActivityList = cal.getFormattedActivityList();
                generateCalendar(formattedActivityList);
                
                input.close();
                
            } catch (FileNotFoundException ex) {
                System.out.printf("ERROR: %s\n", ex);
            }

        } else {
            System.out.println("Wrong file type. Must use .txt file.");
        }
        
        
    }
    
    // Methods
    public void formatError() {
        System.out.printf("Incorrect file format on line:  %d\n", lineNumber);
    }
    
    public int monthToIntMonth(String[] monthTokens, int idx) {
        // month to intMonth conversion
        if (monthTokens[idx].toLowerCase().trim().equals("january")) {
            return 1;
        } else if (monthTokens[idx].toLowerCase().trim().equals("february")) {
            return 2;
        } else if (monthTokens[idx].toLowerCase().trim().equals("march")) {
            return 3;
        } else if (monthTokens[idx].toLowerCase().trim().equals("april")) {
            return 4;
        } else if (monthTokens[idx].toLowerCase().trim().equals("may")) {
            return 5;
        } else if (monthTokens[idx].toLowerCase().trim().equals("june")) {
            return 6;
        } else if (monthTokens[idx].toLowerCase().trim().equals("july")) {
            return 7;
        } else if (monthTokens[idx].toLowerCase().trim().equals("august")) {
            return 8;
        } else if (monthTokens[idx].toLowerCase().trim().equals("september")) {
            return 9;
        } else if (monthTokens[idx].toLowerCase().trim().equals("october")) {
            return 10;
        } else if (monthTokens[idx].toLowerCase().trim().equals("november")) {
            return 11;
        } else if (monthTokens[idx].toLowerCase().trim().equals("december")) {
            return 12;
        } else {
            return 0;
        }
    }
    
    public void generateCalendar(ArrayList<Activity> activityList) {
        
        System.out.printf("| %5s | %15s | %35s | %-120s |\n", "Year", "Month", "Role", "Description");
        System.out.println("-----------------------------------------------------------------------------");
        
        for(Activity activity : activityList) {
            
            if (activity.getIntYear() == 1 || activity.getIntYear() == 0) {
                System.out.printf("| %5d | %3d | %9s | %35s | %-120s |\n", activity.getIntYear(),
                                                            activity.getIntMonth(),
                                                            activity.getMonth(),
                                                            activity.getRole(),
                                                            activity.getDesc());
            } else if(activity.getIntYear() == 10) {
                System.out.printf("| %5s | %3d | %9s | %35s | %-120s |\n", activity.getYear(),
                                                            activity.getIntMonth(),
                                                            activity.getMonth(),
                                                            activity.getRole(),
                                                            activity.getDesc());
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("IEE Region 3 Calendar (Two-Year Cycle)\n\n");
    }
    
}
