package Shape;
import java.lang.Math;
public class Point {
    double x;
    double y;
    public Point(double x , double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x ;
    }
    public double getY(){
        return y;
    }
    public double getDistanceFromOrigin(){
        double distance = Math.sqrt(Math.pow(x , 2) + Math.pow(y , 2));
        return distance;
    }
}
