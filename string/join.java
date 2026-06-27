package string;

public class join {
    public static void main(String[] args) {
        String[] names = {"Jana", "Gugan", "John"};
        String joinedNames = String.join(", ", names);
        System.out.println(joinedNames);
    }
    
}
