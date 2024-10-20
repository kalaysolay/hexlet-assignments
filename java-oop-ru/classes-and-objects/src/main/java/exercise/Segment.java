package exercise;

// BEGIN
    public class Segment{
        private Point x;
        private Point y;

    public Segment(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    public Point getBeginPoint(){
        return this.x;
    }
    public Point getEndPoint(){
        return this.y;
    }
    public Point getMidPoint(){
        int midPoint1 = (this.x.getX() + this.y.getX())/2;
        int midPoint2 = (this.x.getY() + this.y.getY())/2;
        return new Point(midPoint1, midPoint2);
    }

}

/*
Создайте класс Segment. Внутри класса реализуйте конструктор, который принимает две точки — начало и конец отрезка.
Точка — это объект класса Point. В классе определите следующие методы:

getBeginPoint() — возвращает начальную точку отрезка.
getEndPoint() — возвращает конечную точку отрезка.
getMidPoint() — возвращает новую точку — середину отрезка.
Point point1 = new Point(4, 3);
Point point2 = new Point(6, 1);
Segment segment = new Segment(point1, point2);
Point midPoint = segment.getMidPoint();
midPoint.getX(); // 5
midPoint.getY(); // 2
 */
// END
