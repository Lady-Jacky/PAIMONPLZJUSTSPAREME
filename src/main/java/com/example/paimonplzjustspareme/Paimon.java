package com.example.paimonplzjustspareme;

public class Paimon {
  private static int health = 25;
  private static int healthCap = 25;
  private static int strength = 2;
  private static int level = 1;
  private static boolean dead = false;
  private static int xp = 0;
  private static int xpCap = 2;
  private static int crit = 0;
  private boolean didlevel = false;


  private static String text;

  public Paimon() {
    text = "";
    didlevel = false;
  }

  public int getStrength3() {
    return strength;
  }

  public int getHealth3() {
    return health;
  }
  public int getHealthCap() { return healthCap; }

  public int getLevel3() {
    return level;
  }

  public boolean isDead3() {
    return dead;
  }

  public static String slapped(int amount) {
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
  public static int attack3() {
    crit = (int) (Math.random() * 10) + 1;
    if (crit == 4) {
      int dmg = strength * level;
      return dmg * 10;
    } else {
      int dmg = strength * level;
      return dmg;
    }
  }

  public boolean nextLvl() {
    return didlevel;
  }

  public void setLevelFalse() {
    didlevel = false;
  }
  public String LevelUp3(int exp) {
    if (level < 10) {
      xp += exp;
      if (xp >= xpCap) {
        level++;
        healthCap *= 2;
        strength++;
        xp -= xpCap;
        xpCap *= 2;
        fullHeal();
        didlevel = true;
        return "Paimon gained " + exp + " xp!\nPaimon has reached leveled up to level " + level + "!\nHealth + 10\nStrength + 1\nXP needed to level up: " + xpCap * 2;
      } else {
        fullHeal();
        return "Paimon gained " + exp + " xp!";
      }
    } else {
      return "Paimon has reached max level.\nShe can no longer gain xp";
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