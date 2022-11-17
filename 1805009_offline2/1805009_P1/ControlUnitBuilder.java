interface ControlUnitBuilder {
    void BuildControlUnit();

    Product getControlUnit();

    double getCost();
}

class ControlUnit implements ControlUnitBuilder {

    private Product product = new Product();
    private int num_of_display;

    public ControlUnit(int n) {
        num_of_display = n;
    }

    public void BuildControlUnit() {
        product.add(num_of_display + " display manageable control unit created");

    }

    public Product getControlUnit() {

        return product;
    }

    public double getCost() {
        return 250 * num_of_display;
    }

}