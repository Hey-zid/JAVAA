//Topic Covered : Instance Method , Static Method

class Students{

    int id = 324;
    String name = "Bayazid" ;

    void display(){
        System.out.println("YOUR UNIQUE ID   :" +id);
        System.out.println("YOUR NAME        :" +name);
    }

    static void greetings(){
        System.out.println(" WELCOME TO THE UMS  ");
    }
}

public class Methods {
    public static void main(String[] args){

        System.out.println();
        Students.greetings(); //Calling Static Methods

        System.out.println("====================");

        Students s1 = new Students();
        s1.display(); //Calling Instance Methods
    }
}
