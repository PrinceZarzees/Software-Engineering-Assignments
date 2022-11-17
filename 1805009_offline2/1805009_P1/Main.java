import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Display Unit:");
        String display=scan.nextLine();
        System.out.println("Enter Communication Method:");
        String channel=scan.nextLine();
        System.out.println("Enter number of display unit:");
        int n=scan.nextInt();


        SystemBuilder sb = new Queue_System_Management(display, channel,n);

        m.build(sb);

        Product item1 = sb.getProduct();
        item1.show();
        System.out.println("Total_Cost: "+sb.getCost());

    }
}