public class Letter extends Envelope {
    private String letterBody;

    public Letter() {
        super();
        letterBody = "";
    }

    public Letter(String dA, String rA, double w, double l, double t, String lB) {
        super(dA, rA, w, l, t);
        letterBody = lB;
    }

    public String getLetterBody() {
        return letterBody;
    }
}
