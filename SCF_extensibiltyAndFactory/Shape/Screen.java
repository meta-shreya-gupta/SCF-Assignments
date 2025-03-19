package Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Shape.Shape.ShapeType;

public class Screen {
    int XMAX ;
    int YMAX ;
    List<Shape> shapes;
    public Screen(int XMAX , int YMAX){
        this.XMAX = XMAX;
        this.YMAX = YMAX;
        this.shapes = new ArrayList<>();
    }
    private boolean canAddShape(Shape shape){
        for(Point p : shape.getCoordinates()){
            if(p.getX()<0 || p.getX()>XMAX || p.getY()<0 || p.getY()>YMAX){
                return false;
            }
        }
        return true;
    }
    public boolean addShape(Shape shape){
        if(canAddShape(shape)){
            shapes.add(shape);
            return true;
        }
        return false;
    }
    public boolean deleteShape(Shape shape){
        if(shapes.contains(shape)){
            shapes.remove(shape);
            return true;
        }
        return false;
    }
    public void deleteAllShapes(ShapeType type){
        for(Shape shape : shapes){
            if(shape.getType() == type){
                shapes.remove(shape);
            }
        }
    }
    public List<Shape> getEnclosedShapes(Point pt){
        List<Shape> pointEnclosed = new ArrayList<>();
        for(Shape shape : shapes){
            if(shape.isPointEnclosed(pt)){
                pointEnclosed.add(shape);
            }
        }
        return pointEnclosed;
    }
    public List<Shape> arrangeInOrder(String basis){
        Shape[] arrange = new Shape[shapes.size()];
        for(int index = 0 ; index < shapes.size() ; index ++){
            arrange[index] = shapes.get(index);
        }
        switch(basis){
            case "Area" :
                Arrays.sort(arrange , new Comparator<Shape>() {
                    @Override
                    public int compare(Shape s1 , Shape s2){
                        return Double.compare(s1.getArea() , s2.getArea());
                    }
                });
                break;
            case "Perimeter" :
                Arrays.sort(arrange , new Comparator<Shape>() {
                    @Override
                    public int compare(Shape s1 , Shape s2){
                        return Double.compare(s1.getPerimeter() , s2.getPerimeter());
                    }
                });
                break;
            case "Distance" :
                Arrays.sort(arrange , new Comparator<Shape>() {
                    @Override
                    public int compare(Shape s1 , Shape s2){
                        return Double.compare(s1.getOrigin().getDistanceFromOrigin() , s2.getOrigin().getDistanceFromOrigin());
                    }
                });
                break;
            // case "Timestamp" :
                // Arrays.sort(arrange , new Comparator<Shape>() {
                //     @Override
                //     public int compare(Shape s1 , Shape s2){
                //         return LocalTime.compare(s1.getTimestamp() , s2.getTimestamp());
                //     }
                // });
                // arrange.sort((a,b) => a.getTimestamp() - b.getTimestamp());
                // break;
            default :
                System.out.println("Cannot arrange on this basis");
        }
        List<Shape> arrangedList = Arrays.asList(arrange);
        return arrangedList;
    }
}
