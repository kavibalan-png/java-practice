// Abstract Class
abstract class Bank {

    // Abstract Method
    abstract void getInterestRate();

    // Normal Method
    void bankInfo() {
        System.out.println("Welcome to the Bank");
    }
}

// Child Class SBI
class SBI extends Bank {

    void getInterestRate() {
        System.out.println("SBI Interest Rate: 6.5%");
    }
}

// Child Class ICICI
class ICICI extends Bank {

    void getInterestRate() {
        System.out.println("ICICI Interest Rate: 7%");
    }
}

// Main Class
public class BankSystem {

    public static void main(String[] args) {

        SBI sbi = new SBI();
        sbi.bankInfo();
        sbi.getInterestRate();

        System.out.println();

        ICICI icici = new ICICI();
        icici.bankInfo();
        icici.getInterestRate();
    }
}