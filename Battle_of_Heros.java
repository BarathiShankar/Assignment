//Program to create a battle between 2 superheros symbolizing with their super powers and attacking each other.The last to survive will be the Champion
import java.util.Scanner;
import java.util.Random;
class Heros
{ String name;
  int health;
 int strenght;
 String user_name;
 static int matches;
 boolean isalive;
 Scanner s=new Scanner(System.in);
 Random r=new Random();
 static //To introduce the details and rules of the game to user
 { matches=0;
   System.out.println("\n\nTHE RULE PAGE -\n--> The game is a battle field of 2 user defined superheros\n--> Each hero has 200 HP at beggining and 100 strenght power\n--> Each hero attacks the other with his attack power and reduces opponents HP"
     +"\n--> On the same time,the attacker gains a small amount of heal\n-->The user has to maintain his strength to attack his opponent,lower the strenght makes the attack more\n-->"
     +"With each attack,the attacker looses fraction of his strenght\n-->The hero also looses the game if he looses his entire strength in attacking\n-->"
  +"The user has to numerate the hero to be attacked first and give the attack power each time\n--> The game has 3 rounds.Last surviving hero wins the game\n\n\nENJOY THE BATTLE !!!");
 }
 void attack(Heros opp)
 { if(strength<0)
     isalive=false;
   if(isalive)
 {
   if(opp.isalive)
 {
   int atk=5,heal;
  System.out.print("Available strenght : "+strength+"\nEnter the attack power of "+name+" "+0+" to "+strenght/5);
  atk=s.nextInt();
  if(atk<=(strength/5) && atk>=0)  
  {
    System.out.println("Attacked with a power of "+atk);
  }
  else if(atk>(strength/5))
    System.out.println("WARNING ! Unable to attack with higher power due to the lack of strength\nSet attack power to 5");
   else
    System.out.println("Invalid attack power entered, Attacking power set to 5);
  opp.health-=atk;
   strenght-=(atk/3);
  System.out.println("SUPERB BLAST OVER "+opp.name+".HE JUST WOULD HAVE FAINTED !!");
  heal=r.nextInt(6);
  if((health+heal <=200))
  {
    health+=heal;
    System.out.println("Strength bar decreased to "+strength+"\nSURPRISE ! "+name+" (you) Healed with "+heal+" HP's");
  }
   if(opp.health<0)
   { opp.isalive=false;
     System.out.println("Congratulations,Your opponent "+opp.name+"is dead !!! You became the CHAMPION !");
   }
 }
  else
   System.out.println("Congratulations,Your opponent "+opp.name+"is dead !!! You became the CHAMPION !");
 }
   else
 System.out.println("You, alright my hero .You have ran our of energy ! Declared "+opp.name+" as CHAMPION");
 }
 void stats()
 {
   System.out.println("Details of "+name+" - \n"+"User name : "+user_nmae+"\nHealth available : "+health+"\nStrength remaining : "+strenght+"\nIs Alive : "+isalive);
 }
 void read()
 { health=200;
  isalive=true;
  strenght=100;
   System.out.print("Enter the User name : ");
  user_name=s.next();
  System.out.print("Choosen hero name : ");
  name=s.next();
  System.out.println("FICTIONAL HERO CREATED");
 }
public class Battle_of_Heros
{
  public static void main(String[] args)
  {   
    Heros[] H=new Heros[2];
   Scanner s=new Scanner(System.in);
   String name,op_name;
    outer:
    while(true)
    {
   for(int i=0;i<2;i++)
  {
    h[i].read();
  }
      inner:
    while(true)
      {
        System.out.println("\n\nLET THE GAME BEGIN\n");
        Heros.matches++;
        System.out.println("Match number : "+Heros.matches+"\nEnter your hero name : ");
        name=s.next();
        System.out.print("Enter your opponent hero name : ");
        op_name=s.next();
        if(name.equals(op_name))
        {
          System.out.println("Unable to attack yourself my champ !";
          continue ;
        }
        else if(name.equals(h[0].name) && op_name.equals(h[1].name))
        {
          h[0].attack(h[1]);
        }
        else if(name.equals(h[1].name) && op_name.equals(h[0].name))
        {
          h[1].attack(h[0]);
        }
        else
          System.out.println("Invalid hero name entered , try again";
      } 
      }
  }
//STILL UNDER DEVELOPMENT
