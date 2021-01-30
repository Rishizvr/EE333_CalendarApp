/*
 * File: Calendar.java
 * Author: Rishi Zaveri sage0@uab.edu
 * Assignment:  sage0-p5 - EE333 Fall 2019
 * Vers: 1.0.0 12/10/2019 rz - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.sage0.sage0.p5;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rishi Zaveri sage0@uab.edu
 */
public class Calendar {
    
    // Properties
    private ArrayList<Activity> activityList = new ArrayList<>();
    private ArrayList<Activity> activityList0Each = new ArrayList<>();
    private ArrayList<Activity> activityList1Each = new ArrayList<>();
    private ArrayList<Activity> formattedActivityList = new ArrayList<>();
    
    // Constructor
    public Calendar(ArrayList activityList) {
        this.activityList = activityList;
        
        formatActivityList0Each();
        formatActivityList1Each();
        
        formattedActivityList.addAll(activityList0Each);
        formattedActivityList.addAll(activityList1Each);
        
    }
    
    // Methods
    
    // try to make two array lists and combine them
    public void formatActivityList0Each() {
        for(Activity activity : activityList) {
            if(activity.getIntYear() == 0) {
                activityList0Each.add(activity);
            }
        }
        for(Activity activity : activityList) {
            if(activity.getYear().equals("each")) {
                activityList0Each.add(activity);
            }
        }
        
        sortByIntMonth(activityList0Each);
        
    }
    
    public void formatActivityList1Each() {
        for(Activity activity : activityList) {
            if(activity.getIntYear() == 1) {
                activityList1Each.add(activity);
            }
        }
        for(Activity activity : activityList) {
            if(activity.getYear().equals("each")) {
                activityList1Each.add(activity);
            }
        }
        
        sortByIntMonth(activityList1Each);
        
    }
    
    
    
    public void add(Activity activity) {
        this.activityList.add(activity);
    }
    
    public void sortByIntMonth(ArrayList<Activity> activityList) {
        
        int activity1Index = 0;
        int activity2Index = 1;
        int whileLoopsNeeded = howManyLoops(activityList.size() - 1);
        int whileLoopIteration = 1;
        
        while(whileLoopIteration <= whileLoopsNeeded) {
            
            if (activity2Index > activityList.size() - 1) {
                activity1Index = 0;
                activity2Index = 1;
            } else {
                // empty
            }
            
            if (activityList.get(activity1Index).getIntMonth() > activityList.get(activity2Index).getIntMonth()) {
                Collections.swap(activityList, activity1Index, activity2Index);
            }
            
            activity1Index++;
            activity2Index++;
            whileLoopIteration++;
        }
    }
    
    public void sortByIntYear(ArrayList<Activity> activityList) {
        
        int activity1Index = 0;
        int activity2Index = 1;
        int whileLoopsNeeded = howManyLoops(activityList.size() - 1);
        int whileLoopIteration = 0;
        
        while(whileLoopIteration < whileLoopsNeeded) {
            
            if (activity2Index > activityList.size() - 1) {
                activity1Index = 0;
                activity2Index = 1;
            } else {
                // empty
            }
            
            if (activityList.get(activity1Index).getIntYear() > activityList.get(activity2Index).getIntYear()) {
                Collections.swap(activityList, activity1Index, activity2Index);
            }
            
            activity1Index++;
            activity2Index++;
            whileLoopIteration++;
        }
    }
    
    /*
    public void formatCalendar() {
        // see if there are "each" values and get index of the first activity that has it
        int element = 0;
        int idxEach = 0;
        boolean idxEachExists = false;
        for(Activity activity : activityList) {
            if(activity.intYear == 10) {
                idxEachExists = true;
                idxEach = element;
                break; // exit loop
            }
            element++;
        }
        
        // see if there are "1" values and get index of the first activity that has it
        int element2 = 0;
        int idx1 = 0;
        boolean idx1Exists = false;
        for(Activity activity : activityList) {
            if(activity.intYear == 1) {
                idx1Exists = true;
                idx1 = element2;
                break; // exit loop
            }
            element2++;
        }
        
        // format if there are "1" and "each" values
        if((idxEachExists == true) && (idx1Exists == true)) {
            
            while(idxEach <= activityList.size() - 1) {
                activityList.add(idx1, activityList.get(idxEach));
                idx1++; // move up one element because the activityList increased in size (+1)
                idxEach+=2; // move up two elements because acitivityList increased in size (+1) and we need next element
            }
            
        }
        
    }

*/
    
    private int howManyLoops(int number) {
        // Uses "n + n-1 + n-2... + 0" number of loops to completely sort activityList
        for (int c = number-1; c != 0; c--) {
            number += c;
        }
        
        return(number);
    }
    
    public ArrayList<Activity> getFormattedActivityList() {
        return formattedActivityList;
    }

}
