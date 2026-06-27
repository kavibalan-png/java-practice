package string;

public class getBytes {
    public static void main(String[] args) {
        String name = "Jana";
        byte[] byteArray = name.getBytes();
        for (byte b : byteArray) {
            System.out.println(b);
        }
    }
    
}
