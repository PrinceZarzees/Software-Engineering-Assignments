package Account;

public class Student extends Account {
    static double interest_rate = 0.05;

    public Student(String name, String type) {
        setName(name);
        setType(type);
        year = 0;
        deposit = 0;
        loan = 0;
        req_loan_amount = 0;
        loan_request = false;
    }

    public boolean get_loan_validity() {
        if (req_loan_amount <= 1000)
            return true;

        return false;
    }

    public static void set_interest_rate(double amount) {
        interest_rate = amount;
    }

    @Override
    public double get_interest_rate() {
        return interest_rate;
    }

    public boolean withdraw(double amount) {
        if (deposit - amount < 0)
            return false;
        else if (amount <= 10000)
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
