package Shape;
import java.util.List;

import Shape.Shape.ShapeType;


public class ShapeFactory {
    
    public static Shape createShape(ShapeType type, Point origin , List<Integer> dimensions){
        Shape shape = null;
        switch(type){
            case Rectangle :
                shape = new Rectangle(origin , dimensions);
                break;
            case Square :
                shape = new Square(origin , dimensions);
                break;
            case Circle :
                shape = new Circle(origin , dimensions);
                break;
            case Triangle :
                shape = new Triangle(origin , dimensions);
                break;
            case RegularPolygon :
                shape = new RegularPolygon(origin ,dimensions);
                break;
            default :
                System.out.println("Cannot create shape");
        }
        return shape;
    }
}
