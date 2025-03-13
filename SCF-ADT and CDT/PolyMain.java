import java.lang.Math;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * class to initialise terms of the polynomial
 */
final class Term{
    private final int coefficient;
    private final int exponent;

    public Term(int coefficient , int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * getter method to get coefficient of the polynomial . cannot be 0
     * @return  coefficient of the term of the polynomial
     */
    public int getCoefficient(){
        return coefficient;
    }

    /**
     * getter method to get the exponent of the term user has entered
     * @return  exponent of the term of the polynomial
     */
    public int getExponent(){
        return exponent;
    }
}

/**
 * class to create polynomials as an array of Terms
 */
final class Poly{
    private final Term[] poly;

    public Poly(Term[] poly){
        this.poly = poly;
    }
    /**
     * It gives polynomial as an array of terms
     * @return  array of terms
     */
    public Term[] getTerms(){
        return poly;
    }

    /**
     * computes a polynomial on the value specified by the user
     * @param value on which polynomial is to be evaluated
     * @return computed value of the polynomial
     */
    public float evaluate(float value){
        float computedValue = 0;
        for(int index = 0 ; index < poly.length ; index ++){
            computedValue += poly[index].getCoefficient() * Math.pow(value , poly[index].getExponent());
        }
        return computedValue;
    }

    /**
     * finds the maximum exponent of the polynomial
     * @return maximum value of the exponent in a polynomial
     */
    public int getDegree(){
        int degree = 0;
        for(int index = 0 ; index < poly.length ; index ++){
            if(poly[index].getExponent() > degree){
                degree = poly[index].getExponent();
            }
        }
        return degree;
    }

    /**
     * computes addition of two polynomials specified by the user with non-zero coefficients
     * @param p1 first polynomial entered by the user with all terms with non-zero coefficient
     * @param p2 second polynomial entered by the user with all terms with non-zero coefficient
     * @return polynomial after adding polynomial p1 and p2 . rule-Like terms are added
     */
    public static Poly addPoly(Poly p1 , Poly p2){
        int maxSize = p1.poly.length + p2.poly.length;
        Term[] addResult = new Term[maxSize];
        int resultIndex = 0;
        for(int indexOfp1 = 0 ; indexOfp1 < p1.poly.length ; indexOfp1 ++){
            boolean found = false;
            for(int indexOfp2 = 0 ; indexOfp2 < p2.poly.length ; indexOfp2 ++){
                if(p1.poly[indexOfp1].getExponent() == p2.poly[indexOfp2].getExponent()){
                    int sumOfCoefficient = p1.poly[indexOfp1].getCoefficient() + p2.poly[indexOfp2].getCoefficient();
                    if(sumOfCoefficient != 0){
                        addResult[resultIndex++] = new Term(sumOfCoefficient, p1.poly[indexOfp1].getExponent());
                    }
                    found = true;
                    break;
                }
            }
            if(! found){
                addResult[resultIndex++] = p1.poly[indexOfp1];
            }
        }
        for(int indexOfp2 = 0 ; indexOfp2 < p2.poly.length ; indexOfp2 ++){
            boolean found = false ;
            for(int indexOfp1 = 0 ; indexOfp1 < p1.poly.length ; indexOfp1++){
                if(p2.poly[indexOfp2].getExponent() == p1.poly[indexOfp1].getExponent()){
                    found = true ;
                    break;
                }
            }
            if(! found){
                addResult[resultIndex++] = p2.poly[indexOfp2];
            }
        }
        Term[] finalResult = new Term[resultIndex];
        System.arraycopy(addResult, 0, finalResult, 0, resultIndex);
        return new Poly(finalResult);
    }

    /**
     * computes multiplication of two polynomials specified by the user with non-zero coefficient
     * @param p1 first polynomial entered by the user with non-zero coefficient
     * @param p2 second polynomial entered y theuser with non-zero coefficient
     * @return polynomial after multiplicating both the polynomials
     */
    public static Poly multiplyPoly(Poly p1 , Poly p2){
        Map<Integer,Integer> resultMap = new HashMap<>();
        for(int indexOfp1 = 0 ; indexOfp1 < p1.poly.length ; indexOfp1++){
            for(int indexOfp2 = 0 ; indexOfp2 < p2.poly.length ; indexOfp2++){
                int newCoefficient = p1.poly[indexOfp1].getCoefficient() * p2.poly[indexOfp2].getCoefficient();
                int newExponent = p1.poly[indexOfp1].getExponent() + p2.poly[indexOfp2].getExponent();
                resultMap.put(newExponent,resultMap.getOrDefault(newExponent,0)+newCoefficient);
            }
        }
        Term[] multiplyResult = new Term[resultMap.size()];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : resultMap.entrySet()){
            if(entry.getValue() != 0){
                multiplyResult[index++] = new Term(entry.getValue(),entry.getKey());
            }
        }
        return new Poly(multiplyResult);
    }
    /**
     * helper method to print the polynomial
     * @param input polynomial which we wnat to print
     */
    public static void printPoly(Poly input){
        for(Term term : input.poly){
            System.out.print(term.getCoefficient() +"x^"+term.getExponent()+" ");
        }
        System.out.println();
    }
}


public class PolyMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of terms of 1st polynomial");
        int countTerm = sc.nextInt();
        Term[] terms = new Term[countTerm];
        for(int index = 0 ; index < countTerm ; index ++){
            System.out.println("Enter coefficient");
            int coefficient = sc.nextInt();
            System.out.println("Enter exponent");
            int exponent = sc.nextInt();
            terms[index] = new Term(coefficient,exponent);
        }
        Poly poly1 = new Poly(terms);
        System.out.println("Enter value of variable at which polynomial is to be evaluated");
        float value =sc.nextFloat();
        float evaluateResult = poly1.evaluate(value);
        System.out.println("Evaluation at x = "  + evaluateResult);
        System.out.println("Degree = " + poly1.getDegree());
        System.out.println("Enter the operation you want to perfrom : \n1. Add \n2. Multiply \n3.Exit");
        int choice = sc.nextInt();
        int countTerm2 = 0;
        switch(choice){
            case 1 :
                System.out.println("Enter Number of terms of 2nd polynomial");
                countTerm2 = sc.nextInt();
                Term[] terms2 = new Term[countTerm2];
                for(int index = 0 ; index < countTerm2 ; index ++){
                    System.out.println("Enter coefficient");
                    int coefficient = sc.nextInt();
                    System.out.println("Enter exponent");
                    int exponent = sc.nextInt();
                    terms2[index] = new Term(coefficient,exponent);
                }
                Poly poly2 = new Poly(terms2);
                Poly resultPolyAdd = Poly.addPoly(poly1 , poly2);
                Poly.printPoly(resultPolyAdd);
                break;
            case 2 :
                System.out.println("Enter Number of terms of 2nd polynomial");
                countTerm2 = sc.nextInt();
                Term[] terms2New = new Term[countTerm2];
                for(int index = 0 ; index < countTerm2 ; index ++){
                    System.out.println("Enter coefficient");
                    int coefficient = sc.nextInt();
                    System.out.println("Enter exponent");
                    int exponent = sc.nextInt();
                    terms2New[index] = new Term(coefficient,exponent);
                }
                Poly poly2New = new Poly(terms2New);
                Poly resultPolyMultiply = Poly.multiplyPoly(poly1 , poly2New);
                Poly.printPoly(resultPolyMultiply);
                break;
            case 3 :
                sc.close();
                System.exit(0);
            default :
                System.out.println("Invalid choice entered");
                
        }
        sc.close();
    }
}
