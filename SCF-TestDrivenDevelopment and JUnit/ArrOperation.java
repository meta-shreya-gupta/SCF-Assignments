import java.util.Scanner;
import java.util.ArrayList;

/**
 * A utility class that solves MaxMirror, countClumps, fixXY, splitArray problems
 */
class ArrOperation{

    /**
    * group of contiguous elements such that the same group appears in reverse order
    * @param inputArray takes elements as input . inputArray.length > 0
    * @return size of largest mirror section
    */
    public int maxMirror(int[] inputArray){
        assert inputArray.length > 0 : "Array is empty" ;       //throws assertion error if array is empty
        int mirror = 0;
        int maximumMirror = 0;
        for(int index = 0 ; index < inputArray.length ; index ++){   //traverse array in forward
            for(int oppositeIndex = inputArray.length - 1 ; oppositeIndex > index ; oppositeIndex --){      //traverse array in backward
                int index1 = index;
                int oppositeIndex1 = oppositeIndex;
                while(inputArray[index1] == inputArray[oppositeIndex1]){        //traverse from both side if elements are found to be equal
                    mirror ++;
                    index1 ++;
                    oppositeIndex1 --;
                    if(index1 > inputArray.length || oppositeIndex1 < 0){      //while traversing if it crosses the bound
                        break;
                    }
                    
                }
                if(maximumMirror < mirror){                                     //finds maximum if there are multiple mirror present
                    maximumMirror = mirror;
                }
                mirror = 0;
            }
        }
        return maximumMirror;
    }

    /**
     * number of clumps(series of 2 or more adjacent elements of same value) in the input array
     * @param inputArray takes elements as input . arr.length > 0
     * @return count of number of clumps present
     */
    public int countClumps(int[] inputArray){
        assert inputArray.length > 0 : "Array is empty";            //throws assertion error if array is empty
        int count = 0;
        boolean flag = true;                                        //boolean to check is it a clump
        for(int index = 0 ; index < inputArray.length - 1 ; index ++){  //traverse the array from first to last second index
            if( inputArray[index] == inputArray[index + 1] ){           //checks next element to be equal
                if(flag){
                    count ++;
                    flag=false;
                }
            }
            else{
                flag=true;
            }
        }
        return count;
    }

    
    /**
     * returns an array with fixed X and Y
     * @param inputArray array elements as input . arr.length > 0
     * @param X X at fix values . every X if immediately followed by Y . could not be the last element . adjacent elements should not be same
     * @param Y element to be present just after X
     * @return Array with fixed values of X and Y
     */
    public int[] fixXY(int[] inputArray , int X , int Y){
        assert inputArray.length > 0 : "Array is empty";        //throws assertion error if array is empty
        assert inputArray[inputArray.length - 1] != X : "X is present at last index. Cannot fix it.";   //throws assertion error if X is present at last index
        ArrayList<Integer> indexOfX = new ArrayList<>();        //list to store next index of presence of X
        ArrayList<Integer> indexOfY = new ArrayList<>();        //list to store index of presence of Y
        for(int index = 0 ; index < inputArray.length ; index ++){  //adding elements to respective list
            if(inputArray[index] == Y){
                indexOfY.add(index);
            }
            if(inputArray[index] == X){
                indexOfX.add(index + 1);
                assert inputArray[index+1]!=X : "Adjacent X present. Cannot fix it ";
            }
        }
        assert indexOfX.size() == indexOfY.size() : "Unequal number of X and Y";    //throws assert error if unequal X and Y present
        for(int indexOfList = 0 ; indexOfList < indexOfX.size() ; indexOfList ++){   //traverses list to swap elements to fix array
            int swap = inputArray[indexOfX.get(indexOfList)];                       //swaps the elements
            inputArray[indexOfX.get(indexOfList)] = inputArray[indexOfY.get(indexOfList)];
            inputArray[indexOfY.get(indexOfList)] = swap;
        }
        return inputArray;
    }

    /**
     * finds the index such that before and after sum are equal
     * @param inputArray array elements as input . arr.length > 0
     * @return index of start of second partition
     */
    public int splitArray(int[] inputArray){
        assert inputArray.length > 0 : "Array is empty";        //throws assertion error if array is empty
        int totalSum = 0;
        int sum = 0;
        for(int index = 0 ; index < inputArray.length ; index++){   //traversing array to find total sum
            totalSum += inputArray[index];
        }
        for(int index = 0 ; index < inputArray.length ; index++){    //traversing to find sum element by element
            sum += inputArray[index];
            if(sum == (totalSum - sum)){                        //checking sum if it's half of total sum
                return index + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrOperation arrOp = new ArrOperation();                //creating object of the class
        System.out.println("Enter the size of the array");    //enter the size of array by user
        int lenOfArray = sc.nextInt();
        int[] inputArray = new int[lenOfArray];
        System.out.println("Enter elements of the array : "); //entering elements of the array
        for(int index = 0 ; index < lenOfArray ; index ++){
            inputArray[index] = sc.nextInt();
        }
        System.out.println("Choose what you want to perform \n1. Return Maximum mirror \n2. Return number of clumps \n3. Fix X, Y \n4. Split Array");
        int choice = sc.nextInt();                              //asking user the operation he wants to perform
        switch (choice){
            case 1 :                                            //if user wants to perform maxMirror operation
                System.out.println("Maximum Mirror = " + arrOp.maxMirror(inputArray));
                break;
            case 2 :                                            //if user wants to perform countClumps operation
                System.out.println("Count clumps = " + arrOp.countClumps(inputArray));
                break;
            case 3 :                                            //if user wants to perform fixXY operation
                System.out.println("Enter element to be fixed (X) = ");
                int X = sc.nextInt();                           //ask X from the user
                System.out.println("Enter element to get fixed (Y) = ");
                int Y = sc.nextInt();                           //asking Y from the user
                int[] fixedArray = arrOp.fixXY(inputArray, X, Y);
                System.out.println("Fixed Array = ");
                for(int index = 0 ; index < fixedArray.length ; index ++){
                    System.out.print(fixedArray[index] + "\t");
                }
                break;
            case 4 :                                            //if user wants to perform split array operation
                System.out.println("Index of splitted array = " + arrOp.splitArray(inputArray));
                break;
            default : 
                System.out.println("Not a Valid choice");     //user choice is invalid if he choose out of 1-4
        }
        sc.close();                                             //closes the scanner class
        System.exit(0);                                  // terminate the program
    }
}