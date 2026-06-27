public class odd_or_even {
    public static void main(String[] args) {
        int number = 7;

        if ((number & 1) == 1) {
            System.out.println(number + " is odd.");
        } else {
            System.out.println(number + " is even.");
        }
    }
}
