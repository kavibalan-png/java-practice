public class StringBufferMethodsDemo {
    public static void main(String[] args) {

        // Create StringBuffer object
        StringBuffer sb = new StringBuffer("Hello");

        // 1. append()
        sb.append(" Java");
        System.out.println("append(): " + sb);

        // 2. insert()
        sb.insert(5, " World");
        System.out.println("insert(): " + sb);

        // 3. delete()
        sb.delete(5, 11);
        System.out.println("delete(): " + sb);

        // 4. replace()
        sb.replace(6, 10, "Python");
        System.out.println("replace(): " + sb);

        // 5. reverse()
        sb.reverse();
        System.out.println("reverse(): " + sb);

        // Reverse again to get original text
        sb.reverse();

        // 6. length()
        System.out.println("length(): " + sb.length());

        // 7. charAt()
        System.out.println("charAt(1): " + sb.charAt(1));
    }
