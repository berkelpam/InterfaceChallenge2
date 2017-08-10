package com.company;

import java.util.ArrayList;

/**
 * Created by pauljava on 10/08/2017.
 */
public class Player implements IStorageMedium {
    private String name;
    private int healtPoints;
    private String classType;
    private boolean alive;
    private static int maxHealth = 100;

    public Player(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.healtPoints = 100;
        this.alive = true;
    }

    private ArrayList<String> events = new ArrayList<String>();

    @Override
    public ArrayList<String> saveToList(String values) {
        events.add(values);
        return events;
    }

    @Override
    public void populateObject(ArrayList<String> events) {
        for (int i = 0; i < events.size(); i++) {
            this.events.add(events.get(i));
        }
    }

    public void loseHealth(int hitPoints) {
        if (hitPoints >= this.healtPoints) {
            this.healtPoints -= hitPoints;
            System.out.println("Player takes a hit of " + hitPoints + " points");
            System.out.println("Player health is now: " + this.healtPoints + " points.");
        } else {
            this.alive = false;
            System.out.println("Player takes a hit of " + hitPoints + " points and died.");
        }
    }

    public void drinksHealthPotion(int hitPoints) {
        if ((this.healtPoints + hitPoints) > maxHealth) {
            this.healtPoints = maxHealth;
            System.out.println("Player drinks a health potion and gains " + hitPoints + " points.");
            System.out.println("Player health is now full and has: " + this.healtPoints + " points.");
        } else {
            this.healtPoints += hitPoints;
            System.out.println("Player drinks a health potion and gains " + hitPoints + " points.");
            System.out.println("Player health is now: " + this.healtPoints + " points.");
        }
    }

    public void showEventList(){
        System.out.println("Event list for player: "+ this.name);
        System.out.println("----------------------------------");
        for (int i = 0; i <events.size() ; i++) {
            System.out.println(i+1+". "+events.get(i).toString());
        }
        System.out.println("===================================");

    }

    @Override
    public String toString() {
        return this.name + " -=> "+this.classType;
    }
}


