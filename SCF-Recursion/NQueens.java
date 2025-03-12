import java.util.Scanner;

/**
 * This class checks the positions of queens such that the queens can be placed at non-attacking positions
 */

 class NQueens {


    /**
     * it checks whether the current position is valid to be non-attacking or not
     * @param inputArray it is the board set to 0 . cannot have size < 4
     * @param row it is row in which we are about to place the queen
     * @param col it is column in which we are about to place the queen
     * @return boolean value as this position in non-attacking for a queen to be placed or not
     */

     public boolean validate(int[][] inputArray , int row , int col){
        int checkRow = row;                         //saving the row and col for further reference
        int checkCol = col;
        int dimension = inputArray.length;

        while(row >= 0 && col >= 0){                    //checking left upper diagonal
            if(inputArray[row][col] == 1){
                return false;
            }
            row --;
            col --;
        }

        row = checkRow;                                 //re-initialising current position
        col = checkCol;

        while(row >= 0){                                //checking the upper col 
            if(inputArray[row][col] == 1){
                return false;
            }
            row --;
        }

        row = checkRow;

        while(col < dimension && row >=0){              //checking the right upper diagonal
            if(inputArray[row][col] == 1){
                return false;
            }
            col ++;
            row --;
        }

        return true;
    }

    /**
     * it checks whether the queens can be placed in non-attacking position on that board or not
     * @param inputArray it is the board set to 0 . cannot have size < 4
     * @param startRow  it is the row at which we are finding the correct position of queen to be placed
     * @param dimensionOfMatrix it is the size of the board
     * @return boolean value which specifies whether we can place the queen on that board or not
     */

    public boolean positionOfQueens(int[][] inputArray , int startRow , int dimensionOfMatrix){

        assert dimensionOfMatrix > 3 : "Cannot place queen on board of less than 4 size";       //cannot have queens in non-attacking positions of borad size < 4

        if(startRow == dimensionOfMatrix){
            return true;

        }

        for(int index = 0 ; index < dimensionOfMatrix ; index ++){                              //assigning position to queen starting from first row

            if(validate(inputArray , startRow , index)){                                        //checking if that position is valid or not
                inputArray[startRow][index] = 1;

                if(positionOfQueens(inputArray, startRow+1, dimensionOfMatrix)){                //if finds valid then return we can place queen(Backtracking)
                    return true;
                }

                inputArray[startRow][index] = 0;                                                //if we can't place then set it to 0 again
            }
            
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        NQueens boardNQueens = new NQueens();

        System.out.println("Enter the size of the Queen Board");
        int dimensionOfMatrix = sc.nextInt();                                               //asking user the size of the board

        int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];                      //initializing board with that size with all elements set to 0
        boolean result = boardNQueens.positionOfQueens(board , 0 , dimensionOfMatrix);

        if(result){                                                                         //if queens can be placed at that position then print the positions of the array
            for(int row = 0 ; row < dimensionOfMatrix ; row ++){
                for(int col = 0 ; col < dimensionOfMatrix ; col++){
                    System.out.print(board[row][col] + "\t");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
