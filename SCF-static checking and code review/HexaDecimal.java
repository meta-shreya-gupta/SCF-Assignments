import java.util.Scanner;
import java.util.HashMap;
import java.lang.Math;

class HexCalc{

    public static final int base = 16;    // declaring base as 16 to prevent hard-coding
    
    public static int hexadecimalToDecimal(String number){      //it converts a hex number as string to decimal as integer
        int result = 0;
        for( int index = 0 ; index < number.length() ; index++ ) {
            char ch = number.charAt( index ) ;
            int digit = 0;
            if(ch >= '0' && ch <= '9'){        //if from 0 to 9 then to have int sub ASCII of 0 i.e 48
                digit = ch-48;
            }
            else if(ch >= 'A' && ch <= 'F'){    //if from A to F then to have A as 10 sub ASCII of A i.e 65 and then add Hex of A i.e 10
                digit = ch-55;
            }
            result += digit * Math.pow(base , number.length() - 1 - index); 
        }
        return result;
    }

    public static String decimalToHexadecimal(int number){  //dec to hex we take remainder in reverse order
        String result = "";
        String resultNumber = "";
        while(number != 0){     
            int remainder = number % base;
            number = number / base;
            if( remainder <= 9 ){           //if <9 we want the same number
                result += (char) (remainder + '0');
            }
            else if(remainder > 9 && remainder <= 15){  //if 10 to 15 then we want A to F e.g we add 55 to 10 to get A
                result += (char) (55 + remainder);
            }
        }
        for(int index = result.length() - 1 ; index >= 0 ; index--){        //reverse the remainders to get the hex number
            resultNumber = resultNumber + result.charAt(index);
        }
        return resultNumber;
    }

    public static String add(String number1 , String number2){      //convert both hex to dec->add->convert to hex
        int firstNumber = hexadecimalToDecimal( number1 );
        int secondNumber = hexadecimalToDecimal( number2 );
        int result = firstNumber + secondNumber;
        return decimalToHexadecimal(result);
    }

    public static String subtract( String number1 , String number2 ){   //convert hex to dec->sub->convert to hex
        int firstNumber = hexadecimalToDecimal( number1 );
        int secondNumber = hexadecimalToDecimal( number2 );
        int result = firstNumber - secondNumber;
        return decimalToHexadecimal(result);
    }

    public static String multiply(String number1,String number2){   //convert hex to dec->mul->convert to hex
        int firstNumber = hexadecimalToDecimal( number1 );
        int secondNumber = hexadecimalToDecimal( number2 );
        int result = firstNumber * secondNumber;
        return decimalToHexadecimal(result);
    }

    public static String divide(String number1 , String number2){   //convert hex to dec->divide->convert to hex
        int firstNumber = hexadecimalToDecimal( number1 );
        int secondNumber = hexadecimalToDecimal( number2 );
        int result = firstNumber / secondNumber ;
        return decimalToHexadecimal( result );
    }

    public static boolean isEqual(String number1 , String number2){   //if length are not equal then false else check by iteration
        int length1 = number1.length();
        int length2 = number2.length();
        if(length1 != length2){
            return false;
        }
        else{
            for(int index = 0 ; index < length1 ; index++ ){
                if( number1.charAt(index) != number2.charAt(index)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isGreator(String number1 , String number2){   //checks if first is greator or not
        int length1 = number1.length();
        int length2 = number2.length();
        if( length1 > length2){
            return true;
        }
        else if(length1 < length2){
            return false;
        }
        else{
            for(int index = 0 ; index < length1 ; index++){
                if(number1.charAt(index) < number2.charAt(index)){
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isLesser(String number1,String number2){  //checks if first is lesser or not
        int length1 = number1.length();
        int length2 = number2.length();
        if(length1 < length2){
            return true;
        }
        else if(length1 > length2){
            return false;
        }
        else{
            for(int index = 0;index < length1 ; index++){
                if(number1.charAt(index) > number2.charAt(index)){
                    return false;
                }
            }
        }
        return true;
    }
}

class HexaDecimal{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter \n1. Perform Operation \n2. Compare \n3. Convert hexadecimal to decimal \n4. Convert decimal to hexadecimal \n5. exit");

            int choice=sc.nextInt();            //user choose what to do

            String number1="";
            String number2="";
            String result="";

            switch(choice){

                case 1 :
                    System.out.println("Enter \n1. add \n2. Subtract\n3. Multiply \n4. Divide");
                    int operationChoice=sc.nextInt();       //user choose which operation to perform 
                    System.out.print("Enter 2 Hexadecimal numbers");
                    number1=sc.next();
                    number2=sc.next();
                    switch(operationChoice){
                        case 1 : 
                            result += HexCalc.add(number1 , number2);
                            System.out.println("Add Result = " + HexCalc.add(number1,number2));
                            break;
                        case 2 :
                            System.out.println("Subtract result = " + HexCalc.subtract(number1,number2));
                            break;
                        case 3 :
                            System.out.println("Multiply result = " + HexCalc.multiply(number1,number2));
                            break;
                        case 4 : 
                            System.out.println("Divide result = " + HexCalc.divide(number1,number2));
                            break;
                        default : 
                            System.out.println("Not a valid choice for performing operation ");
                    }
                    break;

                case 2 :
                    System.out.println("Enter 1. To check equality \n2. to check first is greator\n3. To check first is lesser ");
                    operationChoice=sc.nextInt();
                    System.out.print("Enter 2 Hexadecimal numbers");
                    number1=sc.next();
                    number2=sc.next();
                    switch(operationChoice){
                        case 1 : 
                            System.out.println("Both are equal - " + HexCalc.isEqual(number1,number2));
                            break;
                        case 2 : 
                            System.out.println("1st is greator - " + HexCalc.isGreator(number1,number2));
                            break;
                        case 3 : 
                            System.out.println("1st is lesser - " + HexCalc.isLesser(number1,number2));
                            break;
                        default : System.out.println("Not a valid choice for comparison");
                    }
                    break;

                case 3 :
                    System.out.print("Enter a hexadecimal number : ");
                    String number=sc.next();
                    System.out.println("Decimal value is = " + HexCalc.hexadecimalToDecimal(number));
                    break;

                case 4 : 
                    System.out.println("Enter a decimal value");
                    int numberDecimal=sc.nextInt();
                    System.out.println("Hexadecimal value = " + HexCalc.decimalToHexadecimal(numberDecimal));
                    break;

                case 5 :
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default : System.out.println("There is no such task to be performed");
            }
        }
    }
}