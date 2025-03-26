package ui;

import java.util.Iterator;

import model.*;

// The TamaDrawer class wil handle drawing all of the other classes outputs into
// the console so that the user can see and and respond to prompts

public class TamaDrawer {

    //Effects: Creates a new instance of TamaDrawer
    public TamaDrawer() {

    }

    //Effects: Prints empty lines to clear the terminal for the user
    public void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //Effects: Prints the default position of the TamaPet
    public void tamaDefault(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( o.o )  Hello!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("                | " + tamaPet.getName() + " | ");
        System.out.println();
        printMenuOptions();
    }

    //Effects: Prints the happy position of the TamaPet
    public void tamaHappy(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( ^_^ )  <3!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("                | " + tamaPet.getName() + " | ");
        System.out.println();
        printMenuOptions();
    }
    
    //Effects: Prints the sad position of the TamaPet
    public void tamaSad(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( >_< )  @&%$?#!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("                | " + tamaPet.getName() + " | ");
        System.out.println();
        printMenuOptions();
    }

    //Effects: Prints the stats of the tama pet to the console
    public void tamaStats(TamaPet tamaPet) {
        System.out.println();
        System.out.print("Satiation: " + tamaPet.getSatiation());
        System.out.print(" | ");
        System.out.print("Happiness " + tamaPet.getHappieness());
        System.out.println();
        System.out.println("Type ENTER to return to the main menu");
    }

    //Requires: foodmenu is not null
    //Effects: Prints the food menu to the console
    public void printFoodMenu(FoodMenu foodmenu) {
        for (int i = 0; i < foodmenu.getsize(); i++) {
            System.out.println(i + ". " + foodmenu.getTamaFood(i).getName());
            System.out.println("Happiness: " + foodmenu.getTamaFood(i).getHappieness());
            System.out.println("Nutrition: " + foodmenu.getTamaFood(i).getNutrition());
            System.out.println();
        }
        System.out.println("Select the number you would like");
    }

    //Requires: tamaPet is not null
    //Effects: Decides the proper version of the TamaPet to print
    public void printTamaEmotion(TamaPet tamaPet) {
        if (tamaPet.getHappieness() >= 70) {
            tamaHappy(tamaPet);
        } else if (tamaPet.getHappieness() <= 30) {
            tamaSad(tamaPet);
        } else {
            tamaDefault(tamaPet);
        }
    }

    //Requires: historylog is not null
    //Effects: Prints the history log of the TamaPet
    public void printHistoryLog(HistoryLog historylog) {
        for (int i = 0; i < historylog.getSize(); i++) {
            System.out.println(i + ". " + historylog.getTamaHistory(i).getName());
            System.out.println("Description: " + historylog.getTamaHistory(i).getDesc());
            System.out.println("Date and Time: " + historylog.getTamaHistory(i).getDateAndTime());
            System.out.println();
        }
        System.out.println("Type ENTER to return to the main menu");
    }

    //Effects: Prints the menu options for the TamaHandler
    public void printMenuOptions() {
        System.out.println("Type (Feed | Play | History | Stats | Save | Load | Quit) To Interact");
    }

    //Effects: Prints the logged history events to the console
    public void printLoggedEvents() {
        EventLog el = EventLog.getInstance();
        int i = 1;
        for (Event curr : el) {
            System.out.println("Event: " + i);
            System.out.println(curr.toString());
            System.out.println("");
            i++;
        }
        
    }
}
