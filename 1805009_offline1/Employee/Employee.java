package Employee;

import Account.*;

public abstract class Employee {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public void lookup(Account obj) {
        System.out.println(obj.deposit);
    }

    public double approve_loan(Account obj) {
        System.out.println("You don't have permission for this operation");
        return 0;
    }

    public void change_int_rate(String type, double value) {
        System.out.println("You don't have permission for this operation");
    }

    public boolean see_int_fund() {
        return false;
    }

}
