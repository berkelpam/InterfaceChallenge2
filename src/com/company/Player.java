package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauljava on 10/08/2017.
 */
public class Player implements IStorageMedium, ICharacter, ISaveable {
    private String name;
    private int healtPoints;
    private String classType;
    private boolean alive;
    private static int maxHealth = 100;
    private ArrayList<String> events;
    private ArrayList<String> items;

    public Player(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.healtPoints = 100;
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

    public void showEventList() {
        System.out.println("Event list for player: " + this.name);
        System.out.println("----------------------------------");
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + 1 + ". " + events.get(i).toString());
        }
        System.out.println("===================================");

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", healtPoints=" + healtPoints +
                ", classType='" + classType + '\'' +
                ", alive=" + alive +
                ", events=" + events +
                ", items=" + items +
                '}';
    }


    @Override//TIms solution.
    public void read(List<String> savedValues) {
        if ((savedValues != null) && (savedValues.size() > 0)) {
            this.name = savedValues.get(0);
            this.healtPoints = Integer.parseInt(savedValues.get(1));
            this.classType = savedValues.get(2);
            if (savedValues.get(3).equals("true")) {
                this.alive = true;
            } else {
                this.alive = false;
            }
            this.maxHealth=Integer.parseInt(savedValues.get(4));

        }
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.healtPoints);
        values.add(2, this.classType);
        values.add(3, "" + this.alive);
        values.add(4, "" + this.maxHealth);
        return values;
    }

    public void pickUp(String item) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealtPoints() {
        return healtPoints;
    }

    public void setHealtPoints(int healtPoints) {
        this.healtPoints = healtPoints;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public static void setMaxHealth(int maxHealth) {
        Player.maxHealth = maxHealth;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public ArrayList<String> getItems() {
        return items;
    }

//    public void setItems(List<String> items) {
//        this.items = items;
//    }

    @Override
    public void saveItems(ArrayList<String> items) {

    }
}


