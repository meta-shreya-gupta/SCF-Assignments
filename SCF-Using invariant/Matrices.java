import java.util.Scanner;
/**
 * Utility class which provides various functions on matrices like checkSparse , traspose , check symmetrical , add and multiply matrices
 */
final class MatricesOperation{
    private final int row ;                     //private data members to make class immutable
    private final int col ;
    private final int[][] array ;

    public MatricesOperation(int row , int col , int[][] array){       //constructor to assign values
        this.row = row;
        this.col = col;
        this.array = array;
    }
    /**
     * gives the matrix as an array
     * @return matrix as an array
     */
    public int[][] getArray(){
        return array;                           //returns the array of the object of the class
    }

    /**
     * prints the matrix on the screen
     */
    public void printMatrix(){
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){           //prints the matrix element wise
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                System.out.print(array[rowIndex][colIndex] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * swaps columns to rows and vice-versa
     * @return transposed matrix as an object of MatricesOperation class
     */
    public MatricesOperation transposeOfMatrix(){
        int[][] transposedArray = new int[col][row];                //array to store output
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                transposedArray[colIndex][rowIndex] = array[rowIndex][colIndex];    //exchanges rows to columns and vice-versa
            }
        }
        return new MatricesOperation(col, row, transposedArray);        //returns transposed array as an object of MatricesOperation class
    }

    /**
     * checks weather the matrix is symmetrical or not
     * @return true if matrix is symmetrical else false
     */
    public boolean isSymmetrical(){
        if(row != col){                         //if rows and columns are not equal then transposed array can't be equal to original
            return false;
        }
        MatricesOperation transposedMatrix = transposeOfMatrix();
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                if(array[rowIndex][colIndex] != transposedMatrix.array[rowIndex][colIndex]){        //if any element do not match then matrix is not symmetrical
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * computes the addition of two matrices . condition - row and column of first should be equal to second
     * @param array2 matrix which is to be added
     * @return added matrix as an object of MatricesOperation class
     */
    public MatricesOperation addMatrices(MatricesOperation array2){
        int[][] resultMatrix = new int[row][col];                       //array to store addition result
        
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                resultMatrix[rowIndex][colIndex] = array[rowIndex][colIndex] + array2.array[rowIndex][colIndex];        //computs the addition result element-wise
            }
        }
        return new MatricesOperation(row, col, resultMatrix);                   //returns the output as an object of MatricesOperation class
    }

    /**
     * computes the multiplication of two matrices . condition - column of first should be equal to row of second
     * @param array2 matrix which is to be multiplied
     * @return multiplied matrix as an object of MatricesOperation class
     */
    public MatricesOperation multiplyMatrices(MatricesOperation array2){
        int row2 = array2.array.length;
        int col2 = array2.array[0].length;

        int[][] resultMatrix = new int[row][col2];                      //matrix to store the multiplicated result

        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col2 ; colIndex ++){
                for(int nextRowIndex = 0 ; nextRowIndex < row2 ; nextRowIndex++){
                    resultMatrix[rowIndex][colIndex] += array[rowIndex][nextRowIndex] * array2.array[nextRowIndex][colIndex];       //computes the multiplication
                }
            }
        }
        return new MatricesOperation(row, col2, resultMatrix);              //returns the multiplicated result as an object of MatricesOperation class
    }
}
class Matrices{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");             //enter rows of original array
        int row = sc.nextInt();
        System.out.println("Enter number of columns");          //enter columns of original array
        int col = sc.nextInt();
        int[][] array = new int[row][col];
        System.out.println("Enter number of non-zero elements");    //enter number of non-zero elements
        int count = sc.nextInt();
        try{
            if(count>(row*col)/2){                                  //throws custom exception if matrix is not sparse
                sc.close();
                throw new SparseException("Matrix is not sparse");
            }
        }
        catch(SparseException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        MatricesOperation firstArray = new MatricesOperation(row , col , array);
        System.out.println("Enter row and column and non-zero element");
        while(count>0){                                             //takes input the location of the non-zero element and the element
            System.out.println("Enter row");
            int rowNumber = sc.nextInt() - 1;
            System.out.println("Enter column");
            int colNumber = sc.nextInt() - 1;
            System.out.println("Enter element");
            int element = sc.nextInt();
            array[rowNumber][colNumber] = element;
            count --;
        }
        System.out.println("Enter\n1. Find transpose\n2. Add matrices\n3. Multiply matrices\n4. Exit");     //takes choice from the user
        int choice = sc.nextInt();
        switch(choice){
            case 1 :                                                    //if user wants transpose of matrix
                MatricesOperation transposedArray = firstArray.transposeOfMatrix();
                transposedArray.printMatrix();
                break;
            case 2 : 
                System.out.println("Enter number of rows");         //takes rows of second matrix
                int row2 = sc.nextInt();
                System.out.println("Enter number of columns");      //takes columns of second matrix
                int col2 = sc.nextInt();
                try{
                    if(row != row2 || col != col2){                 //throws exception if addition is not possible
                        throw new SparseException("Addition is not possible due to different sizes");
                    }
                }
                catch(SparseException e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
                int[][] array2 = new int[row2][col2];
                System.out.println("Enter elements row wise");      //enter elements row-wise
                for(int rowIndex = 0 ; rowIndex < row2 ; rowIndex ++){
                    for(int colIndex = 0 ; colIndex < col2 ; colIndex ++){
                        array2[rowIndex][colIndex] = sc.nextInt();
                    }
                }
                MatricesOperation secondArray = new MatricesOperation(row2, col2, array2);
                MatricesOperation addResult = firstArray.addMatrices(secondArray);  //computes the result
                addResult.printMatrix();                            //print the result
                break;
            case 3 :
                System.out.println("Enter number of rows");         //takes rows of second array
                int nextRow = sc.nextInt();
                System.out.println("Enter number of columns");      //takes columns of second array
                int nextCol = sc.nextInt();
                try{
                    if(col != nextRow){                                                        //throws exception if multiplication is not possible
                        throw new SparseException("Multiplication is not possible");
                    }
                }
                catch(SparseException e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
                int[][] nextArray = new int[nextRow][nextCol];
                System.out.println("Enter elements row wise");      //enter elements row-wise
                for(int rowIndex = 0 ; rowIndex < nextRow ; rowIndex ++){
                    for(int colIndex = 0 ; colIndex < nextCol ; colIndex ++){
                        nextArray[rowIndex][colIndex] = sc.nextInt();
                    }
                }
                MatricesOperation secondArr = new MatricesOperation(nextRow, nextCol, nextArray);
                MatricesOperation multiplyResult = firstArray.multiplyMatrices(secondArr);      //computes the multiplication
                multiplyResult.printMatrix();                           //prints the multiplicated array
                break;
            case 4 :
            sc.close();
            System.exit(0);
        }
    }
}

class SparseException extends Exception {           //custom exception to print the exception message
    public SparseException(String m) {
        super(m);
    }
}