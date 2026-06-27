import java.util.*;
public class simple_interest_formula {
    public static void main(String[]args){
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter the value of p: ");
         int p = sc.nextInt();
         System.out.println("Enter the value of r: ");
         int r = sc.nextInt();
         System.out.println("Enter the value of t: ");
         int t = sc.nextInt();
         int si = (p * r * t) / 100;
         System.out.println("Simple Interest: " + si);
         sc.close();
    }
}
