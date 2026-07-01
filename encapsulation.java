class St {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class encapsulation {

    public static void main(String[] args) {

        St s = new St();

        s.setName("Karthik");

        System.out.println(s.getName());
    }
}