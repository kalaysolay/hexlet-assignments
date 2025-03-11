package exercise;

// BEGIN
public class Cottage implements Home{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }


    @Override
    public double getArea() {
        return area;
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
