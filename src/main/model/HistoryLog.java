package model;

import java.util.ArrayList;

// The HistoryLog class respersents a list of TamaHistory events that will show a log of
// all interactions with the TamaPet

public class HistoryLog {

    private ArrayList<TamaHistory> historyList;

    //Effects: Creates a History Log object that stores all histories for the TamaPet
    public HistoryLog() {
        historyList = new ArrayList<TamaHistory>();
    }

    //Effects: returns the TamaHistory element at index of the list
    public TamaHistory getTamaHistory(int index) {
        return historyList.get(index);

    }

    //Modifies: this
    //Effects: Adds an element to the HistoryLog
    public void addTamaHistory(TamaHistory add) {
        historyList.add(add);
    }

    //Effects: Returns the size of the History log
    public int getSize() {
        return historyList.size();
    }
    
    //Requires: type is not null, if type == "Feed" then FoodMenu Size > index >= 0, 
    // if type =/= "Feed" then index can be anything
    //Modifies: this
    //Effects: Creates a new TamaHistory object based upon the action performed described by the string
    public void newTamaHistory(String type, int index) {
        if (type.equalsIgnoreCase("Feed")) {
            FoodMenu tempmenu = new FoodMenu();
            TamaHistory curr;
            curr = new TamaHistory("Feed", "The TamaPet was fed a " + tempmenu.getTamaFood(index).getName());
            historyList.add(curr);
        } 
        else { // This is not a else if block due to an error with vscode code coverage test
            TamaHistory curr = new TamaHistory("Play", "The TamaPet was played with");
            historyList.add(curr);
        } 
    }
}
