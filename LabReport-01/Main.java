//Topic Covered : class, constructors, this keyword, and constructor overloading

import java.util.Scanner;


class Student
{
    int id;
    String name ;
    int section;
    String course;
    int birth ;

    Student(int id,String name, int section, String course){
        this.name = name;
        this.course = course;
        this.id = id;
        this.section = section;
        this.birth = birth;  
    }

    void display()
    {
        System.out.println("ID       : " + id);
        System.out.println("NAME     : " + name);
        System.out.println("COURSE   : " + course);
        System.out.println("SECTION  : " + section);
        System.out.println("BIRTHDAY : " + birth);
    }
}


public class Main
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter Unique ID of The Student: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.println("Enter Student's Name: ");
        String name = input.nextLine();

        System.out.println("what is the section of the student: ");
        int section = input.nextInt();

        input.nextLine();

        System.out.println("Course Name Please: ");
        String course = input.nextLine();


        Student s1 = new Student(id, name, section, course);

        s1.display();

    }

}

