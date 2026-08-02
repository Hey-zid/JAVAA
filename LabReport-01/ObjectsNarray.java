//Topic Covered : Passing objects as an array

//import java.util.Scanner;
class student
{
    int id;
    String name ;
    double cgpa;
    //int section;
    //String course;

    student(int id,String name,double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    void display(){

        System.out.println(id + " - " + name + " - CGPA: " + cgpa);
    }
}

public class ObjectsNarray {
    static void main(String[]args){

/*        Scanner input = new Scanner(System.in);

        double gpa;
        double cgpa;
        double sum=0;
        for (int i=0;i<=2;i++){
            System.out.println("Enter Three GPA for one Student :");
            gpa = input.nextInt();
            sum = sum+gpa;
        }

        cgpa = sum/3 ;*/


        student[]details = new student[3];
        details[0] = new student(324,"Bayazid",3.85);
        details[1] = new student(331,"Samia  ",3.78);
        details[2] = new student(346,"Mahidur",3.45);

        System.out.println("Students Details");

        for (student s : details) {

            s.display();

        }
    }
}