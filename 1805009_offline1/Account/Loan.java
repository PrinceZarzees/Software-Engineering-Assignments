package Account;

public class Loan extends Account {

    public Loan(String name, String type) {
        setName(name);
        setType(type);
        year = 0;
        deposit = 0;
        loan = 0;
        req_loan_amount = 0;
        loan_request = false;
    }

    public boolean get_loan_validity() {
        if (req_loan_amount == 0.05 * loan)
            return true;

        return false;
    }

    public boolean deposit(double amount) {
        if (loan - amount < 0)
            return false;
        else
            loan -= amount;
        return true;
    }

    public boolean withdraw(double amount) {
        return false;
    };

    public double inc() {
        double value = 0.10 * loan;
        loan += loan * 0.10;
        year += 1;
        return value;
    }

}
