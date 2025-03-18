
/**
 * Utility class which provides various functions on matrices like checkSparse , traspose , check symmetrical , add and multiply matrices
 */
final class MatricesOperation{
    private final int row ;                     //private data members to make class immutable
    private final int col ;
    private final int[][] sparseArray ;

    public MatricesOperation(int row , int col , int[][] sparseArray){       //constructor to assign values
        this.row = row;
        this.col = col;
        this.sparseArray = sparseArray;
    }

    public int[][] toSparseArray(int[][] matrix){
        int count = 0;
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                if(matrix[rowIndex][colIndex] != 0){
                    count ++;
                }
            }
        }
        int[][] sparseArray = new int[3][count];
        int index = 0;
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                if(matrix[rowIndex][colIndex] != 0){
                    sparseArray[0][index] = rowIndex;
                    sparseArray[1][index] = colIndex;
                    sparseArray[2][index] = matrix[rowIndex][colIndex];

                }
            }
        }
        return sparseArray;
    }

    public int[][] toMatrix(int[][] nonZeroArray){
        int[][] matrix = new int[row][col];
        for(int index = 0 ; index < nonZeroArray[0].length ; index ++){
            matrix[nonZeroArray[0][index]][nonZeroArray[1][index]] = nonZeroArray[2][index];
        }
        return matrix;
    }

    /**
     * gives the matrix as an array
     * @return matrix as an array
     */
    public int[][] getArray(){
        return sparseArray;                          //returns the array of the object of the class
    }

    /**
     * prints the matrix on the screen
     */
    public void printMatrix(){
        int[][] matrix = toMatrix(sparseArray);
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){           //prints the matrix element wise
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                System.out.print(matrix[rowIndex][colIndex] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * swaps columns to rows and vice-versa
     * @return transposed matrix as an object of MatricesOperation class
     */
    public MatricesOperation transposeOfMatrix(){
        int[][] input = toMatrix(sparseArray);
        int[][] transposedArray = new int[col][row];                //array to store output
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                transposedArray[colIndex][rowIndex] = input[rowIndex][colIndex];    //exchanges rows to columns and vice-versa
            }
        }
        return new MatricesOperation(col, row, transposedArray);        //returns transposed array as an object of MatricesOperation class
    }

    /**
     * checks weather the matrix is symmetrical or not
     * @return true if matrix is symmetrical else false
     */
    public boolean isSymmetrical(){
        int[][] input = toMatrix(sparseArray);
        if(row != col){                         //if rows and columns are not equal then transposed array can't be equal to original
            return false;
        }
        MatricesOperation transposedMatrix = transposeOfMatrix();
        int[][] transposedArray = toMatrix(transposedMatrix.sparseArray);
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                if(input[rowIndex][colIndex] != transposedArray[rowIndex][colIndex]){        //if any element do not match then matrix is not symmetrical
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
    public MatricesOperation addMatrices(MatricesOperation sparseArray2){
        int[][] matrix1 = toMatrix(sparseArray);
        int[][] matrix2 = toMatrix(sparseArray2.getArray());                       //array to store addition result
        int[][] resultMatrix = new int[matrix1.length][matrix1[0].length];
        
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                resultMatrix[rowIndex][colIndex] = matrix1[rowIndex][colIndex] + matrix2[rowIndex][colIndex];        //computs the addition result element-wise
            }
        }
        int[][] addResult = toSparseArray(resultMatrix);
        return new MatricesOperation(row, col, addResult);                   //returns the output as an object of MatricesOperation class
    }

    /**
     * computes the multiplication of two matrices . condition - column of first should be equal to row of second
     * @param array2 matrix which is to be multiplied
     * @return multiplied matrix as an object of MatricesOperation class
     */
    public MatricesOperation multiplyMatrices(MatricesOperation sparseArray2){
        int[][] matrix1 = toMatrix(sparseArray);
        int[][] matrix2 = toMatrix(sparseArray2.getArray());
        int row2 = matrix1[0].length;
        int col2 = matrix2[0].length;

        int[][] resultMatrix = new int[row][col2];                      //matrix to store the multiplicated result

        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col2 ; colIndex ++){
                for(int nextRowIndex = 0 ; nextRowIndex < row2 ; nextRowIndex++){
                    resultMatrix[rowIndex][colIndex] += matrix1[rowIndex][nextRowIndex] * matrix2[nextRowIndex][colIndex];       //computes the multiplication
                }
            }
        }
        int[][] multiplyResult = toSparseArray(resultMatrix);
        return new MatricesOperation(row, col2, multiplyResult);              //returns the multiplicated result as an object of MatricesOperation class
    }
}
class Matrices{
    public static void main(String[] args){
        int[][] matrix1 = {{0,1,2,2,3,4},{4,1,0,3,5,2},{9,8,4,2,5,2}};
        int[][] matrix2 = {{0,1,2,2,3,4},{4,1,0,3,5,2},{9,8,4,2,5,2}};
        MatricesOperation input1 = new MatricesOperation(5, 6, matrix1);
        MatricesOperation input2 = new MatricesOperation(5, 6, matrix2);
        MatricesOperation addResult = input1.addMatrices(input2);
        addResult.printMatrix();
        MatricesOperation multiplyResult = input1.multiplyMatrices(input2);
        multiplyResult.printMatrix();
    }
}