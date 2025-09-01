//Program to provide vaccines for suggested people and gift them with a complimentary package based on their age
import java.util.Scanner;
public class Vaccine
{
	public static void main(String[] args)
	{	int age,ap_no;
		char slot;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter patients age : ");
		age=s.nextInt();
		System.out.print("Enter appointment order : ");
		ap_no=s.nextInt();
		if(age>=18 && age<=65)
		{
			System.out.print("Eligible for vaccine\n");
			if((ap_no/1000==0))
			{
				System.out.print("Enter 'R' to have Regular slot or 'P' to have a prioritized slot : ");
				slot=s.next().charAt(0);
				switch(slot)
				{
					case 'R':
					case 'r':System.out.println("Regular slot allocated");
						break;
					case 'P':
					case 'p':System.out.println("Priority slot allocated");
						break;
					default:System.out.println("Invalid entry");
				}
				switch(ap_no/100)
				{
					case 1:System.out.println("Gift : Pen");
						break;
					case 2 : System.out.println("Gift : Mask");
						break;
					case 3 : System.out.println("Gift : Sanitizer");
						break;
					default : System.out.println("No special gifts");
				}
			}
		}
		else
			System.out.println("Not eligible for vaccine");
	}
}
//COMPLETED