package Shape;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
class Circle implements Shape{
    final double PI = 22.0/7.0; 
    private double radius;
    private Point origin;
    private LocalTime timestamp;
    public Circle(Point origin , List<Integer> dimension){
        this.origin = origin;
        this.radius = dimension.get(0);
        this.timestamp = LocalTime.now();
    }
    @Override
    public List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        Point center = getCenter();
        coordinates.add(new Point((center.getX()) , (center.getY() + radius)));
        coordinates.add(new Point((center.getX()),(center.getY() - radius)));
        coordinates.add(new Point((center.getX() - radius) , (center.getY())));
        coordinates.add(new Point((center.getX() + radius) , (center.getY())));
        return coordinates;
    }
    @Override
    public double getArea(){
        return PI * radius * radius;
    }
    @Override
    public double getPerimeter(){
        return 2 * PI * radius;
    }
    @Override
    public Point getOrigin(){
        return origin;
    }
    @Override
    public ShapeType getType(){
        return ShapeType.Circle;
    }
    public Point getCenter(){
        double factor = 1 + (radius/(Math.pow(origin.getX() , 2) + Math.pow(origin.getY() , 2)));
        double xValue = factor * origin.getX();
        double yValue = factor * origin.getY();
        return new Point(xValue , yValue);
    }
    @Override
    public boolean isPointEnclosed(Point p){
        Point center = getCenter();
        double originX = origin.getX();
        double originY = origin.getY();
        double centerX = center.getX();
        double centerY = center.getY();
        double firstSquared = Math.pow((originX - centerX) , 2);
        double secondSquared = Math.pow((originY - centerY) , 2);
        if(Math.sqrt(firstSquared + secondSquared) <= radius){
            return true;
        }
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}