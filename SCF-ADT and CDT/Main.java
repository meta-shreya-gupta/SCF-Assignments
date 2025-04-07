import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * perfroms operation like isMember , size , isSubset , getCompliment , getUnion , getDifference , getIntersection on set . range of values 1-1000
 */
final class IntSet{
    private final int LOWER_LIMIT = 1;
    private final int UPPER_LIMIT = 20;
    private final boolean[] set;

    public IntSet(List<Integer> input){
        this.set = new boolean[UPPER_LIMIT + 1];                //initialising boolean array to check if user has entered that element or not
        for(int index = 0 ; index < input.size() ; index ++){
            if(input.get(index) >= LOWER_LIMIT && input.get(index) <= UPPER_LIMIT){         //If the user enters elements in range then initialize it to true
                this.set[input.get(index)] = true;
            }
            else{                                               //if elements entered are out of range then initialize it to false
                System.out.println("Element is out of range");
                return ;
            }
        }
    }
    public boolean[] getElements(){
        return set;
    }
/**
 * Prints the element of the set
 */
    public void printElement(){
        System.out.println("Set : ");
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){        //print the element with true value in the array
            if(this.set[index]){
                System.out.print(index + " ");
            }
        }
        System.out.println();
    }

    /**
     * checks weather the element is present in the set or not
     * @param element int value that we want to check if it exist or not
     * @return boolean value true if element is present else false
     */
    public boolean isMember(int element){                   // checks weather that element is entered by the user or not
        return set[element];
    }

    /**
     * counts the element that the user has entered as a set
     * @return count of the elements that the user has entered
     */
    public int size(){
        int sizeCount = 0;
        for(int index = 1 ; index < set.length ; index ++){             //counts the no of true values in teh boolean array to check the number of elements entered by the user
            if(set[index]){
                sizeCount ++;
            }
        }
        return sizeCount;
    }

    /**
     * Checks weather a set is the subset of other
     * @param s it is the set which is to be checked with another set
     * @return true if s is subset else false
     */
    public boolean isSubSet(IntSet s){
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){         //checks if one set is part of the another set
            if(this.set[index] != true && s.set[index] == true){
                return false;                                                   //if there is any element which is present in second and not in first then returns false
            }
        }
        return true;
    }

    /**
     * computes the compliment of a set
     * @return  object of IntSet which is the compliment of the set . gives the elements which is not in the set
     */
    public IntSet getCompliment(){
        List<Integer> compliment = new ArrayList<>();
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){         
            if(!(this.set[index])){                                     //it gives the elements which are not present in that set
                compliment.add(index);
            }
        }
        IntSet complimentSet = new IntSet(compliment);              //initializes the compliment set
        return complimentSet;
    }

    /**
     * computes the union of set s with the another set . gives elements which is present in either of the set
     * @param s set of elements whose union is to be computed with another set
     * @return object of Intset which consists elements of either of the set
     */
    public IntSet getUnion(IntSet s){
        List<Integer> union = new ArrayList<>();                    //declares ArrayList to store unique elements of both the set
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){
            if(this.set[index] || s.set[index]){                    //if element is present in either of the set
                union.add(index);
            }
        }
        IntSet unionSet = new IntSet(union);                        //assign union ArraySet as an object of IntSet class
        return unionSet;
    }

    /**
     * computes the elements which is presnet in only one of the set
     * @param s set of elements which are to be removed from another set if they are present
     * @return object of IntSet class which consists of elements present in only one of the set
     */
    public IntSet getDifference(IntSet s){
        List<Integer> difference = new ArrayList<>();               //declares ArrayList to store the difference of two set
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){
            if(this.set[index] && !s.set[index]){                   //adds the element if it is present in first and not in second
                difference.add(index);
            }
        }
        IntSet differenceSet = new IntSet(difference);              //assigns difference ArrayList to object of IntSet
        return differenceSet;
    }

    /**
     * computes the elements which are present in both of the set
     * @param s set of elements whose intersection is to be calculated with the another set
     * @return object of IntSet class which consists of set of elements which are present in both of the set
     */
    public IntSet getIntersection(IntSet s){
        List<Integer> intersection = new ArrayList<>();                     //declares ArrayList to store elements present in both of the set
        for(int index = LOWER_LIMIT ; index <= UPPER_LIMIT ; index ++){
            if(this.set[index] && s.set[index]){                            //if elements are present in both of the set then it adds the element to the ArrayList
                intersection.add(index);
            }
        }
        IntSet intersectionSet = new IntSet(intersection);                  //assigns ArrayList as object of IntSet
        return intersectionSet;
    }
}


public class Main{
    public static void main(String[] args){
        
        IntSet inputSet1 = new IntSet(new ArrayList<Integer>(Arrays.asList(1,4,15,7)));     //assigns elements of initial set

        System.out.println("Is 16 member of set : " + inputSet1.isMember(16));
        System.out.println("Is 15 member of set : " + inputSet1.isMember(15));
        System.out.println("Size of set : " + inputSet1.size());

        IntSet subset1 = new IntSet(new ArrayList<Integer>(Arrays.asList(4,15)));           //assigns another two set to check functionality
        IntSet subset2 = new IntSet(new ArrayList<Integer>(Arrays.asList(1,2,3)));

        System.out.println("Is {4,15} subset of the set : " + inputSet1.isSubSet(subset1));      //computes isSubset functionality for both the set
        System.out.println("Is {1,2,3} subset of the set : " + inputSet1.isSubSet(subset2));

        System.out.println("Compliment : ");                                                    //computes compliment of the set1
        IntSet compliment = inputSet1.getCompliment();
        compliment.printElement();

        System.out.println("Compliment : ");                                                    //computes compliment of the set2
        IntSet compliment2 = inputSet1.getCompliment();
        compliment2.printElement();

        System.out.println("Union : " );                                                        //computes union of the set1
        IntSet union1 = inputSet1.getUnion(subset1);
        union1.printElement();

        System.out.println("Union : " );                                                        //computes union of the set2
        IntSet union2 = inputSet1.getUnion(subset2);
        union2.printElement();
        
        System.out.println("Difference : ");                                                    //computes differnce with set1
        IntSet difference1 = inputSet1.getDifference(subset1);
        difference1.printElement();
        
        System.out.println("Difference : ");                                                    //computes difference with set2
        IntSet difference2 = inputSet1.getDifference(subset2);
        difference2.printElement();

        System.out.println("Intersection : ");                                                  //computes intersection with set1
        IntSet intersection1 = inputSet1.getIntersection(subset1);
        intersection1.printElement();
        
        System.out.println("Intersection : ");                                                  //computes intersection with set2
        IntSet intersection2 = inputSet1.getIntersection(subset2);
        intersection2.printElement();
    }
}