//Basic java program to create a daily usage calculator
import java.util.Scanner;
public class Calculator
{
    public static void main(String[] args)
    { Scanner s=new Scanner(System.in);
     char o;
     int x,y,result;
       while (true)
{
     System.out.print("WELCOME TO THE CALCULATOR \n\nEnter two numbers to perform specified operation -\nNumebr 1 : ");
     x=s.nextInt();
     System.out.print("Number 2 : ");
     y=s.nextInt();
     System.out.print("Enter the operation to be performed ( + , - , * , % , / , x ( to exit program ) ) : ");
     o=s.next().charAt(0);
    if((o=='%' || o=='/') && y==0)
    {
      System.out.println("Division with zero error");
      continue;
    }
     switch(o)
       {
         case '+' : System.out.println("Sum : "+(x+y));
                   break;
         case '-' : System.out.println("Difference : "+(x-y));
                   break;
         case '*' : System.out.println("Product : "+x*y);
                    break;
         case '/' : System.out.println("Division : "+x/y);
                   break;
         case '%' : System.out.println("Reminder : "+x%y);
                   break;
         case 'x':
         case 'X':System.out.println("Program terminated");
                 return;
         default : System.out.println("Invalid Operator , try again ");
       }
    }
  }
}
