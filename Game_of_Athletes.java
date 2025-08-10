//Complex game to compete 3 virtual athletes and train them,heal them and compete them together in a tournamnet.The last to remain active and un fainted wins the game.Its a menu driven one
import java.util.Scanner;
import java.util.Random;
class GameAthlete
{
    String name;
    int energy;
    int skillPower;
    int maxEnergy;
    boolean isActive;
    static int tot_count=0;
    void compete (GameAthlete opponent)
    {
        if(opponent.isActive) {
            opponent.energy -= skillPower;
            System.out.println("Opponent energy decreased");
            if(opponent.energy<0)
                opponent.isActive=false;
        }
        else System.out.println("Opponent is faint due to low energy  !");
    }
    void rest(int amount)
    {
        energy+=amount;
        System.out.println("Energy increased");
    }
    void train()
    {
        Random r=new Random();
        skillPower+=r.nextInt(11);
        System.out.println("Trained succesfully");
    }
    void displayStats()
    {
        System.out.println("Athlete name : "+name+"\nEnergy : "+energy+"\nSkill power : "+skillPower+"\nMaximum energy available : "+maxEnergy+"\nIs Active : "+isActive);
    }
    GameAthlete(String name,int ener,int skill)
    {
        this.name=name;
        energy=ener;
        skillPower=skill;
        maxEnergy=200;
        isActive=true;
    }
    GameAthlete()
    {
        name="Sandalesh";
        energy=100;
        skillPower=10;
        isActive=true;
        maxEnergy=200;
    }
}
public class Game_of_Athletes
{
    public static void main(String[] args) {
        GameAthlete[] A = new GameAthlete[3];
        Scanner s = new Scanner(System.in);
        int i,pl, energy, skillPower, ck,opp,rest=0;
        String name;
        System.out.println("The game includes 3 athletes with whom you can compete,train and relax to increases skills and health\nThey can be competed against each other \nOver loss of health can make them faint and get them disqualified\nLast to survuve is the winner");
        out:
        while(true)
        {
        for (i = 0; i < 3; i++) {
            if (i == 0) {
                A[i] = new GameAthlete();
                System.out.println("First athlete data have been initialized");
            } else {
                System.out.print("Details of athlete " + (i + 1) + " -\nEnter the athlete name : ");
                name = s.next();
                System.out.print("Enter the players energy (0 to 50): ");
                energy = s.nextInt();
                if (!(energy > 0 && energy < 50)) {
                    System.out.println("Invalid energy entered, Energy set to 0");
                    energy = 0;
                }
                System.out.print("Enter skill power (0 to 20) : ");
                skillPower = s.nextInt();
                if (!(skillPower > 0 && skillPower < 20)) {
                    System.out.println("Invalid skill power entered, Skill power set to 0");
                    skillPower = 0;
                }
                A[i] = new GameAthlete(name, energy, skillPower);
            }
        }
        game:
        while (true) {
            System.out.println("Enter the number of athlete to be controlled : ");
            pl = s.nextInt();
            if (pl >= 1 && pl <= 3) {
                System.out.print("Hit -\n1 to compete\n2 to rest\n3 to train\n4 to Print the stats\n5 to exit the game\n6 to restart the game\nEnter your choice : ");
                ck = s.nextInt();
                switch (ck) {
                    case 1:
                        System.out.println("Enter opponent athlete number : ");
                        opp = s.nextInt();
                        if (opp == pl) {
                            System.out.println("Unable to beat yourself as opponent");
                            continue game;
                        } else if (opp < 1 || opp > 3) {
                            System.out.println("Invalid opponent selected");
                            continue game;
                        } else {
                            A[pl - 1].compete(A[opp - 1]);
                        }
                        continue game;
                    case 2:
                        System.out.print("Enter the Amount of health to be recovered (0 to 50) : ");
                        rest = s.nextInt();
                        if (rest > 0 && rest < 50)
                            A[pl - 1].rest(rest);
                        else
                            System.out.println("Invalid rest amount,no rest health generated");
                        continue game;
                    case 3:
                        A[pl - 1].train();
                        continue game;
                    case 4:
                        A[pl - 1].displayStats();
                        break;
                    case 5:System.out.println("Program terminated\n\nR.Barathi Shankar - 2024503063");
                        return;
                    case 6:
                        System.out.println("Restarting the game");
                        continue out;
                    default:
                        System.out.println("Invalid entry");
                }
            } else
                System.out.println("Invalid athlete number entered ");
        }
        }
    }
}
