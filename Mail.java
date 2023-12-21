public abstract class Mail {
    private String deliveryAddress;
    private String returnAddress;
    private double width;
    private double length;
    private int id;
    private static int nextId = 0;

    public Mail() {
        deliveryAddress = "";
        returnAddress = "";
        width = 0d;
        length = 0d;
        id = nextId;
        nextId++;
    }

    public Mail(String dA, String rA, double w, double l) {
        deliveryAddress = dA;
        returnAddress = rA;
        width = w;
        length = l;
        id = nextId;
        nextId++;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "\n" + deliveryAddress + "\n" + returnAddress;
    }
}
