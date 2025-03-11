package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Квартира площадью " + getArea() +
                " метров на " + floor +
                " этаже";
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home home) {
        if (this.getArea() > home.getArea())
        {
            return 1;
        } else if (this.getArea() <home.getArea()) {
            return -1;
        }
        else return 0;
    }
}
// END
