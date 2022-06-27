public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point p) {
        return isGreaterThan (p) && isLessThan (p);
    }

    private boolean isLessThan(Point p) {
        return p.getX () <= topRight.getX ()
                && p.getY () <= topRight.getY ();
    }

    private boolean isGreaterThan(Point p) {
        return p.getX () >= bottomLeft.getX ()
                && p.getY () >= bottomLeft.getY ();
    }
}
