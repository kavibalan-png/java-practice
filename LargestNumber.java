import java.util.*;
public class LargestNumber {
    public static void main(String[]args){
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter the value of a: ");
         int a = sc.nextInt();
         System.out.println("Enter the value of b: ");
         int b = sc.nextInt();
         System.out.println("Enter the value of c: ");
         int c = sc.nextInt();
         if(a>b && a>c){
            System.out.println("A is large!");
         }
         else if(b>a && b>c){
            System.out.println("B is large!");
         }
         else{
            System.out.println("C is large!");
         }
    }
}
