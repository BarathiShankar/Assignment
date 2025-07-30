//Practice program to implement online hotel booking management
import java.util.Scanner;
class hotel
{
	public static int avai = 10;
public static int[] rooms={1,2,3,4,5,6,7,8,9,10};
	private String name;
  private int room_alloc;
	private double phn;
	private float stay_time;
	private float cost;
	private Scanner s=new Scanner(System.in);
	public void read()
	{ int i;
		System.out.print("Enter customer's name : ");
		name=s.nextLine();
		System.out.print("Enter customer's phone number : ");
		phn=s.nextInt();
		System.out.print("Enter stay hours : ");
		stay_time=s.nextFloat();
		if(stay_time<=24) cost=3000;
		else if(stay_time<=36) cost=3600;
		else if(stay_time<=48) cost=4500;
		else cost=6500;
		for(i=0;i<10;i++)
		{
			if(rooms[i]!=0)
			{ 	if(disp())
      {  room_alloc=rooms[i];
				System.out.println("Allocated room number : "+rooms[i]);
       rooms[i]=0;
       break;
   		}
      }
		}
 	}
	private boolean disp()
	{	int ck=0,chance=3;
		boolean book=false;
		while(true)
    {
		System.out.println("Name : "+name+"\nPhone number : "+phn+"\nStay for "+stay_time+"hrs\nCost : "+cost+"\n\n\nHave the customer completed transaction ( 1 for YES and 0 for NO )  :  ");
		ck=s.nextInt();
		if(ck==1) 
		{ System.out.println("BOOKING SUCCESFULL");
     --avai;
		return true;
		}
		else if(ck==0)
		{	if(chance>0)
			{
			System.out.println("Kindly pay the rent of "+cost+"rs, Number of chances remaining : "+--chance);
			continue;
			}
			else 
			{System.out.println("BOOKING FAILED ! GET OUT OF THE HOTEL PAL !!!");
			return false;
			}
		}
		else 
		{ System.out.println("Invalid entry");
		  continue;
		}
      }
	}
	
}
public class Hotel_service
{
	public static void main(String[] args)
	{ int n,i;
		System.out.print("Enter the number of customers : ");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		hotel[] obj= new hotel [n];
		for(i=0;i<n;i++)
		{
			if(hotel.avai>0)
			{ obj[i]=new hotel();
        obj[i].read();
			}
		}
	}
}
//run time error checking is pending
