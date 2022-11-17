interface ChannelBuilder {
    void BuildChannel();

    Product getChannel();

    double getCost();
}

class WiFi implements ChannelBuilder {
    private Product product = new Product();

    public void BuildChannel() {
        product.add("Wifi module added");
    }

    public Product getChannel() {
        return product;
    }

    public double getCost() {
        return 750;
    }
}

class Mobile_Data implements ChannelBuilder {
    private Product product = new Product();

    public void BuildChannel() {
        product.add("SIM slot added");
    }

    public Product getChannel() {
        return product;
    }

    public double getCost() {
        return 50 * 12;
    }

}