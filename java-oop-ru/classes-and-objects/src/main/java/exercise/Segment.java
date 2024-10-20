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
// END
