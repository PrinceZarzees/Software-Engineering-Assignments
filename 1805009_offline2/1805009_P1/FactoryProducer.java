class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if (type.equals("Display"))
            return new DisplayFactory();
        if (type.equals("Channel"))
            return new ChannelFactory();
        if (type.equals("Application"))
            return new ApplicationFactory();
        if (type.equals("Control Unit"))
            return new ControlUnitFactory();
        return null;
    }

}