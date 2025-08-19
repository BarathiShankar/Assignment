// Program to create a battle between 2 superheroes symbolizing with their super powers and attacking each other.
// The last to survive will be the Champion
import java.util.Scanner;
import java.util.Random;
class Hero {
    String name;
    int health;
    int strength;
    String userName;
    static int matches;
    boolean isAlive;
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    // Static block to intitialize the details and rules of the game to user
    static {
        matches = 0;
        System.out.println("\n\nTHE RULE PAGE -\n--> The game is a battlefield of 2 user defined superheroes"
                + "\n--> Each hero has 200 HP at beginning and 100 strength power"
                + "\n--> Each hero attacks the other with his attack power and reduces opponent's HP"
                + "\n--> On the same time, the attacker gains a small amount of heal"
                + "\n--> The user has to maintain his strength to attack his opponent, lower strength makes the attack weaker"
                + "\n--> With each attack, the attacker loses fraction of his strength"
                + "\n--> The hero also loses the game if he loses his entire strength in attacking"
                + "\n--> The user has to choose the hero to be attacked first and give the attack power each time"
                + "\n--> The game has 3 rounds. Last surviving hero wins the game"
                + "\n\nENJOY THE BATTLE !!!");
    }
    void attack(Hero opp) {
        if (strength <= 0) {
            isAlive = false;
            System.out.println("You ran out of strength! Declared " + opp.name + " as CHAMPION.");
            return;
        }
        if (isAlive) {
            if (opp.isAlive) {
                int atk = 5, heal;
                System.out.print("Available strength: " + strength + "\nEnter the attack power of " + name + " (0 to " + strength / 5 + "): ");
                atk = s.nextInt();
                if (atk <= (strength / 5) && atk >= 0) {
                    System.out.println("Attacked with a power of " + atk);
                } else if (atk > (strength / 5)) {
                    System.out.println("WARNING! Unable to attack with higher power due to the lack of strength\nSet attack power to 5");
                    atk = 5;
                } else {
                    System.out.println("Invalid attack power entered, Attacking power set to 5");
                    atk = 5;
                }
                opp.health -= atk;
                strength -= (atk / 3);
                System.out.println("SUPERB BLAST OVER " + opp.name + ". HE JUST WOULD HAVE FAINTED!!");
                heal = r.nextInt(6); 
                if ((health + heal) <= 200) {
                    health += heal;
                    System.out.println("Strength bar decreased to " + strength + "\nSURPRISE! " + name + " healed with " + heal + " HP's");
                }
                if (opp.health <= 0) {
                    opp.isAlive = false;
                    System.out.println("Congratulations, your opponent " + opp.name + " is dead!!! You became the CHAMPION!");
                }
            } else {
                System.out.println("Congratulations, your opponent " + opp.name + " is dead!!! You became the CHAMPION!");
            }
        } else {
            System.out.println("You ran out of energy! Declared " + opp.name + " as CHAMPION");
        }
    }
    void stats() {
        System.out.println("\nDetails of " + name + " - \nUser name: " + userName + "\nHealth available: " + health
                + "\nStrength remaining: " + strength + "\nIs Alive: " + isAlive);
    }

    void read() {
        health = 200;
        isAlive = true;
        strength = 100;
        System.out.print("Enter the User name: ");
        userName = s.next();
        System.out.print("Choose hero name: ");
        name = s.next();
        System.out.println("FICTIONAL HERO CREATED");
    }
}
public class Battle_of_Heros {
    public static void main(String[] args) {
        Hero[] h = new Hero[2];
        Scanner s = new Scanner(System.in);
        String name, opName;
        for (int i = 0; i < 2; i++) {
            h[i] = new Hero();
            h[i].read();
        }
        int rounds = 3;
        while (rounds-- > 0 && h[0].isAlive && h[1].isAlive) {
            System.out.println("\n\nLET THE GAME BEGIN\n");
            Hero.matches++;
            System.out.println("Match number: " + Hero.matches);
            System.out.println("Enter your hero name: ");
            name = s.next();
            System.out.print("Enter your opponent hero name: ");
            opName = s.next();
            if (name.equals(opName)) {
                System.out.println("Unable to attack yourself my champ!");
                continue;
            } else if (name.equals(h[0].name) && opName.equals(h[1].name)) {
                h[0].attack(h[1]);
            } else if (name.equals(h[1].name) && opName.equals(h[0].name)) {
                h[1].attack(h[0]);
            } else {
                System.out.println("Invalid hero name entered, try again");
                continue;
            }
            // Optionally display stats
            h[0].stats();
            h[1].stats();
        }
        System.out.println("Game over! Final stats:");
        h[0].stats();
        h[1].stats();
        s.close();
    }
}
//COMPLETED
