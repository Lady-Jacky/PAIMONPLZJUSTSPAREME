public class Dragon {
    private int health;
    private int strength;
    private int level;
    private boolean dead;


    public Dragon() {
        health = 1000;
        strength = 10;
        level = 10;
        dead = false;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isDead() {
        return dead;
    }

    public String takeDamage(int amount) {
        health -= amount;
        if (health <= 0){
            health = 0;
        }
        if (dead != true) {
            System.out.println("Dvalin takes " + amount + " damage and now has " + (health) + " health");
            if (health <= 0) {
                health = 0;
                dead = true;
                return "Dvalin has been slain!";
            }
        }
        else{
           return "Dvalin is already dead!";
        }
      return "";
    }

    public int attack() {
        int dmg = strength * level;
        System.out.println("The dragon attacks for " + dmg + " health points!");
        return dmg;
    }


    public String state() {
        return ("Dvalin: \nStrength = " + strength + "\nHealth = " + health + "\nLevel = " + level);
    }
}