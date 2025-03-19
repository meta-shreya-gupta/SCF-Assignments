package Shape;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
class Square implements Shape{
    double width;
    Point origin;
    LocalTime timestamp;
    public Square(Point origin , List<Integer> dimension){
        this.origin = origin;
        this.width = dimension.get(0);
        this.timestamp = LocalTime.now();
    }
    @Override
    public List<Point> getCoordinates(){
        List<Point> coordinates = new ArrayList<>();
        coordinates.add(origin);
        coordinates.add(new Point((origin.getX() + width) , (origin.getY())));
        coordinates.add(new Point((origin.getX()) , (origin.getY() + width)));
        coordinates.add(new Point((origin.getX() + width) , (origin.getY() + width)));
        return coordinates;
    }
    @Override
    public ShapeType getType(){
        return ShapeType.Square;
    }
    @Override
    public double getArea(){
        return width * width;
    }
    @Override
    public double getPerimeter(){
        return 2 * width;
    }
    @Override
    public Point getOrigin(){
        return origin;
    }
    @Override
    public boolean isPointEnclosed(Point p){
        if(p.getX() >= origin.getX() && p.getX() <= (origin.getX() + width) && p.getY() >= origin.getY() && p.getY() <= (origin.getY() + width)){
            return true;
        }
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}
