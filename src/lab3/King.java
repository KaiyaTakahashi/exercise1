//package lab3;
//
///**
// * @author Kaiya Takahashi
// */
//
//public class King extends Piece{
//
//    King(int value, boolean isWhite) {
//        super(1_000, isWhite);
//    }
//
//    @Override
//    public void move(){
//        System.out.println("One square");
//    }
//
//    @Override
//    public String getIcon() {
//        if (this.isWhite()) {
//            return "♚";
//        }else{
//            return "♔";
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

public class King extends Piece {

    King(int value, boolean isWhite) {
        super(1_000, isWhite);
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♚";
        } else {
            return "♔";
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
//            System.out.println("King moves only one square in any direction");
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
        if (Math.abs(destinationRow - originalRow) <= 1 && Math.abs(destinationCol - originalCol) <= 1){
            // check if there is any piece on destination
            if (board[destinationCol][destinationRow] == null){
                return true;
            }else {
                if (board[originalCol][originalRow].isWhite()) {
                    // check if it is different colour from picked piece
                    return !board[destinationCol][destinationRow].isWhite();
                } else {
                    return board[destinationCol][destinationRow].isWhite();
                }
            }
        }
        return false;
    }

    @Override
    public void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        ArrayList<String> possibleMove = new ArrayList<>();
        try {
            if (board[originalCol - 1][originalRow - 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol- 1) + "]");
            }
            if((board[originalCol - 1][originalRow - 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol - 1][originalRow - 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol- 1) + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol - 1][originalRow] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol - 1) + "]");
            }
            if((board[originalCol - 1][originalRow].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol - 1][originalRow].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol - 1) + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol - 1][originalRow + 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow + 1) + (originalCol-1) + "]");
            }
            if((board[originalCol - 1][originalRow + 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol - 1][originalRow + 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow + 1) + (originalCol-1) + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol][originalRow - 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow -1) + originalCol + "]");
            }
            if((board[originalCol][originalRow - 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol][originalRow - 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow -1) + originalCol + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol][originalRow + 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow + 1) + originalCol + "]");
            }
            if((board[originalCol][originalRow + 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol][originalRow + 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow + 1) + originalCol + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol + 1][originalRow - 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol+1) + "]");
            }
            if((board[originalCol + 1][originalRow - 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol + 1][originalRow - 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow - 1) + (originalCol+1) + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol + 1][originalRow] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol+1) + "]");
            }
            if((board[originalCol + 1][originalRow].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol + 1][originalRow].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol+1) + "]");
            }
        }catch (Exception ignored){
        }
        try {
            if (board[originalCol + 1][originalRow + 1] == null) {
                possibleMove.add("[" + numberToAlphabet(originalRow+1) + (originalCol+1) + "]");
            }
            if((board[originalCol + 1][originalRow + 1].isWhite() && turnChanger % 2 != 0) ||
                    (!(board[originalCol + 1][originalRow + 1].isWhite()) && turnChanger % 2 == 0)){
                possibleMove.add("[" + numberToAlphabet(originalRow+1) + (originalCol+1) + "]");
            }
        }catch (Exception ignored){
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
        return "King{" + super.toString();
    }

    //    @Override
//    public boolean move(Position newPosition, Piece[][] board) {
//        return false;
//    }
}