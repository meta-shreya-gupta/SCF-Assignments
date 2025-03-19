package Shape;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
class Rectangle implements Shape{
    double length;
    double breadth;
    Point origin;
    LocalTime timestamp;
    public Rectangle(Point origin , List<Integer> dimension){
        this.origin = origin;
        this.length = dimension.get(0);
        this.breadth = dimension.get(1);
        this.timestamp = LocalTime.now();
    }
    @Override
    public List<Point> getCoordinates(){
        List<Point> coordinates = new ArrayList<>();
        coordinates.add(origin);
        coordinates.add(new Point((origin.getX() + length) , (origin.getY())));
        coordinates.add(new Point((origin.getX()) , (origin.getY() + breadth)));
        coordinates.add(new Point((origin.getX() + length) , (origin.getY() + breadth)));
        return coordinates;
    }
    @Override
    public ShapeType getType(){
        return ShapeType.Rectangle;
    }
    @Override
    public double getArea(){
        return length * breadth;
    }
    @Override
    public double getPerimeter(){
        return 2 * ( length + breadth );
    }
    @Override
    public Point getOrigin(){
        return origin;
    }
    @Override
    public boolean isPointEnclosed(Point p){
        if(p.getX() >= origin.getX() && p.getX() <= (origin.getX() + length) && p.getY() >= origin.getY() && p.getY() <= (origin.getY() + breadth)){
            return true;
        }
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}