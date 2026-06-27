package string;

public class intern {
    public static void main(String[] args) {
        String name1 = new String("Jana");
        String name2 = "Jana";
        System.out.println(name1.intern() == name2);
    } 
    
}
