package Employee;

import Account.*;

public class Managing_Director extends Employee {
    public Managing_Director(String id) {
        setID(id);
    }

    public double approve_loan(Account obj) {
        double temp = 0;
        if (obj.loan_request == true) {
            temp = obj.update_loan();
            if (temp != 0) {
                System.out.println("Loan for " + obj.getName() + " Approved");
            } else {
                System.out.println("Loan for " + obj.getName() + "could not be Approved");
            }
        }
        return temp;
    }

    public void change_int_rate(String type, double value) {
        if (type.equals("Student"))
            Student.set_interest_rate(value);
        else if (type.equals("Savings"))
            Savings.set_interest_rate(value);
        else if (type.equals("Fixed_Deposit"))
            Fixed_Deposit.set_interest_rate(value);
    }

    public boolean see_int_fund() {
        return true;
    }

}
