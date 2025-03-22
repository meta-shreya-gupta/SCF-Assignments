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
        List<Point> vertices = new ArrayList<>();
        double incrementAngle = 2 * Math.PI / numberOfSide;
        for(int index = 0 ; index < numberOfSide ; index ++){
            double angle = index * incrementAngle;
            double x = origin.getX() + (side * Math.cos(angle));
            double y = origin.getY() + (side * Math.sin(angle));
            vertices.add(new Point(x , y));
        }

        int intersections = 0 ;
        int numberOfVertices = vertices.size();

        for(int index = 0 , prevIndex = numberOfVertices - 1 ; index < numberOfVertices ; prevIndex = index++){
            Point v1 = vertices.get(index);
            Point v2 = vertices.get(prevIndex);

            if((v1.getY() > p.getY()) != (v2.getY() > p.getY())){
                double xItersection = (v2.getX() - v1.getX()) *(p.getY() - v1.getY()) /(v2.getY() - v1.getY()) +v1.getX();
                if(p.getX() < xItersection){
                    intersections++;
                }
            }

        }
        if(intersections % 2 != 0){
            return true;
        }
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}
