package fr.sebmartin.pattern.poc.pattern.gof.facade.realworld;

import java.io.IOException;

/**
 * Facade pattern -- Real World example
 *
 * @author seb
 * @version 1.0 du 18/05/13 à 12:09
 */
public class MainApp {

    /**
     * MainApp startup class for Real-World
     * Facade Design Pattern.
     *
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        // Facade
        Mortgage mortgage = new Mortgage();

        // Evaluate mortgage eligibility for customer
        Customer customer = new Customer("Ann McKinsey");
        boolean eligible = mortgage.isEligible(customer, 125000);

        System.out.println("\n" + customer.getName() +
                " has been " + (eligible ? "Approved" : "Rejected")
        );


        //noinspection ResultOfMethodCallIgnored
        System.in.read();

    }
}
/**
 * The 'Subsystem ClassA' class
 */
class Bank{

    public boolean hasSufficientSavings(Customer c, @SuppressWarnings("UnusedParameters") int amount) {
        System.out.println("Check bank for " + c.getName());
        return true;
    }
}

/**
 * The 'Subsystem ClassB' class
 */
class Credit{
    public boolean hasGoodCredit(Customer c) {
        System.out.println("Check credit for " + c.getName());
        return true;
    }
}

/**
 * The 'Subsystem ClassC' class
 */
class Loan{
    public boolean hasNoBadLoans(Customer c) {
        System.out.println("Check loans for " + c.getName());
        return true;
    }
}

class Customer{
    private String name;

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

/**
 * The 'Facade' class
 */
class Mortgage{
    private Bank bank = new Bank();
    private Credit credit = new Credit();
    private Loan loan = new Loan();

    public boolean isEligible(Customer cust, int amount) {
        System.out.printf("%s applies for %d loan\n\n", cust.getName(), amount);
        boolean eligible = true;

        // Check creditworthyness of applicant
        if (!bank.hasSufficientSavings(cust, amount)) {
            eligible = false;
        } else if (!loan.hasNoBadLoans(cust)) {
            eligible = false;
        } else if (!credit.hasGoodCredit(cust)) {
            eligible = false;
        }

        return eligible;
    }
}
