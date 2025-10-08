//Program use interface for multithreading and show tre time difference between multitask and multithreading
import java.time.*;
public class main
{
    public static void main(String args[])
    {
        fn f=new fn();
        Thread t=new Thread(f);
        t.start();
        long start = System.currentTimeMillis();
        System.out.println("Main Thread time : "+(System.currentTimeMillis()-start));
    }
}
class fn implements Runnable
{
    public void run()
    {
        long start = System.currentTimeMillis();
        int sum=0;
        for(int i=0;i<1000000000;i++)
        {
            sum+=i;
        }
        System.out.println("Created Thread time : "+(System.currentTimeMillis()-start));
    }
}
