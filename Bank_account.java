//Program to impliment inheritencce login in bank account loigc
import java.util.Scanner;
class Bank
{
    protected String name;
    protected int age;
    public String ac_no;
    protected float balance;
    public Scanner s=new Scanner(System.in);
    Bank()
    {
        System.out.print("Enter the account holder name : ");
        name=s.nextLine();
        System.out.print("Enter the account number : ");
        ac_no=s.nextLine();
        System.out.print("Enter the age of account holder : ");
        age=s.nextInt();
        System.out.print("Enter the available balance : ");
        balance=s.nextFloat();
    }
    protected void print()
    {
        System.out.println("Name : "+name+"\nAge : "+age+"\nAccount Number : "+ac_no+"\nAvailable Balance : "+balance);
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
        if(s_amount<=0)
        {
            System.out.println("Insufficient amount");
            return;
        }
        balance+=s_amount;
        System.out.println("Amount Deposited - "+s_amount);
        s_amount=0;
    }
    void update()
    {
        System.out.print("Enter the current amount : ");
        s_amount=s.nextFloat();
        System.out.println("Recieved amount");
    }
    @Override
    protected void print()
    {
        super.print();
        System.out.println("Available savings amount : "+s_amount);
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
        if(balance<=0)
        {
            System.out.println("Insufficient amount");
            return;
        }
        balance-=c_amount;
        System.out.println("Amount withdrawn - "+c_amount);
        c_amount=0;
    }
    void update()
    {
        System.out.print("Enter the current amount : ");
        c_amount=s.nextFloat();
        System.out.println("Recieved amount");
    }
    @Override
    protected void print()
    {
        super.print();
        System.out.println("Pending withdrawal amount : "+c_amount);
    }
}
public class Bank_account
{
    static
    {
        System.out.println("-> This bank has a slot for 2 current and 2 savings account holder\n"+
                           "-> Current - able only to withdraw cash till the balance is null\n"+
                            "-> Savings - able only to deposit cash upto any limit\n"+
                            "-> You can provide the savings and current amount ( deposit & withdrawing ) any time");
    }
    public static void main(String[] args)
    {
        Savings[] sa=new Savings[2];
        Current[] cu=new Current[2];
        int i,ck;
        boolean check=false;
        String acc;
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
            System.out.print("Enter -\n0. Exit from terminal\n1. Deposit amount as savings\n2. Withdraw amount from current\n3. Print the details of Savings account\n4. Print details of Current account\n5. Update savings amount\n6. Update current amount\nEnter your choice : ");
            ck = s.nextInt();
            switch (ck)
            {
                case 0 : System.out.println("Program terminated");
                        return;
                case 1 : System.out.print("Enter the account number : ");
                        acc=s.nextLine();
                        for(i=0;i<2;i++)
                        {
                        if(sa[i].ac_no.equals(acc)) {
                            check = true;
                            sa[i].depo();
                        }
                        }
                        if(!check)
                        System.out.println("No savings account found");
                        check=false;
                        break;
                case 2 ://Edit from here,put equals method and Also make acc inot methods as nextLine()
                        System.out.print("Enter the account number : ");
                     acc=s.nextDouble();
                     for(i=0;i<2;i++)
                     {
                        if(cu[i].ac_no == acc)
                        {
                            check=true;
                            cu[i].withdraw();
                        }
                     }
                    if(!check)
                        System.out.println("No current account found");
                    check=false;
                    break;
                case 3 :
                        System.out.print("Enter the account number : ");
                        acc=s.nextDouble();
                        for(i=0;i<2;i++)
                        {
                            if(sa[i].ac_no==acc)
                            {
                                check=true;
                                sa[i].print();
                            }
                        }
                        if(!check)
                        System.out.println("No Savings account found");
                        check=false;
                        break;
                case 4 :
                        System.out.print("Enter the account number : ");
                        acc=s.nextDouble();
                        for(i=0;i<2;i++)
                         {
                            if(cu[i].ac_no==acc)
                            {
                             check=true;
                                cu[i].print();
                            }
                         }
                        if(!check)
                        System.out.println("No Current account found");
                        check=false;
                        break;
                case 5 :System.out.print("Enter the account number : ");
                    acc=s.nextDouble();
                    for(i=0;i<2;i++)
                    {
                        if(sa[i].ac_no == acc)
                        {
                            check=true;
                            sa[i].update();
                        }
                    }
                    if(!check)
                        System.out.println("No savings account found");
                    check=false;
                    break;
                case 6 : System.out.print("Enter the account number : ");
                    acc=s.nextDouble();
                    for(i=0;i<2;i++)
                    {
                        if(cu[i].ac_no == acc)
                        {
                            check=true;
                            cu[i].update();
                        }
                    }
                    if(!check)
                        System.out.println("No current account found");
                    check=false;
                    break;
                default : System.out.println("Invalid input,try Again");
            }
        }
    }
}
//UNDER DEVELOPMENT
