public class Slime {
    private static int health;
    private static int strength;
    private static int level;
    private static boolean dead;

    public Slime() {
        health = 25;
        strength = 1;
        level = 1;
        dead = false;
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

    public static void getSlap(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
        }
        if (dead != true) {
            System.out.println("The slime takes " + amount + " damage and now has " + (health) + " health");
            if (health <= 0) {
                health = 0;
                System.out.println("The slime has been slayed!");
                dead = true;
            }
        }
    }

    public static int attack2() {
        int dmg = strength * level;
        System.out.println("The slime attacks for " + dmg + " health points!");
        return dmg;
    }

    public static String state2() {
        return ("Slime: \nStrength = " + strength + "\nHealth = " + health + "\nLevel = " + level);
    }

    public int xpGive() {
        return level*2;
    }
}