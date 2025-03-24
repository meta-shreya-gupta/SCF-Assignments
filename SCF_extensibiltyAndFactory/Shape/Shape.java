package Shape;

import java.time.LocalTime;
import java.util.List;

public interface Shape{
    public enum ShapeType{
        Circle , Square , Rectangle , Triangle , RegularPolygon
    }
    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(Point p);
    LocalTime getTimestamp();
    ShapeType getType();
    List<Point> getCoordinates();
}