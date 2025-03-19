package Shape;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class RegularPolygon implements Shape{
    int numberOfSide;
    double side;
    double apothem;
    Point origin;
    LocalTime timestamp;
    public RegularPolygon(Point origin , List<Integer> dimension){
        this.origin = origin;
        this.numberOfSide = dimension.get(0);
        this.side = dimension.get(1);
        this.apothem = dimension.get(2);
        this.timestamp = LocalTime.now();
    }
    @Override
    public List<Point> getCoordinates(){
        List<Point> coordinates = new ArrayList<>();
        return coordinates;
    }
    @Override
    public ShapeType getType(){
        return ShapeType.RegularPolygon;
    }
    @Override
    public double getArea(){
        return (numberOfSide * side * apothem)/2;
    }
    @Override
    public double getPerimeter(){
        return (numberOfSide * side);
    }
    @Override
    public Point getOrigin(){
        return origin;
    }
    @Override
    public boolean isPointEnclosed(Point p){
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}
