package Account;

public class Savings extends Account {
    static double interest_rate = 0.10;

    public Savings(String name, String type) {
        setName(name);
        setType(type);
        year = 0;
        deposit = 0;
        loan = 0;
        req_loan_amount = 0;
        loan_request = false;
    }

    public boolean get_loan_validity() {
        if (req_loan_amount <= 10000)
            return true;

        return false;
    }

    public static void set_interest_rate(double amount) {
        interest_rate = amount;
    }

    public double get_interest_rate() {
        return interest_rate;
    }

    public boolean withdraw(double amount) {
        if (deposit - amount >= 1000)
            deposit -= amount;
        else
            return false;
        return true;
    }

    public boolean deposit(double amount) {
        deposit += amount;
        return true;

    }

}