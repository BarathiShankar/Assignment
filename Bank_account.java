//Program to impliment inheritencce login in bank account loigc
import java.util.Scanner;
class Bank
{
    protected String name;
    protected int age;
    protected double ac_no;
    protected float balance;
    public Scanner s=new Scanner(System.in);
    Bank()
    {
        System.out.print("Enter the account holder name : ");
        name=s.nextLine();
        System.out.print("Enter the account number : ");
        ac_no=s.nextDouble();
        System.out.println("Enter the age of account holder : ");
        age=s.nextInt();
    }
}
class Savings
{   private float s_amount;
    Savings()
    {
        super();
    }
}
class Current
{ private float c_amount;
    Current()
    {
        super();
    }

}
public class Bank_account
{
    public static void main(String[] args)
    {

    }
}
