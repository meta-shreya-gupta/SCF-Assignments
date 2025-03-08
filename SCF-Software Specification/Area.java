import java.util.Scanner;

/**
* A utility class for finding area of triangle , rectangle , square , circle 
*/
class Area{
    private static final double PI = 22.0/7.0;          //setting value of pi as constatnt for area of circle
    private static final double DIVISOR_FOR_TRIANGLE = 2.0; //setting the divisor for area of triangle

    /**
    * Find area of triangle using width*height/2 . give all parameters in same unit
    * @param width double value as base of the triangle . cannot be negative or 0
    * @param height double value as height of the triangle . cannot be negative or 0
    * @throws IllegalArgumentException if width or height is less than or equal 0
    * @return double value representing the area of triangle
    */
    public double calculateTriangleArea( double width , double height ){        //calculates area of triangle
        if( width <= 0 || height <= 0){                                         // checks width and height to be positive
            throw new IllegalArgumentException( "Invalid dimensions for triangle" );
        }
        return (double)(width * height) / DIVISOR_FOR_TRIANGLE;                 //returns area as double type
    }

    /**
    * Find area of rectangle using width*height . give all parameters in same unit
    * @param width double value as width of rectangle . cannot be negative or 0
    * @param height double value as height of the rectangle . cannot be negative or 0
    * @throws IllegalArgumentException if width or height is less than or equal 0
    * @return double value representing the area of rectangle
    */
    public double calculateRectangleArea( double width , double height ){          // calculates area of rectangle
        if( width <=0 || height <= 0 ){                                            //checks width and height to be positive
            throw new IllegalArgumentException( "Invalid dimensions for rectangle" );
        }
        return width * height;                                                      //returns area of rectangle as double type
    }

    /**
    * Find area of square using width*width 
    * @param width double value as width of square . cannot be negative or 0
    * @throws IllegalArgumentException if width or height is less than or equal 0
    * @return double value representing the area of rectangle
    */
    public double calculateSquareArea( double width ){                              // calculates area of squrae
        if( width <= 0 ){                                                           // checks width to be positive
            throw new IllegalArgumentException( "Invalid dimensions for square" );
        }
        return width * width;                                                       //returns area of square
    }

    /**
    * Find area of circle using PI*radius*radius
    * @param radius double value as width of rectangle . cannot be negative or 0
    * @throws IllegalArgumentException if width or height is less than or equal 0
    * @return double value representing the area of square
    */
    public double CalculateCircleArea( double radius ){                         // calculates area of circle
        if( radius <= 0 ){                                                      //checks radius to be positive
            throw new IllegalArgumentException( "Invalid dimension for circle" );
        }
        return PI * radius * radius;                                            //calculates area of circle
    }

    public static void main( String[] args ){
        Scanner sc = new Scanner( System.in );
        double width = 0;                                                       // initializing dimensions to be 0
        double height = 0;
        double radius = 0;

        Area area = new Area();                                                 //initializing object of the area class

        System.out.println( "Enter 1. Calculate area of triangle \n2. Calculate area of rectangle \n3. Calculate area of square \n4. Calculate area of circle " );

        int choice = sc.nextInt();

        try{
            switch( choice ){

                case 1 :
                    System.out.println( "Enter width of Triangle " );           //takes width of triangle as input from user
                    width = sc.nextDouble();
                    System.out.println( "Enter height of traingle " );          //takes height of triangle from the user
                    height = sc.nextDouble();
                    System.out.println( "Area of Triangle = " + area.calculateTriangleArea( width,height ));
                    break;

                case 2 :
                    System.out.println( "Enter width of rectangle " );      //takes width of rectangle from the user
                    width = sc.nextDouble();
                    System.out.println( "Enter height of rectangle " );     //takes height of rectangle from the user
                    height = sc.nextDouble();
                    System.out.println( "Area of rectangle = " + area.calculateRectangleArea( width,height ));
                    break;

                case 3 :
                    System.out.println( "Enter width of square " );         //takes width of the square from the user
                    width = sc.nextDouble();
                    System.out.println( "Area of square = " + area.calculateSquareArea( width ));
                    break;

                case 4 :
                    System.out.println( "Enter radius of circle " );        //takes radius of circle from the user
                    radius = sc.nextDouble();
                    System.out.println( "Area of circle = " + area.CalculateCircleArea( radius ));
                    break;

                default :
                    System.out.println( "No such operation available " );
            }
        }catch( IllegalArgumentException e ){           //throws erroe if dimensions are non-positive
            System.out.println( "Error : " + e.getMessage());
        }
        finally{                                        // closes Scanner library and exit program
            sc.close();
            System.exit(0);
        }
    }
}