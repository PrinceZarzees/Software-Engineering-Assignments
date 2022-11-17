package Account;

public class Fixed_Deposit extends Account {
    static double interest_rate = 0.15;

    public Fixed_Deposit(String name, String type) {
        setName(name);
        setType(type);
        year = 0;
        deposit = 0;
        loan = 0;
        req_loan_amount = 0;
        loan_request = false;
    }

    public boolean get_loan_validity() {
        if (req_loan_amount <= 100000)
            return true;

        return false;
    }

    public static void set_interest_rate(double amount) {
        interest_rate = amount;
    }

    public double get_interest_rate() {
        return interest_rate;
    }

    public boolean first_deposit(double amount) {
        if (amount >= 100000)
            deposit = amount;
        else
            return false;
        return true;

    }

    public boolean deposit(double amount) {
        if (amount >= 50000)
            deposit += amount;
        else
            return false;
        return true;
    }

    public boolean withdraw(double amount) {
        if (year >= 1) {
            if (deposit - amount >= 0)
                deposit -= amount;
            else
                return false;
        } else
            return false;
        return true;

    }

}