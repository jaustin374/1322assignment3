public class RegularBox extends Box {
    private String items;
    private double weight;

    public RegularBox() {
        super();
        items = "";
        weight = 0f;
    }

    public RegularBox(String dA, String rA, double wi, double l, double h, int c, String i, double we) {
        super(dA, rA, wi, l, h, c);
        items = i;
        weight = we;
    }

    public String getItems() {
        return items;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() + "\nItems: "+getItems()+"\nCount: "+getCount()+"\nWeight: "+getWeight();
    }
}
