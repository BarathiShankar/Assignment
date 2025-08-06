//Program to create a battle between 2 superheros symbolizing with their super powers and attacking each other.The last to survive will be the Champion
import java.uitl.Scanner;
import java.util.Random;
class Heros
{  String name;
  int health;
 String user_name;
 static int matches;
 boolean isalive;
 Scanner s=new Scanner(System.in);
 Random r=new Random();
 static
 { matches=0;
   System.out.println("--> The game is a battle field of 2 user defined superheros\n--> Each hero has 200 HP at beggining\n--> Each hero attacks the other with his attack strength and reduces opponents HP
     \n--> On the same time,the attacker gains a small amount of heal\n-->
  The user has to numerate the hero to be attacked first and give the attack strenght each time\n--> The game has 3 rounds.Last surviving hero wins the game\n\n\nENJOY THE BATTLE !!!");
 }
 void attack(Heros opp)//check dead condition for attacker,pending
 { 
   if(opp.isalive)
 {
   int atk=5,heal;
  System.out.print("Enter the attacking strenght of "+name+" ( 0 to 30 ) : ");
  atk=s.nextInt();
  if(atk<31 && atk>=0)
  {
    System.out.println("Attacked with a power of "+atk);
  }
  else
    System.out.println("Invalid of attack strenght entered.Default,Attacking set to 5 now");
  opp.health-=atk;
  System.out.println("SUPERB BLAST OVER "+opp.name+".HE JUST WOULD HAVE FAINTED !!");
  heal=r.nextInt(6);
  if((health+heal <=200))
  {
    health+=heal;
    System.out.println("SURPRISE ! "+name+" (you) Healed with "+heal+" HP's");
  }
   if(opp.health<0)
   { opp.isalive=false;
     System.out.println("Congratulations,Your opponent "+opp.name+"is dead !!! You became the CHAMPION !");
   }
 }
  else
   System.out.println("Congratulations,Your opponent "+opp.name+"is dead !!! You became the CHAMPION !");
 }
 void stats()
 {
   System.out.println("Details of "+name+" - \n"+"User name : "+user_nmae+"\nHealth available : "+health+"\nIs Alive : "+isalive);
 }
 void read()
 { health=200;
  isalive=true;
   System.out.print("Enter the User name : ");
  user_name=s.next();
  System.out.print("Choosen hero name : ");
  name=s.next();
  System.out.println("FICTIONAL HERO CREATED");
 }
}
public class Battle_of_Heros
{
  public static void main(String[] args)
  { Heros[] H=new Heros[2];
   Scanner s=new Scanner(System.in);
   String name;
   int atk;
   
  }
}
//STILL UNDER DEVELOPMENT
