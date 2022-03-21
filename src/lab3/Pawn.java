//package lab3;
//
//import java.util.Objects;
//
///**
// * @author Kaiya Takahashi
// */
//
//public class Pawn extends Piece{
//
//    private boolean promoted;
//    private Piece newPiece;
//
//    /**
//     * Constructor 1
//     * @param value
//     * @param isWhite
//     */
//    Pawn (int value, boolean isWhite){
//        super(1, isWhite);
//    }
//
//    /**
//     * Constructor 2
//     * @param value
//     * @param isWhite
//     * @param promoted
//     * @param newPiece
//     */
//    Pawn(int value, boolean isWhite, boolean promoted, Piece newPiece){
//        super(1, isWhite);
//        this.promoted = promoted;
//        this.newPiece = newPiece;
//    }
//
//    public String getIcon(){
//        if(this.isWhite()) {
//            return "♟";
//        }else{
//            return "♙";
//        }
//    }
//
//    @Override
//    public boolean isValidMove(Position newPosition) {
//        return super.isValidMove(newPosition);
//    }
//
//    public void promote(Piece newPiece){
//        this.promoted = true;
//        this.newPiece = newPiece;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Pawn pawn = (Pawn) o;
//        return promoted == pawn.promoted && Objects.equals(newPiece, pawn.newPiece);
//    }
//
//    @Override
//    public String toString() {
//        return "Pawn{" +
//                "promoted=" + promoted +
//                ", newPiece=" + newPiece +
//                '}';
//    }
//
//    @Override
//    public void move(){
//        System.out.println("Forward 1");
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
import java.util.Objects;

/**
 * @author Kaiya Takahashi
 */

public class Pawn extends Piece {

    private boolean promoted;
    private Piece newPiece;
    /**
     * Constructor 1
     *
     * @param value
     * @param isWhite
     */
    Pawn(int value, boolean isWhite) {
        super(1, isWhite);
    }

    /**
     * Constructor 2
     *
     * @param value
     * @param isWhite
     * @param promoted
     * @param newPiece
     */
    Pawn(int value, boolean isWhite, boolean promoted, Piece newPiece) {
        super(1, isWhite);
        this.promoted = promoted;
        this.newPiece = newPiece;
    }

    public String getIcon() {
        if (this.isWhite()) {
            return "♟";
        } else {
            return "♙";
        }
    }

    @Override
    public boolean move(Position newPosition, Piece[][] board) {
//        int newCol = newPosition.getCol();
//        int newRow = newPosition.getRow();
//        int col = this.position.getCol();
//        int row = this.position.getRow();
//
//        if (isValidMove(newPosition, board)) {
//            board[row][col] = null;
//            this.position = newPosition;
//            board[newRow][newCol] = this;
//            return true;
//        } else {
//            System.out.println("Invalid move!");
//            System.out.println("Pawn moves only forward by 1 or en passant");
//            return false;
//        }
        return true;
    }

    @Override
    public boolean isValidMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
//        if (!super.isValidMove(position, board)) {
//            return false;
//        }
//
//        int newCol = newPosition.getCol();
//        int newRow = newPosition.getRow();
//        int col = this.position.getCol();
//        int row = this.position.getRow();
//        Piece pawn = board[newRow][newCol];
//        if (pawn != null) {
//            if (pawn.isWhite() == this.isWhite()) {
//                return false;
//            }
//        }
//        if (pawn == null) {
//            if (this.isWhite()) {
//                return col == newCol && ((newRow == row - 1) || (row == 6 && newRow == row - 2));
//            } else {
//                return col == newCol && ((newRow == row + 1) || (row == 1 && newRow == row + 2));
//            }
//        } else {
//
//            boolean a = (newCol == col + 1) || (newCol == col - 1);
//            if (this.isWhite()) {
//                return newRow == row - 1 && a;
//            } else {
//                return newRow == row + 1 && a;
//            }
//
//        }
        return true;
    }

    @Override
    public void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {

    }

    public void promote(Piece newPiece) {
        this.promoted = true;
        this.newPiece = newPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pawn pawn = (Pawn) o;
        return promoted == pawn.promoted && Objects.equals(newPiece, pawn.newPiece);
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
        return "Pawn{" +
                "promoted=" + promoted +
                ", newPiece=" + newPiece +
                '}';
    }
}

//    @Override
//    public boolean move(Position newPosition, Piece[][] board) {
//        return false;
//    }
//}