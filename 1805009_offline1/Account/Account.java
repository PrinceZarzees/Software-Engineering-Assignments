package Account;

public abstract class Account {
    private String name;
    private String type;
    public double deposit;
    protected double loan;
    protected double req_loan_amount;
    public boolean loan_request;
    public int year;

    protected void setName(String name) {
        this.name = name;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void query() {
        System.out.println("Current Balance " + deposit + "$, loan " + loan + "$");
    }

    public abstract boolean withdraw(double amount);

    public void request_loan(double amount) {
        req_loan_amount = amount;
        loan_request = true;
    };

    public abstract boolean get_loan_validity();

    public double update_loan() {
        double temp = 0;
        if (get_loan_validity() == true) {
            temp = req_loan_amount;
            loan = loan + req_loan_amount;
            deposit += loan;
            req_loan_amount = 0;
            loan_request = false;
            return temp;
        }
        return temp;
    }

    public double get_interest_rate() {
        return 0;
    }

    public boolean first_deposit(double amount) {
        deposit = amount;
        return true;
    }

    public abstract boolean deposit(double amount);

    public double inc() {
        double value = -get_interest_rate() * deposit + 500 + 0.10 * loan;
        deposit = deposit + get_interest_rate() * deposit;
        deposit = deposit - 500;
        deposit = deposit - 0.10 * loan;
        year += 1;
        return value;

    }

}