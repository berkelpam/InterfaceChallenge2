package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauljava on 10/08/2017.
 */
public class Monster implements IStorageMedium, ICharacter, ISaveable {

    private String name;
    private String type;
    private int health;
    private boolean alive;
    private ArrayList<String> events;
    private ArrayList<String> items;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        this.health = 100;
        this.alive = true;
        this.events = new ArrayList<String>();
        this.items = new ArrayList<String>();
    }


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

    public void showEventList() {
        System.out.println("Event list for monster: " + this.name);
        System.out.println("----------------------------------");
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + 1 + ". " + events.get(i).toString());
        }
        System.out.println("===================================");

    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", health=" + health +
                ", alive=" + alive +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public void saveItems(ArrayList<String> items) {
        //TODO implement this.
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.health);
        values.add(2, this.type);
        values.add(3, "" + this.alive);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if ((savedValues != null) && (savedValues.size() > 0)) {
            this.name = savedValues.get(0);
            this.health = Integer.parseInt(savedValues.get(1));
            this.type = savedValues.get(2);
            if (savedValues.get(3).equals("true")) {
                this.alive = true;
            } else {
                this.alive = false;
            }

        }
    }
}
