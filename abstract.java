// This file contains abstract class examples.
// Note: 'abstract' is a Java keyword, so the public class is in BankSystem.java
// See BankSystem.java for the runnable version of this code.

abstract class Bank {

    // Abstract Method
    abstract void getInterestRate();

    // Normal Method
    void bankInfo() {
        System.out.println("Welcome to the Bank");
    }
}

class SBI extends Bank {
    void getInterestRate() {
        System.out.println("SBI Interest Rate: 6.5%");
    }
}

class ICICI extends Bank {
    void getInterestRate() {
        System.out.println("ICICI Interest Rate: 7%");
    }
}