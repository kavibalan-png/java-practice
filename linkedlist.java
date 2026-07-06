import java.util.LinkedList;
public class linkedlist {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Mango");
        System.out.println("LinkedList : " + list);
        System.out.println("First Element : " + list.getFirst());
        System.out.println("Last Element : " + list.getLast());
        System.out.println("Size : " + list.size());
        System.out.println("Contains Mango : " + list.contains("Mango"));
        System.out.println("Contains Banana : " + list.contains("Banana"));
    }
}