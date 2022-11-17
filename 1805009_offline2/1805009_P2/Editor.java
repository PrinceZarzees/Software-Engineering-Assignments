class Editor {
    private static Editor editor = null;
    private parser p;
    private font f;

    private Editor() {

    }

    private void set_Lang(String lang) {
        AbstractFactory factory = FactoryProducer.getFactory("Parser");
        p = factory.getParser(lang);
        factory = FactoryProducer.getFactory("Font");
        f = factory.getFont(lang);

    }

    public static Editor getEditor() {
        if (editor == null) {
            editor = new Editor();
        } else {
            System.out.println("multiple instances of the editor cannot run simultaneously");
        }
        return editor;
    }

    public void show(String lang) {
        set_Lang(lang);
        if (p != null)
            p.Show_Parser();
        if (f != null)
            f.Show_Font();

        if (p == null || f == null) {
            System.out.println(lang + " not supported");
        }

    }
}