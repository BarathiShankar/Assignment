//Program to use the concept of semaphore for solving the parking lot problem
import java.util.concurrent.*;
public class main
{
    public static void main(String [] args)
    {
        Semaphore se=new Semaphore(1);
        cars A = new cars(se,"Car A");
        cars B = new cars(se,"Car B");
        cars C = new cars(se,"Car C");
        Thread t1=new Thread(A);
        Thread t2=new Thread(B);
        Thread t3=new Thread(C);
        t1.start();
        t2.start();
        t3.start();
    }
}
class cars implements Runnable
{
    Semaphore sem;
    String name;
    cars(Semaphore se,String s)
    {
        sem=se;
        name=s;
    }
    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println(name + " occupied here");
            for(int i=5;i>0;i--) {
             System.out.println(name+" will vacate in "+ (i)+" secs");
                Thread.sleep(1000);
            }
            System.out.println(name+" vacated Successfully\n");
            sem.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
 
