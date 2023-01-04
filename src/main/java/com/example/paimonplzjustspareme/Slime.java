package com.example.paimonplzjustspareme;

public class Slime {
    private static int health;
    private static int strength;
    private static int level;
    private static boolean dead;
    private static String SlimeisDead;
    private static int healthCap;

    public Slime() {
        health = 25;
        strength = 2;
        level = 1;
        dead = false;
        SlimeisDead = "";
        healthCap = 25;
    }

    public int getStrength2() {
        return strength;
    }

    public int getHealth2() {
        return health;
    }

    public int getLevel2() {
        return level;
    }

    public static boolean isDead2() {
        return dead;
    }

    public static String getSlap(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
        }
        if (dead != true) {
            SlimeisDead = "The slime takes " + amount + " damage and now has " + (health) + " health";
            if (health <= 0) {
                health = 0;
                SlimeisDead = "The slime has been slayed!";
                dead = true;
            }
        }
        return SlimeisDead;
    }

    public static int attack2() {
        int dmg = strength * level;
        return dmg;
    }

    public static String state2() {
        return ("Slime: \nStrength = " + strength + "\nHealth = " + health + "/" + healthCap + "\nLevel = " + level);
    }

    public int xpGive() {
        return level*2;
    }

    public int getHealthCap2() {
        return healthCap;
    }
}