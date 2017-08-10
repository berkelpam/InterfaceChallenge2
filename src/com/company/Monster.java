package com.company;

import java.util.ArrayList;

/**
 * Created by pauljava on 10/08/2017.
 */
public class Monster implements IStorageMedium, ICharacter {

    private String name;
    private String type;
    private int health;
    private boolean alive;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        this.health=100;
        this.alive=true;
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

    @Override
    public void loseHealth(int hitPoints) {
        if (hitPoints >= this.health) {
            this.health -= hitPoints;
            System.out.println("Monster takes a hit of " + hitPoints + " points");
            System.out.println("Monster health is now: " + this.health + " points.");
        } else {
            this.alive = false;
            System.out.println("Monster takes a hit of " + hitPoints + " points and died.");
        }
    }
    public void showEventList(){
        System.out.println("Event list for monster: "+ this.name);
        System.out.println("----------------------------------");
        for (int i = 0; i <events.size() ; i++) {
            System.out.println(i+1+". "+events.get(i).toString());
        }
        System.out.println("===================================");

    }

    @Override
    public String toString() {
        return this.name + " -=> "+this.type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
