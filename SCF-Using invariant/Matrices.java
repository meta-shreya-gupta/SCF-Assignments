import java.util.Scanner;
final class MatricesOperation{
    private final int row ;
    private final int col ;
    int[][] sparseArray;
    public MatricesOperation(int row , int col , int[][] matrix){
        this.row = row;                     //dimension of matrix supplied by user
        this.col = col;
        this.sparseArray = toSparseArray(matrix);
    }
    /**
     * it will convert the normal matrix to sparse matrix
     * @param array1 matrix with zero and non-zero elements
     * @return sparse matrix of the matrix supplied as argument
     */
    public int[][] toSparseArray(int[][] array1){
        int count = 0;
        for(int rowIndex = 0 ; rowIndex < array1.length ; rowIndex ++){             //counts non-zero elements
            for(int colIndex = 0 ; colIndex < array1[0].length ; colIndex ++){
                if(array1[rowIndex][colIndex] != 0){
                    count ++;
                }
            }
        }
        int sparseIndex = 0;
        int[][] sparseArray = new int[3][count];
        for(int rowIndex = 0 ; rowIndex < array1.length ; rowIndex ++){         //assigns row at 0-index, column at 1-index and value at 2-index
            for(int colIndex = 0 ; colIndex < array1[0].length ; colIndex ++){
                if(array1[rowIndex][colIndex] != 0){
                    sparseArray[0][sparseIndex] = rowIndex;
                    sparseArray[1][sparseIndex] = colIndex;
                    sparseArray[2][sparseIndex] = array1[rowIndex][colIndex];
                    sparseIndex ++;
                }
            }
        }
        return sparseArray;
    }
    /**
     * converts the sparse matrix to normal matrix
     * @param sparseArray sparse matrix to be converted to normal matrix
     * @return normal matrix with zeros and non-zeros elements
     */
    public int[][] toMatrix(int[][] sparseArray){
        int[][] array = new int[row][col];                              //assigns the non-zero element and rest is 0
        for(int index = 0 ; index < sparseArray[0].length ; index ++){
            array[sparseArray[0][index]][sparseArray[1][index]] = sparseArray[2][index];
        }
        return array;
    }
    
    /**
     * exchanges row element with the column element
     * @return transposed matrix
     */
    public MatricesOperation transposeOfMatrix(){
        int[][] transposedSparseArray = new int[3][sparseArray[0].length];
        for(int index = 0 ; index < sparseArray[0].length ; index ++){              //swaps row and column and value is kept same
            transposedSparseArray[0][index] = sparseArray[1][index];
            transposedSparseArray[1][index] = sparseArray[0][index];
            transposedSparseArray[2][index] = sparseArray[2][index];
        }
        return new MatricesOperation(col , row , toMatrix(transposedSparseArray));
    }
    public boolean isSymmetrical(){
        if(row != col){
            return false;
        }
        int[][] originalMatrix = this.toMatrix(this.sparseArray);
        int[][] transposedMatrix = this.transposeOfMatrix().toMatrix(this.transposeOfMatrix().sparseArray);
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                if(originalMatrix[rowIndex][colIndex] != transposedMatrix[rowIndex][colIndex]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * add two matrices which have matched dimensions
     * @param other matrix to be added to the original
     * @return matrix after addind both matrices
     */
    public MatricesOperation addMatrices(MatricesOperation other){
        if(this.row != other.row || this.col != other.col){                 //throws exception if dimension do not match
            throw new IllegalArgumentException("Dimensions should be equal for addition");
        }
        int[][] resultMatrix = new int[row][col];
        int[][] thisMatrix = this.toMatrix(this.sparseArray);
        int[][] otherMatrix = this.toMatrix(other.sparseArray);
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){           //adds matric element by element
                resultMatrix[rowIndex][colIndex] = thisMatrix[rowIndex][colIndex] + otherMatrix[rowIndex][colIndex];        //computs the addition result element-wise
            }
        }
        return new MatricesOperation(row, col, resultMatrix);
    }
    /**
     * multiplies two matrices . column of first should have same dimension as row of second matrix
     * @param other matrix to be multiplied by the original matrix
     * @return multiplied matrix
     */
    public MatricesOperation multiplyMatrices(MatricesOperation other){
        if(this.col != other.row){
            throw new IllegalArgumentException("Column of first should match row of second for multiplication");
        }
        int[][] resultMatrix = new int[this.row][other.col];
        int[][] thisMatrix = this.toMatrix(this.sparseArray);
        int[][] otherMatrix = this.toMatrix(other.sparseArray);
        for(int rowIndex = 0 ; rowIndex < this.row ; rowIndex ++){          //multiplies the matrices
            for(int colIndex = 0 ; colIndex < other.col ; colIndex ++){
                for(int nextRowIndex = 0 ; nextRowIndex < this.col ; nextRowIndex++){
                    resultMatrix[rowIndex][colIndex] += thisMatrix[rowIndex][nextRowIndex] * otherMatrix[nextRowIndex][colIndex];       //computes the multiplication
                }
            }
        }
        return new MatricesOperation(this.row, other.col, resultMatrix);
    }
}
class Matices{
    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int element : row){
                System.out.print(element + " ");                //prints the matrix
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row = sc.nextInt();
        System.out.println("Enter number of columns");
        int col = sc.nextInt();
        int[][] array1 = new int[row][col];
        System.out.println("Enter element row-wise");
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col ; colIndex ++){
                array1[rowIndex][colIndex] = sc.nextInt();
            }
        }
        MatricesOperation matrix1 = new MatricesOperation(row, col, array1);
        System.out.println("Enter number of rows of second matrix");
        int row1 = sc.nextInt();
        System.out.println("Enter number of columns of second Matrix");
        int col1 = sc.nextInt();
        int[][] array2 = new int[row1][col1];
        System.out.println("Enter element row-wise");
        for(int rowIndex = 0 ; rowIndex < row1 ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < col1 ; colIndex ++){
                array2[rowIndex][colIndex] = sc.nextInt();
            }
        }
        MatricesOperation matrix2 = new MatricesOperation(row1, col1, array2);
        MatricesOperation transpose1 = matrix1.transposeOfMatrix();
        printMatrix(transpose1.toMatrix(transpose1.sparseArray));
        MatricesOperation transpose2 = matrix2.transposeOfMatrix();
        printMatrix(transpose2.toMatrix(transpose2.sparseArray));
        System.out.println("Is first matrix symmetrical " + matrix1.isSymmetrical());
        System.out.println("Is second matrix symmetrical " + matrix2.isSymmetrical());
        MatricesOperation sumMatrix = matrix1.addMatrices(matrix2);
        System.out.println("Result of addition");
        printMatrix(sumMatrix.toMatrix(sumMatrix.sparseArray));
        MatricesOperation multiplyMatrix = matrix1.multiplyMatrices(matrix2);
        System.out.println("Result of multiplication");
        printMatrix(multiplyMatrix.toMatrix(multiplyMatrix.sparseArray));
        sc.close();
    }
}