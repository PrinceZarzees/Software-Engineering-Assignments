interface ApplicationBuilder {
    void BuildApplication();

    Product getApplication();

    double getCost();
}

class Application implements ApplicationBuilder {
    private Product product = new Product();

    public void BuildApplication() {
        product.add("Application created");
    }

    public Product getApplication() {
        return product;
    }

    public double getCost() {
        return 2000;
    }

}