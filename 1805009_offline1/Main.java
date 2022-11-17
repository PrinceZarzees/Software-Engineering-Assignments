import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import Account.*;
import Employee.*;

class Bank {
    private ArrayList<Account> accounts;
    private Managing_Director md;
    private ArrayList<Officer> officers;
    private ArrayList<Cashier> cashiers;
    private double internal_fund;
    public int year;
    //public BufferedReader br;

    Bank() {
        accounts = new ArrayList<Account>();
        md = new Managing_Director("MD");
        officers = new ArrayList<Officer>(2);
        for (int i = 1; i <= 2; i++)
            officers.add(new Officer("O" + i));
        cashiers = new ArrayList<Cashier>(5);
        for (int i = 1; i <= 5; i++)
            cashiers.add(new Cashier("C" + i));
        internal_fund = 1000000;
        year = 0;
    }

    public void Create_Account(String name, String type, double dep) //throws Exception
    {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name)) {
                System.out.println("An account with that name already exists");
                return;
            }
        }
        Account obj;
        if (type.equals("Student"))
            obj = new Student(name, type);
        else if (type.equals("Savings"))
            obj = new Savings(name, type);
        else if (type.equals("Fixed deposit"))
            obj = new Fixed_Deposit(name, type);
        else if (type.equals("Loan"))
            obj = new Loan(name, type);
        else
            obj = null;

        if (obj.first_deposit(dep) == false) {
            System.out.println("Initial Deposit rule violated");
            return;
        }
        accounts.add(obj);
        System.out.println(type + " Account for " + name + " Created;initial balance " + dep + "$");
        open_account(obj);
    }

    public void inc() {
        year += 1;
        System.out.println(year + " year passed");
        for (int i = 0; i < accounts.size(); i++)
            internal_fund += accounts.get(i).inc();

    }

    public void open(String name) //throws Exception
    {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name)) {
                Account obj;
                obj = accounts.get(i);
                System.out.println("Welcome back," + obj.getName());
                open_account(obj);
                return;
            }
        }
        Employee obj = null;
        if (name.charAt(0) == 'O')
            for (int i = 0; i < officers.size(); i++) {

                if (officers.get(i).getID().equals(name)) {
                    obj = officers.get(i);
                    System.out.print(obj.getID() + " Active,");
                    for (int j = 0; j < accounts.size(); j++) {
                        if (accounts.get(j).loan_request == true) {
                            System.out.print("There are loan approvals pending");
                            break;
                        }
                    }
                    System.out.println();
                    break;
                }

            }
        else if (name.charAt(0) == 'C')

            for (int i = 0; i < cashiers.size(); i++) {
                if (cashiers.get(i).getID().equals(name)) {
                    obj = cashiers.get(i);
                    System.out.print(obj.getID() + " Active,");
                    System.out.println();
                    break;
                }

            }
        else if (name.equals("MD")) {

            System.out.print("MD Active,");
            obj = md;
            for (int j = 0; j < accounts.size(); j++) {
                if (accounts.get(j).loan_request == true) {
                    System.out.print("There are loan approvals pending");
                    break;
                }
            }
            System.out.println();

        }
        if (obj == null) {
            System.out.println("No such Account or Employee");
            return;
        }
        open_employee(obj);

    }

    public void open_account(Account obj) //throws Exception
    {
        //String strline;
        //while ((strline = br.readLine()) != null) {
        //String command = strline;
        while (true) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            String[] words = command.split(" ");

            if (command.equals("Query")) {
                obj.query();
            }
            if (words[0].equals("Deposit")) {
                if (obj.deposit(Double.parseDouble(words[1])))
                    System.out.println(words[1] + "$ deposited; current balance " + obj.deposit + "$");
                else
                    System.out.println("Invalid Deposit");

            }
            if (words[0].equals("Withdraw")) {
                if (obj.withdraw(Double.parseDouble(words[1])))
                    System.out.println("Withdraw successful; current balance " + obj.deposit + "$");
                else
                    System.out.println("Invalid transaction; current balance " + obj.deposit + "$");
            }
            if (words[0].equals("Request")) {
                obj.request_loan(Double.parseDouble(words[1]));
                System.out.println("Loan request successful, sent for approval");

            }

            if (command.equals("Close")) {
                System.out.println("Transactions closed for " + obj.getName());
                return;
            }
        }

    }

    public void open_employee(Employee obj) //throws Exception
    {
        //String strline;
        //while ((strline = br.readLine()) != null) {
        //String command = strline;
        while (true) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            String[] words = command.split(" ");

            if (command.equals("Approve Loan"))
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).loan_request == true) {

                        internal_fund -= obj.approve_loan(accounts.get(i));
                    }
                }
            if (words[0].equals("Lookup")) {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getName().equals(words[1]))
                        System.out.println(words[1] + "'s current balance " + accounts.get(i).deposit);

                }
            }
            if (words[0].equals("Change")) {
                obj.change_int_rate(words[1], Double.parseDouble(words[2]) / 100);
            }
            if (command.equals("See")) {
                if (obj.see_int_fund())
                    System.out.println(internal_fund);
                else
                    System.out.println("You don't have permission for this operation");
            }
            if (command.equals("Close")) {
                System.out.println("Operations for " + obj.getID() + " closed");
                return;
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");

        try

        {
            // String sCurrentLine;
            // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            // bank.br = br;
            // while ((sCurrentLine = br.readLine()) != null) {
            // String command = sCurrentLine;
            Scanner scan = new Scanner(System.in);
            while (true) {

                String command = scan.nextLine();
                String[] words = command.split(" ");
                if (words[0].equals("Create")) {
                    bank.Create_Account(words[1], words[2], Double.parseDouble(words[3]));
                }
                if (words[0].equals("Open")) {
                    bank.open(words[1]);
                }
                if (command.equals("INC")) {
                    bank.inc();
                }

            }
        }

        catch (Exception e) {

        }

    }

}