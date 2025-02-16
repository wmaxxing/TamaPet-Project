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
        System.out.println("Type (Feed | Play | History) To Interact");
    }

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

    //Effects: Prints the food menu to the console
    public void printFoodMenu(FoodMenu foodmenu) {
        for (int i = 0; i < foodmenu.getsize(); i++) {
            System.out.println(i + ". " + foodmenu.getTamaFood(i).getName());
            System.out.println("Happieness: " + foodmenu.getTamaFood(i).getHappieness());
            System.out.println("Nutrition: " + foodmenu.getTamaFood(i).getNutrition());
            System.out.println();
        }
        System.out.println("Select the number you would like");
    }

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

    //Effects: Prints the history log of the TamaPet
    public void printHistoryLog(HistoryLog historylog) {
        
    }

}
