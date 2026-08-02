// ==========================================================
// EVERYTHING.JAVA
// A Complete Java Beginner Revision Program
// Class Name: Everything
// ==========================================================

import java.util.*;

//===========================================================
// Main Class
//===========================================================
public class everything {

    // Global Variable (Static)
    static int global = 100;

    //=======================================================
    // Main Method (Program Starts Here)
    //=======================================================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //===================================================
        // OUTPUT
        //===================================================
        System.out.println("=========== JAVA EVERYTHING ===========");

        //===================================================
        // VARIABLES & DATA TYPES
        //===================================================
        int age = 20;
        double cgpa = 3.95;
        char grade = 'A';
        boolean passed = true;
        String name = "John";

        System.out.println("\nVariables:");
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println("CGPA = " + cgpa);
        System.out.println("Grade = " + grade);
        System.out.println("Passed = " + passed);

        //===================================================
        // INPUT
        //===================================================
        System.out.print("\nEnter your name: ");
        String student = input.nextLine();

        System.out.print("Enter your age: ");
        int studentAge = input.nextInt();

        System.out.println("Welcome " + student);

        //===================================================
        // OPERATORS
        //===================================================
        int a = 15;
        int b = 4;

        System.out.println("\nArithmetic Operators");
        System.out.println("Addition = " + (a + b));
        System.out.println("Subtraction = " + (a - b));
        System.out.println("Multiplication = " + (a * b));
        System.out.println("Division = " + (a / b));
        System.out.println("Modulus = " + (a % b));

        System.out.println("\nRelational Operators");
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        System.out.println("\nLogical Operators");
        System.out.println(a > 5 && b < 10);
        System.out.println(a < 5 || b < 10);
        System.out.println(!(a < b));

        //===================================================
        // IF ELSE
        //===================================================
        System.out.println("\nIF ELSE");

        if (studentAge >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }

        //===================================================
        // SWITCH
        //===================================================
        System.out.println("\nSWITCH");

        int day = 2;

        switch(day){

            case 1:
                System.out.println("Saturday");
                break;

            case 2:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Other Day");
        }

        //===================================================
        // FOR LOOP
        //===================================================
        System.out.println("\nFOR LOOP");

        for(int i=1;i<=5;i++){
            System.out.println("i = " + i);
        }

        //===================================================
        // WHILE LOOP
        //===================================================
        System.out.println("\nWHILE LOOP");

        int i=1;

        while(i<=3){
            System.out.println(i);
            i++;
        }

        //===================================================
        // DO WHILE LOOP
        //===================================================
        System.out.println("\nDO WHILE");

        int j=1;

        do{
            System.out.println(j);
            j++;
        }while(j<=3);

        //===================================================
        // ARRAY
        //===================================================
        System.out.println("\nARRAY");

        int numbers[] = {10,20,30,40,50};

        for(int x : numbers){
            System.out.print(x + " ");
        }

        //===================================================
        // STRING METHODS
        //===================================================
        String text = "Java Programming";

        System.out.println("\n\nSTRING METHODS");

        System.out.println(text.length());
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(text.contains("Java"));
        System.out.println(text.substring(5));

        //===================================================
        // METHODS
        //===================================================
        System.out.println("\nMETHODS");

        hello();

        System.out.println(add(5,6));

        //===================================================
        // METHOD OVERLOADING
        //===================================================
        System.out.println(overload(5,3));
        System.out.println(overload(5.5,3.5));

        //===================================================
        // OBJECT
        //===================================================
        System.out.println("\nOBJECT");

        Student s1 = new Student("Alice",21);

        s1.display();

        //===================================================
        // ENCAPSULATION
        //===================================================
        System.out.println("\nENCAPSULATION");

        BankAccount acc = new BankAccount();

        acc.setBalance(5000);

        System.out.println(acc.getBalance());

        //===================================================
        // INHERITANCE
        //===================================================
        System.out.println("\nINHERITANCE");

        Dog d = new Dog();

        d.sound();

        //===================================================
        // POLYMORPHISM
        //===================================================
        System.out.println("\nPOLYMORPHISM");

        Animal a1 = new Dog();

        a1.sound();

        //===================================================
        // ABSTRACTION
        //===================================================
        System.out.println("\nABSTRACTION");

        Shape circle = new Circle();

        circle.draw();

        //===================================================
        // INTERFACE
        //===================================================
        System.out.println("\nINTERFACE");

        Laptop lap = new Laptop();

        lap.start();

        //===================================================
        // ARRAYLIST
        //===================================================
        System.out.println("\nARRAYLIST");

        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        //===================================================
        // EXCEPTION HANDLING
        //===================================================
        System.out.println("\nEXCEPTION");

        try{

            int result = 10/0;

            System.out.println(result);

        }
        catch(Exception e){

            System.out.println("Exception Caught");

        }
        finally{

            System.out.println("Finally Block Always Executes");

        }

        //===================================================
        // FILE HANDLING (Example Only)
        //===================================================

        /*
        File file = new File("data.txt");

        try{
            file.createNewFile();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        */

        input.close();

        System.out.println("\n=========== END OF PROGRAM ===========");
    }

    //=======================================================
    // METHOD
    //=======================================================
    static void hello(){
        System.out.println("Hello Java");
    }

    static int add(int a,int b){
        return a+b;
    }

    //=======================================================
    // METHOD OVERLOADING
    //=======================================================
    static int overload(int a,int b){
        return a+b;
    }

    static double overload(double a,double b){
        return a+b;
    }
}

//===========================================================
// CLASS
//===========================================================
class Student{

    String name;
    int age;

    Student(String n,int a){
        name=n;
        age=a;
    }

    void display(){
        System.out.println(name+" "+age);
    }
}

//===========================================================
// ENCAPSULATION
//===========================================================
class BankAccount{

    private double balance;

    public void setBalance(double b){
        balance=b;
    }

    public double getBalance(){
        return balance;
    }
}

//===========================================================
// INHERITANCE
//===========================================================
class  Animal{

    void sound(){
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal{

    @Override
    void sound(){
        System.out.println("Dog Barks");
    }
}

//===========================================================
// ABSTRACTION
//===========================================================
abstract class Shape{

    abstract void draw();
}

class Circle extends Shape{

    @Override
    void draw(){
        System.out.println("Drawing Circle");
    }
}

//===========================================================
// INTERFACE
//===========================================================
interface Device{

    void start();
}

class Laptop implements Device{

    @Override
    public void start(){

        System.out.println("Laptop Started");
    }
}