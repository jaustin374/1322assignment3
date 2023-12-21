public abstract class Box extends Mail {
    private double height;
    private int count;

    public Box() {
        super();
        height = 0;
        count = 0;
    }

    public Box(String dA, String rA, double w, double l, double h, int c) {
        super(dA, rA, w, l);
        height = h;
        count = c;
    }

    public double getHeight() {
        return height;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+ getWidth() +" x "+getLength()+" x "+getHeight();
    }
}
