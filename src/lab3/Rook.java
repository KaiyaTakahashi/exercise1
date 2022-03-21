//package lab3;
//
///**
// * @author Kaiya Takahashi
// */
//
//public class Rook extends Piece{
//
//    Rook(int value, boolean isWhite) {
//        super(5, isWhite);
//    }
//
//    @Override
//    public void move(){
//        System.out.println("Horizontally or vertically");
//    }
//
//    @Override
//    public String getIcon() {
//        if (this.isWhite()) {
//            return "♜";
//        }else{
//            return "♖";
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

public class Rook extends Piece {

    Rook(int value, boolean isWhite) {
        super(5, isWhite);
    }


    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♜";
        } else {
            return "♖";
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
//            System.out.println("Invalid movement!");
//            System.out.println("Rooks moves only horizontally or vertically");
//            return false;
//        }
        return true;
    }

    @Override
    public boolean isValidMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        int destinationCol = pieceIndex.get(2);
        int destinationRow = pieceIndex.get(3);

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

        // check if destination is valid
        // check if current position and destination are same position
        if (originalRow == destinationRow && originalCol == destinationCol) {
            return false;
        }

        // go right
        if (originalRow < destinationRow && originalCol == destinationCol){
            for (int i = originalRow+1; i <= destinationRow; i++){
                if (board[originalCol][i] != null){
                    if (i == destinationRow){
                        if (board[originalCol][i].isWhite()){
                            return turnChanger % 2 != 0;
                        }else{
                            return turnChanger % 2 == 0;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        // go left
        if (originalRow > destinationRow && originalCol == destinationCol){
            for (int i = originalRow-1; i >= destinationRow; i--){
                if (board[originalCol][i] != null){
                    if (i == destinationRow){
                        if (board[originalCol][i].isWhite()){
                            return turnChanger % 2 != 0;
                        }else{
                            return turnChanger % 2 == 0;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        // go down
        if (originalRow == destinationRow && originalCol < destinationCol){
            for (int i = originalCol+1; i <= destinationCol; i++){
                if (board[i][originalRow] != null){
                    if (i == destinationCol) {
                        if (board[i][originalRow].isWhite()) {
                            return turnChanger % 2 != 0;
                        } else {
                            return turnChanger % 2 == 0;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        // go up
        if (originalRow == destinationRow && originalCol > destinationCol){
            for (int i = originalCol-1; i >= destinationCol; i--){
                if (board[i][originalRow] != null){
                    if (i == destinationCol) {
                        if (board[i][originalRow].isWhite()) {
                            return turnChanger % 2 != 0;
                        } else {
                            return turnChanger % 2 == 0;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {

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
        return "Rook{" + super.toString();
    }

    //    @Override
//    public boolean move(Position newPosition, Piece[][] board) {
//        return false;
//    }
}