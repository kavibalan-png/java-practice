package string;

public class split {
    public static void main(String[] args) {
        String name = "Jana, Gugan, John";
        String[] names = name.split(", ");
        for (String n : names) {
            System.out.println(n);
        }
    }
    
}
