//Practice program to implement online hotel booking management
import java.util.Scanner;
public class Hotel_service 
{
    public static void main(String[] args) 
	{
        int n, i;
        System.out.print("Enter the number of customers : ");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine(); // consume leftover newline
        hotel[] obj = new hotel[n];
        for (i = 0; i < n; i++) {
            if (hotel.avai > 0) {
                obj[i] = new hotel();
                System.out.println("\n");
                obj[i].read();
            } else 
			{
                System.out.println("No rooms available. Booking closed.");
                break;
            }
        }
    }
}
class hotel
	{
    public static int avai = 10;
    public static int[] rooms = {1,2,3,4,5,6,7,8,9,10};
    private String name;
    private int room_alloc;
    private double phn;
    private float stay_time;
    private float cost;
    private Scanner s = new Scanner(System.in);
    public void read()
		{
        int i;
        System.out.print("Enter customer's name : ");
        name = s.nextLine();
        System.out.print("Enter customer's phone number : ");
        phn = s.nextDouble();
        s.nextLine(); // consume leftover newline
        System.out.print("Enter stay hours : ");
        stay_time = s.nextFloat();
        s.nextLine(); // consume leftover newline
		if (stay_time <= 24) cost = 3000;
        else if (stay_time <= 36) cost = 3600;
        else if (stay_time <= 48) cost = 4500;
        else cost = 6500;
        for (i = 0; i < 10; i++)
			{
            if (rooms[i] != 0) {
                if (disp()) {
                    room_alloc = rooms[i];
                    System.out.println("Allocated room number : " + rooms[i]);
                    rooms[i] = 0;
                    break;
                } else {
                    System.out.println("Booking Failed\t Next Customer\n");
                }
            }
        }
		}
    private boolean disp() 
		{
        int ck = 0, chance = 3;
        boolean book = false;
        while (chance > 0)
		{
            System.out.print("\nName : " + name + "\nPhone number : " + phn + "\nStay for " + stay_time + "hrs\nCost : " + cost + "\n\n\nHave the customer completed transaction ( 1 for YES and 0 for NO )  :  ");
            ck = s.nextInt();
            s.nextLine(); // consume leftover newline
            if (ck == 1)
			{
                System.out.println("BOOKING SUCCESSFUL");
                --avai;
                return true;
            } else if (ck == 0) {
                chance--;
                if (chance > 0) {
                    System.out.println("Kindly pay the rent of " + cost + "rs, Number of chances remaining : " + chance);
                } else {
                    System.out.println("BOOKING FAILED ! GET OUT OF THE HOTEL PAL !!!");
                    return false;
                }
            } else {
                System.out.println("Invalid entry");
            }
        }
        return false;
    }
}
//CODE COMPLETED
