import java.util.*;
class Stu1 {
    int id;
    String name;
    int marks;
    Stu1(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}
public class j88 {
    public static void main(String[] args) {
        ArrayList<Stu1> list = new ArrayList<>();
        list.add(new Stu1(103, "Ravi", 80));
        list.add(new Stu1(101, "Priya", 90));
        list.add(new Stu1(102, "Kumar", 70));
        // Sort by ID
        Collections.sort(list,
                (s1, s2) -> s1.id - s2.id);
        System.out.println("Sort By ID");
        System.out.println(list);
        // Sort by Name
        Collections.sort(list,
                (s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("\nSort By Name");
        System.out.println(list);
        // Sort by Marks
        Collections.sort(list,
                (s1, s2) -> s1.marks - s2.marks);
        System.out.println("\nSort By Marks");
        System.out.println(list);
    }
}
