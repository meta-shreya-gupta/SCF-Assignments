package Shape;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
class Triangle implements Shape{
    double side1;
    double side2;
    double side3;
    Point origin;
    LocalTime timestamp;
    Point A;
    Point B;
    Point C;
    public Triangle(Point origin , List<Integer> dimension){
        this.origin = origin;
        this.side1 = dimension.get(0);
        this.side2 = dimension.get(1);
        this.side3 = dimension.get(2);
        this.timestamp = LocalTime.now();
    }

    @Override
    public List<Point> getCoordinates(){
        List<Point> coordinates = new ArrayList<>();
        return coordinates;
    }
    @Override
    public ShapeType getType(){
        return ShapeType.Triangle;
    }
    @Override
    public double getArea(){
        double semiPeri = (side1 + side2 + side3)/2;
        double area = Math.sqrt((semiPeri - side1) * (semiPeri - side2) * (semiPeri - side3));
        return area;
    }
    @Override
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    @Override
    public Point getOrigin(){
        return origin;
    }
    public void setCornerPoints(){
        A = new Point(origin.getX() , origin.getY());
        B = new Point((origin.getX() + side1) , origin.getY());
        double area = getArea();
        double height = (2 * area)/side1;
        double xCoordinateOfC = A.getX() + Math.sqrt(Math.pow(side3,2) - Math.pow(height,2));
        double yCoordinateOfC = A.getY() + height;
        C = new Point(xCoordinateOfC , yCoordinateOfC);
    }
    public double calculateDistances(Point A , Point B){
        double distance = 0 ;
        double firstTerm = Math.pow((B.getX() - A.getX()) , 2);
        double secondTerm = Math.pow((B.getY() - B.getX()) , 2);
        distance = Math.sqrt(firstTerm + secondTerm);
        return distance;
    }
    public double calculateArea(double side1 , double side2 , double side3){
        double semiPeri = (side1 + side2 + side3)/2;
        double area = Math.sqrt((semiPeri - side1) * (semiPeri - side2) * (semiPeri - side3));
        return area;
    }
    @Override
    public boolean isPointEnclosed(Point p){
        if(A == null || B == null || C == null){
            setCornerPoints();
        }
        double AB = side1;
        double BC = side2;
        double AC = side3;

        double PA = calculateDistances(p, A);
        double PB = calculateDistances(p, B);
        double PC = calculateDistances(p, C);

        double areaPAB = calculateArea(PA, PB, AB);
        double areaPAC = calculateArea(PA, PC, AC);
        double areaPBC = calculateArea(PC, PB, BC);

        double totalArea = getArea();
        if((areaPAB + areaPAC + areaPBC) == totalArea){
            return true;
        }
        return false;
    }
    @Override
    public LocalTime getTimestamp(){
        return timestamp;
    }
}
