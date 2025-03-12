import java.util.Scanner;
/**
 * utility class to find index of an element using linear search or binary search according to user choice
 */
class Search {
    /**
     * find the index at which an element is present using linear search
     * @param inputArray array of elements in which an element is to be found . cannot be empty array
     * @param value element which we want to find
     * @param index starting index of the array at each recursive call
     * @return index at which element is found else -1
     */
    public int linearSearch(int[] inputArray , int value , int index){
        assert inputArray.length > 0 : "Element cannot be searched in an empty array";      //throws assertion error if array is empty
        if(index == inputArray.length){                         //if index gets out of bound
            return -1;
        }   
        if(value == inputArray[index]){                         //checks if value is present at that index
            return index;
        }
        return linearSearch(inputArray, value, index+1);        //recursive call to search element at next index
    }

    /**
     * find the index at which an element is present using binary search
     * @param inputArray array of elements in which an element is to be found . should be sorted . cannot be empty array
     * @param value element which we want to find
     * @param index starting index of the array at each recursive call
     * @return index at which element is found else -1
     */
    public int binarySearch(int[] inputArray , int value , int low , int high ){
        assert inputArray.length > 0 : "Element cannot be searched in an empty array";      //throws assertion error if array is empty
        while(low <= high){                                                                 //check till low index do not crosses high index
            int mid = (low + high) / 2;                                                     //calculate middle index between low and high
            if(inputArray[mid] == value){                                                   //if value is found return the index
                return mid;
            }
            else if(inputArray[mid] > value){                                               //if value is present at left then consider left sub-array
                return binarySearch(inputArray, value , low , mid - 1);
            }
            else {                                                                          //if value is present at right then consider right sub-array
                return binarySearch(inputArray, value, mid + 1, high);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Search search = new Search();
        System.out.println("Enter the size of the array ");
        int len=sc.nextInt();                                                           //enter size of the array
        int[] inputArray = new int[len];
        System.out.println("Enter elements of array ");                               //enter elements of the array in sorted order
        for(int index = 0 ; index < len ; index ++){
            inputArray[index] = sc.nextInt();
        }
        System.out.println("Enter element to find ");
        int value = sc.nextInt();                                                       //enter element you want to find
        System.out.println("Enter process to find an element \n1. Linear Search \n2. Binary Search");
        int choice = sc.nextInt();                                                      //choose the procedure you want to perform
        switch(choice){
            case 1 :
                System.out.println("Index at which element is found is " + search.linearSearch(inputArray, value,0));   //performs linear search
                break;
            case 2 :
                System.out.println("Index at which element is found is " + search.binarySearch(inputArray, value,0, (inputArray.length - 1)));  //performs binary search
                break;
            default :
                System.out.println("Invalid choice entered");
        }
        sc.close();                                                                 //closes the scanner class
        System.exit(0);                                                     //terminate the program
    }
}
