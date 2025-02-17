package ui;

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

    //Requires: tamaPet is not null
    //Effects: Prints the default position of the TamaPet displaying mood and stats
    public void tamaDefault(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( o.o )  Hello!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("Satiation: " + tamaPet.getSatiation());
        System.out.print(" | " + tamaPet.getName() + " | ");
        System.out.print("Happiness " + tamaPet.getHappieness());
        System.out.println();
        System.out.println();
        System.out.println("Type (Feed | Play | History | Quit) To Interact");
    }

    //Requires: tamaPet is not null
    //Effects: Prints the happy position of the TamaPet displaying mood and stats
    public void tamaHappy(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( ^_^ )  <3!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("Satiation: " + tamaPet.getSatiation());
        System.out.print(" | " + tamaPet.getName() + " | ");
        System.out.print("Happiness " + tamaPet.getHappieness());
        System.out.println();
        System.out.println();
        System.out.println("Type (Feed | Play | History | Quit) To Interact");
    }
    
    //Requires: tamaPet is not null
    //Effects: Prints the sad position of the TamaPet displaying mood and stats
    public void tamaSad(TamaPet tamaPet) {
        clear();
        System.out.println("                  /\\_/\\  ");
        System.out.println("                 ( >_< )  @&%$?#!");
        System.out.println("                 >  ~  <  ");
        System.out.println("                 /|   |\\  ");
        System.out.println("                (_|   |_) ");
        System.out.print("Satiation: " + tamaPet.getSatiation());
        System.out.print(" | " + tamaPet.getName() + " | ");
        System.out.print("Happiness " + tamaPet.getHappieness());
        System.out.println();
        System.out.println();
        System.out.println("Type (Feed | Play | History | Quit) To Interact");
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
        System.out.println("Type anything to return to the main menu");
    }

}
