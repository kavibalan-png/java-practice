package string;

public class regionMatches {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = "HelloJava";
        
        boolean result = str1.regionMatches(5, str2, 5, 4);
        System.out.println(result); // Output: true
    }
    
}
