import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Beef burger with French fry and cheese");
        System.out.println("2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("5. A Beef burger only");
        System.out.println("Choose an option:");

        int option;
        Scanner scan = new Scanner(System.in);
        option = scan.nextInt();
        Food f;
        switch (option) {
            case 1:
                f = new French_Fry(new Cheese(new Beef()));
                System.out.println(f.prepareFood());
                System.out.println("Cost: "+f.FoodPrice());
                break;
            case 2:
                f = new Water(new Onion_Ring(new Veggi()));
                System.out.println(f.prepareFood());
                System.out.println("Cost: "+f.FoodPrice());
                break;
            case 3:
                f = new Coke(new French_Fry(new Veggi()));
                System.out.println(f.prepareFood());
                System.out.println("Cost: "+f.FoodPrice());
                break;
            case 4:
                f = new Water(new Coffee(new Onion_Ring(new Veggi())));
                System.out.println(f.prepareFood());
                System.out.println("Cost: "+f.FoodPrice());
                break;
            case 5:
                f = new Beef();
                System.out.println(f.prepareFood());
                System.out.println("Cost: "+f.FoodPrice());
                break;
            default:
                System.out.println("Please Enter 1-5");

        }

    }
}
