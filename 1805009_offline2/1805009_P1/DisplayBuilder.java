interface DisplayBuilder {
    void BuildDisplay();

    Product getDisplay();

    double getCost();
}

class Deluxe implements DisplayBuilder {
    private Product product = new Product();
    private int quantity;

    public Deluxe(int n) {
        quantity = n;
    }

    public void BuildDisplay() {
        product.add("LCD panel with Raspberry Pi");

    }

    public Product getDisplay() {
        return product;
    }

    public double getCost() {
        return 500 * quantity;
    }

}

class Optimal implements DisplayBuilder {
    private Product product = new Product();
    private int quantity;

    public Optimal(int n) {
        quantity = n;
    }

    public void BuildDisplay() {
        product.add("Arduino Mega with LED matrix");

    }

    public Product getDisplay() {
        return product;
    }

    public double getCost() {
        return 300 * quantity;
    }

}

class Poor implements DisplayBuilder {
    private Product product = new Product();
    private int quantity;

    public Poor(int n) {
        quantity = n;
    }

    public void BuildDisplay() {
        product.add("ATMega32 with LED matrix");

    }

    public Product getDisplay() {
        return product;
    }

    public double getCost() {
        return 100 * quantity;
    }
}