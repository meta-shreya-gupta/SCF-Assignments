import java.util.Scanner;

/**
* A utility class for calculating average grade, maximum grade, minimum grade, percent of students passed in a class 
*/
class Marksheet{

    private double[] grades;                        //array to store grades
    private static final int PASS_MARKS = 40;       //declarimg passing marks as constant

    public Marksheet( double[] grades ){
        this.grades = grades;
    }

    /**
    * Calculates average grade of all the students . throws Arithmetic exception if grades array is empty
    * @return double value representing the average grade upto 2 decimal value
    */
    public double getAverage(){                 //calculates average of all the grades
        int numberOfStudents = grades.length;

        if(numberOfStudents == 0){              //if no grades are there then throws exception
            throw new ArithmeticException( "Cannot calculate average as no grades are specified" );
        }

        double sum = 0;

        for( double grade : grades ){           //calculates sum of all the grades
            sum += grade;
        }
        return (double) sum / numberOfStudents;     //return average of all the grades as double value
    }

    /**
    * Find maximum marks among all marks . throws Arithmetic exception if grades array is empty
    * @return double value representing the maximum grade upto 2 decimal value
    */
    public double getMaximum(){             //finds maximum of all the grades

        int numberOfStudents = grades.length;

        if(numberOfStudents == 0){              //if no grades are there then no maximum marks possible
            throw new ArithmeticException( "Cannot calculate Maximum Marks : No grades provided" );
        }

        double maximumMarks = grades[0];

        for(double grade : grades){             //finds maximum grade
            if(grade > maximumMarks){
                maximumMarks = grade;
            }
        }
        return (double) maximumMarks;           //returns maximum grade as a double value
    }

    /**
    * Find minimum marks among all marks . throws Arithmetic exception if grades array is empty
    * @return double value representing the minimum grade upto 2 decimal value
    */
    public double getMinimum(){                 //calculates minimum of all the grades

        int numberOfStudents = grades.length;

        if(numberOfStudents == 0){              //if there are no grades then no minimum marks possible
            throw new ArithmeticException( "Cannot calculate Minimum Marks : No grades provided" );
        }

        double minimumMarks = grades[0];

        for(double grade : grades){         //finds minimum of all grades
            if(grade < minimumMarks){
                minimumMarks = grade;
            }
        }
        return (double) minimumMarks;       //returns minimum grade as double value
    }

    /**
    * counts passed students . calculates percent of passed students . throws Arithmetic exception if grades array is empty as division by 0 not possible
    * @return double value representing the percentage of passed students upto two decimal value
    */
    public double getPercentagePassed(){      //calculates percentage of students passed

        int numberOfStudents = grades.length;

        if(numberOfStudents == 0){           //if there are no grades then division by 0 not possible
            throw new ArithmeticException( "Cannot calculate percentage : No grades provided" );
        }

        int passCount = 0;

        for(double grade : grades){         //calculates number of students passed
            if(grade >= PASS_MARKS){
                passCount++;
            }
        }
        return ( ( double ) passCount / numberOfStudents) * 100;        //returns percentage of passed students
    }

    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);

        System.out.println( "Enter number of students : " );            //takes number of grades as input from user
        int numberOfStudents = sc.nextInt();

        double[] grades = new double[numberOfStudents];

        for( int index = 0 ; index < numberOfStudents ; index++ ){      //takes all grades as input from user
            System.out.println( "Enter marks of " + (index+1) + " student : ");
            grades[index] = sc.nextDouble();
        }

        Marksheet marksheet = new Marksheet(grades);

        try{                                                        //calculates average of all the marks 
            System.out.printf( "Average of all marks : %.2f%n" , marksheet.getAverage() );      //output upto 2 decimal values
        }catch(ArithmeticException e){
            System.out.println( "Error : " + e.getMessage());
        }

        try{
            System.out.printf( "Maximum of all marks : %.2f%n" , marksheet.getMaximum() );      //calculates maximum of all marks upto 2 decimal values
        }catch(ArithmeticException e){
            System.out.println( "Error : " + e.getMessage() );
        }

        try{
            System.out.printf( "Minimum of all marks : %.2f%n" , marksheet.getMinimum() );      //minimum of all marks upto 2 decimal values
        }catch(ArithmeticException e){
            System.out.println( "Error : " + e.getMessage() );
        }

        try{
            System.out.printf( "Percentage of students passed : %.2f%n" , marksheet.getPercentagePassed() );    //percent of students passed upto 2 decimal values
        }catch(ArithmeticException e){
            System.out.println( "Error : " + e.getMessage());
        }

        finally{                                //close scanner class and terminate the program
            sc.close();
            System.exit(0);
        }
    }
}