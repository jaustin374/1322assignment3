public abstract class Envelope extends Mail {
    private double thickness;

    public Envelope() {
        super();
        thickness = 0d;
    }

    public Envelope(String dA, String rA, double w, double l, double t) {
        super(dA,rA,w,l);
        thickness = t;
    }

    public double getThickness() {
        return thickness;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +getWidth()+" x "+getLength()+" x "+getThickness();
    }
}
