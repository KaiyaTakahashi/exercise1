//package lab3;
//
///**
// * @author Kaiya Takahashi
// */
//
//public class Knight extends Piece{
//    /**
//     * Constructor
//     * @param value
//     * @param isWhite
//     */
//    Knight(int value, boolean isWhite) {
//        super(2, isWhite);
//    }
//
//    @Override
//    public void move(){
//        System.out.println("Like an L");
//    }
//
//    @Override
//    public String getIcon() {
//        if (this.isWhite()) {
//            return "♞";
//        }else{
//            return "♘";
//        }
//    }
//
//    @Override
//    public void setValue(int value) {
//        super.setValue(value);
//    }
//
//    @Override
//    public int getValue() {
//        return super.getValue();
//    }
//}
package lab3;

import java.util.ArrayList;

/**
 * @author Kaiya Takahashi
 */

public class Knight extends Piece{
    /**
     * Constructor
     * @param value
     * @param isWhite
     */
    Knight(int value, boolean isWhite) {
        super(5, isWhite);
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♞";
        }else{
            return "♘";
        }
    }

    @Override
    public boolean move(Position newPosition, Piece[][] board) {
//        int newCol = newPosition.getCol();
//        int newRow = newPosition.getRow();
//        int col = this.position.getCol();
//        int row = this.position.getRow();
//
//        if (this.isValidMove(newPosition, board)) {
//            board[row][col] = null;
//            this.position = newPosition;
//            board[newRow][newCol] = this;
//            return true;
//        } else {
//            System.out.println("Invalid move!");
//            System.out.println("Knight only moves Like an L");
//            return false;
//        }
        return true;
    }

    @Override
    public boolean isValidMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
        // check if player picks the valid colour piece
        if (!this.isWhite()) {
            if (turnChanger % 2 == 0) {
                return false;
            }
        } else {
            if (turnChanger % 2 != 0) {
                return false;
            }
        }

        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        int destinationCol = pieceIndex.get(2);
        int destinationRow = pieceIndex.get(3);

        if ((originalCol + 2 == destinationCol && originalRow - 1 == destinationRow) ||
           (originalCol + 2 == destinationCol && originalRow + 1 == destinationRow) ||
           (originalCol - 2 == destinationCol && originalRow - 1 == destinationRow) ||
           (originalCol - 2 == destinationCol && originalRow + 1 == destinationRow)
        ){
            // when it is white or when it is black
            if (turnChanger % 2 == 0){
                return board[destinationCol][destinationRow] == null || !board[destinationCol][destinationRow].isWhite();
            }else{
                return board[destinationCol][destinationRow] == null || board[destinationCol][destinationRow].isWhite();
            }
        }else{
            return false;
        }
    }

    @Override
    public void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        ArrayList<String> possibleMove = new ArrayList<>();
        if (turnChanger % 2 == 0){
            try {
                if (board[originalCol + 2][originalRow - 1] == null || !board[originalCol + 2][originalRow - 1].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol + 2) + "]");
                }
            }catch (Exception ignored){
            }
            try {
                if (board[originalCol + 2][originalRow + 1] == null || !board[originalCol + 2][originalRow + 1].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow + 1) + (originalCol + 2) + "]");
                }
            }catch (Exception ignored){
            }
        }else{
            try {
                if (board[originalCol - 2][originalRow - 1] == null || board[originalCol - 2][originalRow - 1].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol - 2) + "]");
                }
            }catch (Exception ignored){
            }
            try {
                if (board[originalCol - 2][originalRow + 1] == null || board[originalCol - 2][originalRow + 1].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow + 1) + (originalCol - 2) + "]");
                }
            }catch (Exception ignored){
            }
        }
        System.out.println("Possible move: " + possibleMove);
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public String toString() {
        return "Knight{" + super.toString();
    }

    //    @Override
//    public void move(Position newPosition, Piece[][] board) {
//    }
}