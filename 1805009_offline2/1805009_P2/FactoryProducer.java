class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if (type.equals("Font"))
            return new FontFactory();
        if (type.equals("Parser"))
            return new ParserFactory();
        return null;

    }
}
