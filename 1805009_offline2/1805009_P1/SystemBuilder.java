import java.util.ArrayList;

interface SystemBuilder {
    void BuildSystem();

    Product getProduct();

    double getCost();
}

class Queue_System_Management implements SystemBuilder {
    AbstractFactory factory;
    DisplayBuilder db;
    ChannelBuilder cb;
    ApplicationBuilder ab;
    ControlUnitBuilder cub;
    private Product product = new Product();

    public Queue_System_Management(String display, String channel, int n) {
        factory = FactoryProducer.getFactory("Display");
        db = factory.getDisplayBuilder(display, n);
        factory = FactoryProducer.getFactory("Channel");
        cb = factory.getChannelBuilder(channel);
        factory = FactoryProducer.getFactory("Application");
        ab = factory.getApplicationBuilder();
        factory = FactoryProducer.getFactory("Control Unit");
        cub = factory.getControlUnitBuilder(n);
    }

    public void BuildSystem() {
        ArrayList<String> temp;
        if (db==null || cb==null || ab==null)
        {
            System.out.println("Sorry Product can not be created");
            return;
        }
        db.BuildDisplay();
        temp = db.getDisplay().added_parts();
        for (int i = 0; i < temp.size(); i++)
            product.add(temp.get(i));

        cb.BuildChannel();
        temp = cb.getChannel().added_parts();
        for (int i = 0; i < temp.size(); i++)
            product.add(temp.get(i));

        ab.BuildApplication();
        temp = ab.getApplication().added_parts();
        for (int i = 0; i < temp.size(); i++)
            product.add(temp.get(i));

        cub.BuildControlUnit();
        temp = cub.getControlUnit().added_parts();
        for (int i = 0; i < temp.size(); i++)
            product.add(temp.get(i));

    }

    public double getCost() {
        if (db==null || cb==null || ab==null)
        {
            return 0;
        }
        return db.getCost() + ab.getCost() + cb.getCost() + cub.getCost();

    }

    public Product getProduct() {
        return product;
    }

}