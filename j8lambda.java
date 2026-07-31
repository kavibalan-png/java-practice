import java.util.*;
class Student5 {
    int id;
    String name;
    Student5(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return id + " " + name;
    }
}
public class j8lambda {
    public static void main(String[] args) {
        ArrayList<Student5> list = new ArrayList<>();
        list.add(new Student5(103,"Ravi"));
        list.add(new Student5(101,"Priya"));
        list.add(new Student5(102,"Kumar"));
        Collections.sort(list,
                (s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println(list);
    }}