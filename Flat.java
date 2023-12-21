public class Flat extends Envelope {
    private String contents;

    public Flat() {
        super();
        contents = "";
    }

    public Flat(String dA, String rA, double w, double l, double t, String c) {
        super(dA, rA, w, l, t);
        contents = c;
    }

    public String getContents() {
        return contents;
    }
}
