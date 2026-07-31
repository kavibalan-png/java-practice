public class try4 {
    public static void main(String[] args) {
        try {
            String name = null;
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println("String is null. Cannot perform length().");
        }
        System.out.println("Program End");
    }
}