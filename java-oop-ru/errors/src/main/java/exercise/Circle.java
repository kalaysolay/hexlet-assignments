package exercise;

import java.util.Map;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    //возвращает радиус круга
    public int getRadius() {
        return this.radius;
    }
    // возвращает площадь круга.
    // Если радиус круга меньше нуля, метод должен
    // выбросить исключение NegativeRadiusException
    public double getSquare() throws NegativeRadiusException {
        if (getRadius()<0){
         throw new NegativeRadiusException();
        }

        return Math.PI*Math.pow(getRadius(),2);
    }
}
// END
