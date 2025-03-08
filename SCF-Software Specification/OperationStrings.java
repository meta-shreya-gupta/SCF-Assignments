import java.util.Scanner;
import java.util.HashMap;
import java.lang.Math;

/**
 * A utility class for checking equality of strings, reversing a string, changing case sensitive of string, finding last longest character
 */
class OperationStrings{

    /**
    * Check the equality of two strings . it is case sensitive
    * @param input1 first string
    * @param input2 second string to be compared with first string
    * @return 0 if strings are not equal, 1 if strings are equal
    */
    public int checkEquals( String input1 , String input2 ){            //checks the equality of two strings
        if( input1 == null || input2 == null){                          //checks if either of the string has null values
            return 0;
        }

        int length1 = input1.length();
        int length2 = input2.length();

        if(length1 != length2){                                 //checks if lengths are not equal then strings are not equal
            return 0;
        }

        for( int index = 0 ; index < length1 ; index++ ){        //traverse the string and checks character by character
            char char1 = input1.charAt(index);
            char char2 = input2.charAt(index);
            if(char1 != char2){                             //if any of the character mismatches then strings are not equal
                return 0;
            }
        }
        return 1;
    }

    /**
    * Return the reverse of the given string
    * @param input1 string which we want to get reversed . should not contain spaces
    * @return string after reversing the parameter string
    */
    public String reverseString( String input1 ){           //reverses the strings entered by user

        String reverse = "";

        for( int index = input1.length()-1 ; index >= 0 ; index-- ){        //traverse the strings from last
            reverse += input1.charAt(index);
        }
        return reverse;
    }

    /**
    * Converts lower case letter to upper case letter and vice versa . it is case sensitive
    * @param input1 string which we want to reverse the case sensitivity
    * @return string after reversing the case sensitivity
    */
    public String lowerOrUpper( String input1 ){                //changes the lower case character to upper case and vice versa

        String result = "" ;
        int difference = 'a' - 'A';                             //calculates ASCII difference between respective letters in upper case and lower case

        for(int index = 0 ; index < input1.length() ; index++){

            char ch = input1.charAt(index);

            if(ch >= 'a' && ch <= 'z'){
                ch = (char) (ch - difference);                  //decreases ASCII of lower case letter to respective upper case letter
            }

            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char) (ch + difference);                  //increases ASCII of upper letter to respective lower case letter
            }
            result += ch;
        }
        return result;
    }

    /**
    * returns the largest word from the group of words provided as a single input
    * @param input1 string of multiple words . searated by space
    * @return last string of maximum length
    */
    public String largestWord(String input1){               //extracts last longest word from a string of multiple words
        if(input1 == null || input1.isEmpty()){             //checks if that string is null
            return "";
        }

        int start = 0;                                      //declaration and initialization of all the variables
        int end = 0;
        int maximumLength = 0;
        int currentStart = 0;
        int currentLength = 0;

        for(int index = 0 ; index < input1.length() ; index++){
            char ch = input1.charAt(index);

            if(ch == ' '){                                  //checks if character is a whitespace
                if(currentLength >= maximumLength){         //checks if current word is longer
                    maximumLength = currentLength;
                    start = currentStart;
                    end = index;
                }
                currentStart = index + 1;                   //starts with new word
                currentLength = 0;
            }
            else {                                          //if there is a character then increses the length of current word
                currentLength++;
            }
        }
        if(currentLength >= maximumLength){                 //checks for the last word
            maximumLength = currentLength;
            start = currentStart;
            end = input1.length();
        }

        return input1.substring( start , end );         //returns the output
    }
    
    public static void main(String[] args){

        OperationStrings string = new OperationStrings();     //declares object of OperationStrings class
        Scanner sc = new Scanner(System.in);
        String input1 = "";
        String input2 = "";
        System.out.println( "Enter the number of operation you want to perform \n1. Check Equality of Strings \n2. Reverse a string \n3. Replace upper to lower and vice versa \n4. Get largest(last) word of a string" );
        int choice = sc.nextInt();                       //takes input from user about the action
        sc.nextLine();
        
        switch( choice ){
            case 1 :                                    //if user choose for checking equality then perform the operation
                System.out.print( "Enter first String " );
                input1 = sc.nextLine();
                System.out.print( "Enter second String " );
                input2 = sc.nextLine();
                System.out.println( "Checking Equality : " + string.checkEquals( input1,input2 ) );
                break;
            case 2 :                                    //if user choose for reverse string then perform operation 
                System.out.print( "Enter a String " );
                input1 = sc.nextLine();
                System.out.println( "Reverse of the string : " + string.reverseString( input1 ) );
                break;
            case 3 :                                    //if user choose for changing case of characters then perform operation
                System.out.print( "Enter a String with upper and lower case chracters " );
                input1 = sc.nextLine();
                System.out.println( "Changing lower to upper and vice versa : " + string.lowerOrUpper( input1 ) );
                break;
            case 4 :                                    //if user choose for largest(last0 wword then perform the operation)
                System.out.print( "Enter sentence with multiple strings " );
                input1 = sc.nextLine();
                System.out.println( "Largest Word of the string : " + string.largestWord( input1 ) );
                break;
            default :                                   //if none of the operation then Invalid choice by the user
                System.out.println( "Not a valid choice" );
        }
    }
}