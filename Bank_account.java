//Program to impliment inheritencce login in bank account loigc
import java.util.Scanner;
class Bank
{
    protected String name;
    protected int age;
    public double ac_no;
    protected float balance;
    public Scanner s=new Scanner(System.in);
    Bank()
    {
        System.out.print("Enter the account holder name : ");
        name=s.nextLine();
        System.out.print("Enter the account number : ");
        ac_no=s.nextDouble();
        System.out.print("Enter the age of account holder : ");
        age=s.nextInt();
        System.out.print("Enter the available balance : ");
        balance=s.nextFloat();
    }
}
class Savings extends Bank
{   private float s_amount;
    Savings()
    {
        super();
        System.out.print("Enter the savings amount : ");
        s_amount=s.nextFloat();
    }
    void depo()
    {
        balance+=s_amount;
        System.out.print("Amount Deposited - "+s_amount);
    }
}
class Current extends Bank
{ private float c_amount;
    Current()
    {
        super();
        System.out.print("Enter the current amount : ");
        c_amount=s.nextFloat();
    }
    void withdraw()
    {
        balance-=c_amount;
        System.out.print("Amount withdrawn - "+c_amount);
    }

}
public class Bank_account
{
    public static void main(String[] args)
    {
        Savings[] sa=new Savings[2];
        Current[] cu=new Current[2];
        int i,ck;
        boolean check=false;
        double acc;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the details for any 2 Savings account holder -");
        for(i=0;i<2;i++)
        {
            System.out.println("Savings account of banker "+(i+1));
            sa[i]=new Savings();
        }
        System.out.println("\nEnter the details of any 2 current account holders -");
        for(i=0;i<2;i++)
        {
            System.out.println("Current account of banker "+(i+1));
            cu[i]=new Current();
        }
        while(true) {
            System.out.print("Enter -\n1.To deposit amount as savings\n2. To withdraw amount fromm current\n3. To terminate the program\n Your choice : ");
            ck = s.nextInt();
            switch (ck)
            {
                case 1 : System.out.print("Enter the account number : ");
                        acc=s.nextDouble();
                        while(i<2)
                        {
                            if(sa[i].ac_no == acc)
                            {
                                check=true;
                                sa[i].depo();
                            }
                            i++;
                        }
                        if(!check)
                            System.out.println("Invalid account number entered");
                        break;
                case 2 :
                    System.out.print("Enter the account number : ");
                    acc=s.nextDouble();
                    while(i<2)
                    {
                        if(cu[i].ac_no == acc)
                        {
                            check=true;
                            cu[i].withdraw();
                        }
                    }
                    if(!check)
                        System.out.println("Invalid account number entered");
                    break;
                case 3 : System.out.println("Program terminated");
                    return;
                default : System.out.println("Invalid input,try Again");
            }
        }
    }
}
//STILL UNDER DEVELOPMENT
