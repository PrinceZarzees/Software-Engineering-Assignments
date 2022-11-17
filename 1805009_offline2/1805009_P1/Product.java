import java.util.ArrayList;

class Product {
    private ArrayList<String> parts;

    public Product() {
        parts = new ArrayList<String>();
    }

    public void add(String s) {
        parts.add(s);
    }

    public ArrayList<String> added_parts() {
        return parts;
    }

    public void show() {
        System.out.println("Product created as follows");
        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i));
        }
    }

}
