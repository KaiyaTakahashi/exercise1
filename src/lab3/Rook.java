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
//
//        if (!super.isValidMove(position, board)) {
//            return false;
//        }
//
//        if (newPosition.getCol() == this.position.getCol()) {
//            int minRow;
//            int maxRow;
//            if (newPosition.getRow() >= this.position.getRow()) {
//                minRow = this.position.getRow();
//                maxRow = newPosition.getRow();
//            } else {
//                minRow = newPosition.getRow();
//                maxRow = this.position.getRow();
//            }
//            for (int r = minRow + 1; r < maxRow; r++) {
//                if (board[r][this.position.getCol()] != null) {
//                    return false;
//                }
//            }
//            return board[newPosition.getRow()][newPosition.getCol()] == null || board[newPosition.getRow()][newPosition.getCol()].isWhite() != isWhite();
//        } else if (newPosition.getRow() == this.position.getRow()) {
//            int minCol;
//            int maxCol;
//            if (newPosition.getCol() >= this.position.getCol()) {
//                minCol = this.position.getCol();
//                maxCol = newPosition.getCol();
//            } else {
//                minCol = newPosition.getCol();
//                maxCol = this.position.getCol();
//            }
//            for (int c = minCol + 1; c < maxCol; c++) {
//                if (board[this.position.getRow()][c] != null) {
//                    return false;
//                }
//            }
//            return board[newPosition.getRow()][newPosition.getCol()] == null || board[newPosition.getRow()][newPosition.getCol()].isWhite() != isWhite();
//        } else {
//            return false;
//        }
        return true;
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