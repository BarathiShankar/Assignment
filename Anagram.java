//Program to check whether 2 strings are anagrams or not
import java.util.Scanner;
import java.util.Arrays;
public class anagram
  {
    public static void main(String[]args)
    {
      Scanner s=new Scanner(System.in);
      String str1,str2;
      int ck;
      while(true)
        {
      System.out.print("Enter first string : ");
      str1=s.next();
      System.out.print("Enter second string : ");
          str2=s.next();
          if( (str1.length()) != (str2.length()))
          {
            System.out.println("Strings are not anagrams");
            continue;
          }
        char[] ch1=str1.toLowerCase().toCharArray();
          char[] ch2=str2.toLowerCase().toCharArray();
          Arrays.sort(ch1);
          Arrays.sort(ch2);
          String s1= new String(ch1);
          String s2= new String (ch2);
          if((s1.equalsIgnoreCase(s2)))
            System.out.println("Strings are anagram");
          else
            System.out.println("Strings are not Anagram");
       System.out.print("Enter 0 to exit the program,else enter any other number : ");
       ck=s.nextInt();
          if(ck==0)
          {
            System.out.println("Program terminated");
            return;
          }
        }
    }
  }
  //COMPLETED
