package Shape;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Shape.Shape.ShapeType;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Screen screen = new Screen(100, 100);
        List<Integer> dimensions = new ArrayList<>();
        dimensions.add(10);
        Shape shape1 = ShapeFactory.createShape(ShapeType.Circle, new Point(10,10), dimensions);
        dimensions.clear();
        dimensions.add(15);
        dimensions.add(5);
        Shape shape2 = ShapeFactory.createShape(ShapeType.Rectangle, new Point(10,15), dimensions);
        dimensions.clear();
        dimensions.add(11);
        Shape shape3 = ShapeFactory.createShape(ShapeType.Square, new Point(5,5), dimensions);
        if(screen.addShape(shape1)){
            System.out.println(shape1.getType() + "Added to screen");
        }
        else{
            System.out.println(shape1.getType() + "Cannot be added to screen");
        }

        if(screen.addShape(shape2)){
            System.out.println(shape2.getType() + "Added to screen");
        }
        else{
            System.out.println(shape2.getType() + "Cannot be added to screen");
        }

        if(screen.addShape(shape3)){
            System.out.println(shape3.getType() + "Added to screen");
        }
        else{
            System.out.println(shape3.getType() + "Cannot be added to screen");
        }
        Point newPoint = new Point(20,20);
        List<Shape> shapes = screen.getEnclosedShapes(newPoint);
        System.out.println("Shapes enclosing a point");
        for(Shape shape : shapes){
            System.out.println(shape.getType());
        }
        System.out.println("Enter criteria of sorting as Area or Perimeter or Distance");
        String basis = sc.nextLine();
        List<Shape> arrangedList = screen.arrangeInOrder(basis);
        System.out.println("Arranged in order " + basis);
        for(int index = 0 ; index <arrangedList.size() ; index++){
            System.out.println(arrangedList.get(index).getType());
        }
        sc.close();
    }
}
