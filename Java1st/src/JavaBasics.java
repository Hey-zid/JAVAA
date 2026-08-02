// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Scanner;
public class  JavaBasics {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Create an object of Java class
        System.out.print("Enter the value of P = ");
        int p = input.nextInt();

        System.out.print("Enter the value of Q = ");
        int q = input.nextInt();

        System.out.print("Enter the value of R = ");
        int r = input.nextInt();

        int sum = p+q+r;

        System.out.println("Value of N+P is : "+sum);
        if (p > q && p > r)
        {
            System.out.println ("P is the biggest: "+p);
        }
        else if(q > r)
        {
            System.out.println ("Q is the biggest: "+q);
        }
        else
        {
            System.out.println ("R is the biggest: "+r);
        }

        //Less than

        if (p < q && p < r)
        {
            System.out.println ("P is the Smallest: "+p);
        }
        else if(q < r)
        {
            System.out.println ("Q is the Smallest: "+q);
        }
        else
        {
            System.out.println ("R is the Smallest: "+r);
        }

        System.out.println("Value of N+P is : "+sum);
    }
}

