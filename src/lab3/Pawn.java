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

        if (originalRow == destinationRow && Math.abs(originalCol - destinationCol) == 1) {
            if (originalCol + 1 > 7 || originalCol - 1 < 0) {
                return false;
            } else {
                if (turnChanger % 2 == 0) {
                    if (originalCol < destinationCol) {
                        return board[destinationCol][destinationRow] == null || !board[destinationCol][destinationRow].isWhite();
                    }
                } else {
                    if (originalCol > destinationCol) {
                        return board[destinationCol][destinationRow] == null || board[destinationCol][destinationRow].isWhite();
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }

    @Override
    public void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger) {
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        ArrayList<String> possibleMove = new ArrayList<>();
        if (turnChanger % 2 == 0){
            try {
                if (board[originalCol + 1][originalRow] == null || !board[originalCol + 1][originalRow].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol + 1) + "]");
                }
            }catch (Exception ignored){
            }
        }else{
            try {
                if (board[originalCol - 1][originalRow] == null || board[originalCol - 1][originalRow].isWhite()) {
                    possibleMove.add("[" + numberToAlphabet(originalRow) + (originalCol - 1) + "]");
                }
            }catch (Exception ignored){
            }
        }
        System.out.println("Possible move: " + possibleMove);
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