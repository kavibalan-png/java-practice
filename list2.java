import java.util.ArrayList;

public class list2{
    public static void main(String[] args) {
        
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);
        fruits.set(1, "Mango");
        fruits.remove(2);
        System.out.println("List size: " + fruits.size());
        System.out.println("Fruits in the list:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
    }
}
