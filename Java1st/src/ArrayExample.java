import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class ArrayExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the size of the Array");
        int size = input.nextInt();

        int[] Arr =new int [size];
        System.out.println("Enter The Elements");

        for (int i =0; i < size ; i++){
            Arr[i] = input.nextInt();
        }
        // Traversing The Array
        for(int i =0; i< Arr.length; i++)
        {
            if (Arr[i]%2 == 0 )
                System.out.print(Arr[i]+ " ");
        }

        //Sorting
        Arrays.sort(Arr);

        for(int elements : Arr)
        {
            System.out.println(elements + " ");
        }
    }
}
