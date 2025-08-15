//Program to check whether 2 strings are anagrams or not
import java.util.Scanner;
public class anagram
  {
    public static void main(String[]args)
    {
      Scanner s=new Scanner(System.in);
      String str1,str2;
      int ck=1;
      while(true)
        {
      System.out.print("Enter first string : ");
      str1=s.next();
      System.out.print("Enter second string : ");
          str2=s.next();
       System.out.print("Enter 0 to exit the program,else enter any other character : ");
       ck=s.nextInt();
          if(ck==0)
          {
            System.out.println("Program terminated");
            return,
          }
          //do sorting operation and compare the strings
        }
    }
  }
//Under develpoment
