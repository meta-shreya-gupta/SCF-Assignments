import java.util.Scanner;
/**
 * Utility class to compute hcf or lcm according to user choice.
 */
class LcmAndHcf{
    /**
     * Utility function to calculate hcf of two numbers entered . Number cannot be negative
     * @param number1 first number to calculate hcf . cannot be negative
     * @param number2 second number to calculate hcf . cannot be negative
     * @return computed value hcf of number1 and number2 as int value
    */
    public int hcf(int number1 , int number2){
        assert number1>=0 : "Cannot have negative integers..";  //error if number entered is negative
        assert number2>=0 : "Cannot have negative integers..";  

        if(number2 == 0){                                       //checks if second number is 0
            return number1;                                     //if so, then return first number
        }
        return hcf(number2 , number1 % number2);                //recursive call to compute hcf
    }

    /**
     * Utility function to calculate lcm of two numbers entered . Number cannot be negative . use lcm(a,b)=a*b/hcf(a,b)
     * @param number1 first number to calculate lcm . cannot be non-positive
     * @param number2 second number to calculate lcm . cannot be non-positive
     * @return computed value lcm of number1 and number2 as int value
    */
    public int lcm(int number1 , int number2){
        assert number1>0 : "LCM exist only for positive integers. Enter only positive values";   //error if number entered is non-positive
        assert number2>0 : "LCM exist only for positive integers. Enter only positive values";

        return (number1 * number2) / hcf(number1 , number2);     //compute lcm using lcm=num1*num2/hcf
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LcmAndHcf calculator = new LcmAndHcf();
        System.out.println("Enter the operation you want to perform \n1. Find HCF/GCD \n2. find LCM");
        int choice = sc.nextInt();                              //user chooses operation he wants to perform
        System.out.println("Enter number 1 : ");
        int number1 = sc.nextInt();                             //user enters number1
        System.out.println("Enter number 2 : ");
        int number2 = sc.nextInt();                             //user enters number2
        switch(choice){
            case 1 :
                System.out.println("HCF/GCD of " + number1 + " and " + number2 +" = " + calculator.hcf(number1,number2));   //if wants hcf then calculate hcf
                break;
            case 2 :
                System.out.println("LCM of " + number1 + " and " + number2 + " = " + calculator.lcm(number1,number2));      //if wants lcm then calculate lcm
                break;
            default :
                System.out.println("Invalid choice entered....");
        }
        sc.close();                                                         //closes the scanner class
        System.exit(0);                                             //terminate the program
    }
}