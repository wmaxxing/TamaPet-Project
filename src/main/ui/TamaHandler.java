package ui;

import model.*;
import java.util.Scanner;

// The TamaHandler class will handle all input coming from the console and allow the 
public class TamaHandler {

    private boolean isRunning;
    private TamaDrawer tamaDrawer;
    private TamaPet tamaPet;
    private Scanner input;
    private String commands;
    private HistoryLog historyLog;

    //Modifies: this
    //Effects: Creates a new instance of the TamaHander class
    public TamaHandler() {
        isRunning = true;
        tamaDrawer = new TamaDrawer();
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        tamaDrawer.clear();
        System.out.println("What would you like to name your TamaPet?");
        String name = null;
        name = input.next();
        tamaPet = new TamaPet(name);
        historyLog = new HistoryLog();
        tamaRunner();
    }

    //Modifies: this
    //Effects: Runs the main loop of the TamaProgram
    public void tamaRunner() {
        tamaDrawer.tamaDefault(tamaPet);

        while (isRunning) {
            commands = input.next();
            commands = commands.toLowerCase();
            processCommands(commands);
        }
    }

    //Modifies: this
    //Effects: Processes the incoming command and outputs the desired menu
    private void processCommands(String command) {
        if (command.equals("feed")) {
            tamaDrawer.clear();
            FoodMenu tempmenu = new FoodMenu();
            tamaDrawer.printFoodMenu(tempmenu);
            int index = input.nextInt();
            tamaPet.tamaFeed(tempmenu.getTamaFood(index));
            tamaDrawer.clear();
            tamaDrawer.printTamaEmotion(tamaPet);
            historyLog.addTamaHistory(new TamaHistory("Feed", "The TamaPet was fed a " + tempmenu.getTamaFood(index).getName()));
        } else if (command.equals("play")) {
            boolean curr = tamaPet.tamaPlay();
            if (curr) {
                historyLog.addTamaHistory(new TamaHistory("Play", "The TamaPet was played with"));
                tamaDrawer.clear();
                tamaDrawer.printTamaEmotion(tamaPet);
                System.out.println("You sucessfully played with the tama pet");
            } else if (!curr) {
                tamaDrawer.clear();
                tamaDrawer.printTamaEmotion(tamaPet);
                System.out.println("The TamaPet does not have enough satiation to play");
            } 
        } else if (command.equals("history")) {

        } else if (command.equals("quit")) {
            isRunning = false;
        } else {
            System.out.println("Please Try Another Command (Feed | Play | History | Quit)");
            commands = input.next();
            commands = commands.toUpperCase();
            processCommands(commands);
        }
    }
}
