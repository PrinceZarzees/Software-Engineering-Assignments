abstract class AbstractFactory {
    parser getParser(String type) {
        return null;
    }

    font getFont(String type) {
        return null;
    }
}

class ParserFactory extends AbstractFactory {
    public parser getParser(String type) {
        if (type.equals("c"))
            return new C();
        if (type.equals("cpp"))
            return new Cpp();
        if (type.equals("py"))
            return new Python();
        return null;
    }
}

class FontFactory extends AbstractFactory {
    public font getFont(String type) {
        if (type.equals("c"))
            return new C();
        if (type.equals("cpp"))
            return new Cpp();
        if (type.equals("py"))
            return new Python();
        return null;
    }

}
