 //Program to perform arithematic operations in complex number and override the default toString() and equals() method 
import java.util.Scanner;
class complex { double real, ima;
complex(double r, double i) {
    real = r;
    ima = i;
}
complex add(complex ano)
{
    double newr=this.real + ano.real;
    double newi = this.ima + ano.ima;
    return new complex(newr,newi);
}
complex subtract(complex ano)
{
    double newr = this.real - ano.real;
    double newi = this.ima - ano.ima;
    return new complex(newr,newi);
}
complex multiply(complex ano)
{
    double newr = (this.real * ano.real) - (this.ima * ano.ima);
    double newi = (this.ima * ano.real) + (this.real * ano.ima);
    return new complex(newr,newi);
}
complex divide(complex ano)
{
    double divi = Math.pow(ano.real,2)+Math.pow(ano.ima,2);
    double newr = ((this.real*ano.real) + (this.ima*ano.ima))/divi;
    double newi = ((this.ima*ano.real) - (this.real*ano.ima))/divi;
    return new complex(newr,newi);
}
public boolean equals(complex ano)
{
    return ((this.real == ano.real) && (this.ima == ano.ima));
}
@Override
public String toString()
{
    return (real + "+" + ima +"i");
}
 
} public class complex_no { public static void main(String[] args) { double r,i; complex[] c = new complex[2]; Scanner s=new Scanner(System.in); for(int in=0;in<2;in++) {
       System.out.print("\nEnter Complex number "+(in+1)+"-\nEnter the real number : ");
        r=s.nextDouble();
        System.out.print("Enter the imaginary number : ");
        i=s.nextDouble();
        c[in]=new complex(r,i);
    }
    System.out.println("Complex number 1 : "+c[0]+"\nComplex number 2 : "+c[1]);
    complex sum=c[0].add(c[1]);
    complex Difference = c[0].subtract(c[1]);
    complex Product = c[0].multiply(c[1]);
    complex Quotient = c[0].divide(c[1]);
    System.out.println("Sum : "+sum);
    System.out.println("Difference : "+Difference);
    System.out.println("Product : "+Product);
    System.out.println("Quotient : "+Quotient);
    System.out.println("Complex number 1.equals(complex number 2) : "+c[0].equals(c[1]));
}
}
//COMPLETED
