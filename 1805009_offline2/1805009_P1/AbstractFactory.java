abstract class AbstractFactory {
    public DisplayBuilder getDisplayBuilder(String type, int n) {
        return null;
    }

    public ChannelBuilder getChannelBuilder(String type) {
        return null;
    }

    public ApplicationBuilder getApplicationBuilder() {
        return null;
    }

    public ControlUnitBuilder getControlUnitBuilder(int n) {
        return null;
    }

}

class DisplayFactory extends AbstractFactory {
    public DisplayBuilder getDisplayBuilder(String type, int n) {
        if (type.equals("Deluxe"))
            return new Deluxe(n);
        else if (type.equals("Optimal"))
            return new Optimal(n);
        else if (type.equals("Poor"))
            return new Poor(n);
        return null;

    }
}

class ChannelFactory extends AbstractFactory {
    public ChannelBuilder getChannelBuilder(String type) {
        if (type.equals("WiFi"))
            return new WiFi();
        else if (type.equals("Mobile Data"))
            return new Mobile_Data();

        return null;

    }

}

class ControlUnitFactory extends AbstractFactory {
    public ControlUnitBuilder getControlUnitBuilder(int n) {
        return new ControlUnit(n);
    }

}

class ApplicationFactory extends AbstractFactory {
    public ApplicationBuilder getApplicationBuilder() {
        return new Application();
    }
}