public class LiveBox extends Box {
    private String animal;
    private int age;

    public LiveBox() {
        super();
        animal = "";
        age = 0;
    }

    public LiveBox(String dA, String rA, double w, double l, double h, int c, String an, int ag) {
        super(dA, rA, w, l, h, c);
        animal = an;
        age = ag;
    }

    public String getAnimal() {
        return animal;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return super.toString()+"\nAnimal: "+getAnimal()+"\nCount: "+getCount()+"\nAge (Days): "+getAge();
    }
}
