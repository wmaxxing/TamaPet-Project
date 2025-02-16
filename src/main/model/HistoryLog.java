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

    //Effects: Adds an element to the HistoryLog
    public void addTamaHistory(TamaHistory add) {
        historyList.add(add);
    }

    //Effects: Returns the size of the History log
    public int getSize(){
        return historyList.size();
    }
    
}
