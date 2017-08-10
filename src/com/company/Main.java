package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Challenge:
    // Create a simple interface that allows an object to be saved to some sort of storage medium.
    // The exact type of medium is not known to the interface (nor to the classes that implement it).
    // The interface will just specify 2 methods, one to return an ArrayList of values to be saved
    // and the other to populate the object's fields from an ArrayList.
    //
    // Create some sample classes that implement your saveable interface (we've used the idea of a game,
    // with Players and Monsters, but you can create any type of classes that you want).
    //
    // Override the toString() method for each of your classes so that they can be easily printed to enable
    // the program to be tested easier.
    //
    // In Main, write a method that takes an object that implements the interface as a parameter and
    // "saves" the values.
    // We haven't covered I/O yet, so your method should just print the values to the screen.
    // Also in Main, write a method that restores the values to a saveable object.
    // Again, we are not going to use Java file I/O; instead use the readValues() method below to
    // simulate getting values from a file – this allows you to type as many values as your class
    // requires, and returns an ArrayList.


    public static void main(String[] args) {

        ArrayList<String> eventsForPirate = new ArrayList<String>();

        eventsForPirate.add("Be born.");
        eventsForPirate.add("Grow up.");
        eventsForPirate.add("Hijack first ship");
        eventsForPirate.add("Drink Rum.");

        ArrayList<String> eventsForPaladin = new ArrayList<String>();
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        ArrayList<Player> players = new ArrayList<Player>();


        Player player = new Player("Jake", "Pirate");
        players.add(player);
        Player secondPlayer=new Player("Frosty","Snowman");
        players.add(secondPlayer);

        player.saveToList("Pirate is created.");
        player.showEventList();
        player.populateObject(eventsForPirate);
        player.showEventList();

        Monster Troll = new Monster("Cave Troll 1","Chaotic-Evil");
        Monster caveTroll = new Monster("Cave Troll 2","Chaotic-Evil");
        Monster woodTroll = new Monster("Wood Troll 1","Chaotic-Evil");
        Monster mountainTroll = new Monster("Mountain Troll 1","Chaotic-Evil");
        Troll.saveToList(Troll.getName() + " created.");
        caveTroll.saveToList(caveTroll.getName() + " created.");
        woodTroll.saveToList(woodTroll.getName() + " created.");
        mountainTroll.saveToList(mountainTroll.getName() + " created.");
        Troll.showEventList();
        caveTroll.showEventList();
        woodTroll.showEventList();
        mountainTroll.showEventList();

        monsters.add(Troll);
        monsters.add(caveTroll);
        monsters.add(mountainTroll);
        System.out.println("---Monsters--------");
        for (Monster monster:monsters){

            System.out.println(monster.toString());
        }



        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {

            int option = scanner.nextInt();

            switch (option) {

                case 0:
                    quit = true;
                    break;

                case 1:

                    System.out.println("Enter a new event for Pirate:");
                    String event = scanner.next();
                    eventsForPirate.add(event);
                    System.out.println(event+" added for Pirate");
                    scanner.nextLine();
                    break;

                case 9:
                    for (int i = 0; i <eventsForPirate.size() ; i++) {
                        System.out.println(eventsForPirate.get(i).toString());

                    }
            }


        }


    }
}
