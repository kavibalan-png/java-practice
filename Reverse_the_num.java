import java.util.*;
public class Reverse_the_num{
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number:");
        // Logic
        int num=sc.nextInt();

        int a=num/100;       // hundreds digit
        int b=(num/10)%10;   // tens digit
        int c=num%10;        // units digit
        int rev=c*100 + b*10 + a;
        System.out.println("Reverse: "+ rev);
        sc.close();
    }
}
