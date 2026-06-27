import java.util.*;
public class check_case {
    public static void main(String[]args){
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter the value of a: ");
         char a = sc.next().charAt(0);
         if(a>='A' && a<='Z'){
            System.out.println("Uppercase!");
         }
         else if(a>='a' && a<='z'){
            System.out.println("Lowercase!");
         }
         else if(a>='0' && a<='9'){
            System.out.println("Digit!");
         }
         else{
            System.out.println("Not an alphabet!");
         }
    }
}
