import java.util.*;
public class collection {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("APPLE 1");
        names.add("GRAPS 2");
        names.add("PEANUT 1");
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("1"));
        names.remove("GRAPS 2");
        System.out.println(names);
    }
}