package com.example.paimonplzjustspareme;

public class Paimon {
  private static int health;
  private static int healthCap;
  private static int strength;
  private static int level;
  private boolean dead;
  private static int xp;
  private static int xpCap;
  private int crit = 0;

  private static String text;

  public Paimon() {
    health = 25;
    healthCap = 25;
    strength = 2;
    level = 1;
    dead = false;
    xpCap = 2;
    xp = 0;
    text = "";
  }

  public int getStrength3() {
    return strength;
  }

  public int getHealth3() {
    return health;
  }

  public int getLevel3() {
    return level;
  }

  public boolean isDead3() {
    return dead;
  }

  public String slapped(int amount) {
    health -= amount;
    if (health <= 0) {
      health = 0;
    }
    if (dead != true) {
      text = "Paimon takes " + amount + " damage and now has " + (health) + " health";
      if (health <= 0) {
        health = 0;
        text = "Paimon has been slayed!";
        dead = true;
      }
    }
    return text;
  }

  public void fullHeal() {
    health = healthCap;
  }
  public int attack3() {
    crit = (int) (Math.random() * 6) + 1;
    if (crit == 4) {
      int dmg = strength * level;
      return dmg * 10;
    } else {
      int dmg = strength * level;
      return dmg;
    }
  }

  public void LevelUp3(int exp) {
    xp += exp;
    if (xp >= xpCap) {
      level++;
      System.out.println("Paimon has reached leveled up to level " + level + "!\nHealth + 10\nStrength + 1\nXP needed to level up: " + xpCap * 2);
      System.out.println("------------------------------------------");
      healthCap *= 2;
      strength++;
      xp -= xpCap;
      xpCap *= 2;
    }
  }

  public static String state3() {
    return ("Paimon: \nStrength = " + strength + "\nHealth = " + health + "/" + healthCap + "\nLevel = " + level
        +"\nXP = " + xp + "/" + xpCap);
  }

  public int defend(int dmg) {
    int chance = (int)(Math.random() * 3) + 1;
    if(chance%2 == 1) {
      return 0;
    } else {
      return dmg;
    }
  }
}