public class try6 {
    public static void main(String[] args) {
        try {
            String value = "ABC";
            int number = Integer.parseInt(value);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number! Please enter only numeric values.");
        }
        System.out.println("Program End");
    }
}
