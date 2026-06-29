// Interface
interface Payment {
    void pay();
}

// UPI Class
class UPI implements Payment {
    public void pay() {
        System.out.println("Payment made using UPI");
    }
}

// Card Class
class Card implements Payment {
    public void pay() {
        System.out.println("Payment made using Card");
    }
}

// Cash Class
class Cash implements Payment {
    public void pay() {
        System.out.println("Payment made using Cash");
    }
}

// Main Class
public class PaymentSystem {
    public static void main(String[] args) {

        UPI upi = new UPI();
        Card card = new Card();
        Cash cash = new Cash();

        upi.pay();
        card.pay();
        cash.pay();
    }
}