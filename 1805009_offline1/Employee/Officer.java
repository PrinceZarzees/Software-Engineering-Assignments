package Employee;

import Account.*;

public class Officer extends Employee {
    public Officer(String id) {
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

}
