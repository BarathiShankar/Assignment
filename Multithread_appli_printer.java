//Program to show the running of a printer
import java.util.concurrent.*;
public class main
{
    static
    {
        System.out.println("Menu Box - \nThis program explains how the internal functioning of a printer is done,while we give 3 input data to be printed simultaneously\n\n");
    }
    public static void main(String [] args)
    {
        Semaphore se=new Semaphore(1);
        work A = new work(se,"File");
        work B = new work(se,"Image");
        work C = new work(se,"Document");
        Thread t1=new Thread(A);
        Thread t2=new Thread(B);
        Thread t3=new Thread(C);
        t1.start();
        t2.start();
        t3.start();
    }
}
class work implements Runnable
{
    Semaphore sem;
    String name;
    work(Semaphore se,String s)
    {
        sem=se;
        name=s;
    }
    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println(name + " is being printed...");
            for(int i=5;i>0;i--) {
                System.out.println(name+" printing will be completed within "+ (i)+" secs");
                Thread.sleep(1000);
            }
            System.out.println(name+" printed Successfully\n");
            sem.release();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
//COMPLETED
