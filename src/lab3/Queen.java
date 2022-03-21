//package lab3;
//
///**
// * @author Kaiya Takahashi
// */
//
//public class Queen extends Piece {
//
//    Queen(int value, boolean isWhite) {
//        super(9, isWhite);
//    }
//
//    @Override
//    public void move(){
//        System.out.println("Like bishop and rook");
//    }
//
//    @Override
//    public String getIcon() {
//        if (this.isWhite()) {
//            return "♛";
//        }else{
//            return "♕";
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

public class Queen extends Piece {

    Queen(int value, boolean isWhite) {
        super(9, isWhite);
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♛";
        } else {
            return "♕";
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
//            System.out.println("Queen only moves like bishop or rook");
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
//        if (position.getRow() == newPosition.getRow() && position.getCol() == newPosition.getCol()) {
//            return false;
//        }
//        if (
//                Math.abs(newPosition.getCol() - this.position.getCol()) ==
//                        Math.abs(newPosition.getRow() - this.position.getRow())
//        ) {
//            int crossPosition = Math.abs(newPosition.getCol() - this.position.getCol()) - 1;
//            if (
//                    newPosition.getRow() > this.position.getRow() &&
//                            newPosition.getCol() > this.position.getCol()) {
//                int row = this.position.getRow() + 1;
//                int col = this.position.getCol() + 1;
//                if (crossPosition == 0 && board[row][col] != null && board[row][col].isWhite() == isWhite()) {
//                    return false;
//                }
//                while (crossPosition > 0) {
//                    if (board[row][col] != null) {
//                        return false;
//                    }
//                    row += 1;
//                    col += 1;
//                    crossPosition -= 1;
//                }
//                return true;
//            } else if (
//                    newPosition.getRow() > this.position.getRow() &&
//                            newPosition.getCol() <= this.position.getCol()) {
//                int row = this.position.getRow() + 1;
//                int col = this.position.getCol() - 1;
//                if (crossPosition == 0 && board[row][col] != null && board[row][col].isWhite() == isWhite()) {
//                    return false;
//                }
//                while (crossPosition > 0) {
//                    if (board[row][col] != null) {
//                        return false;
//                    }
//                    row += 1;
//                    col -= 1;
//                    crossPosition -= 1;
//                }
//                return true;
//            } else if (
//                    newPosition.getRow() <= this.position.getRow() &&
//                            newPosition.getCol() > this.position.getCol()) {
//                int row = this.position.getRow() - 1;
//                int col = this.position.getCol() + 1;
//                if (crossPosition == 0 && board[row][col] != null && board[row][col].isWhite() == isWhite()) {
//                    return false;
//                }
//                while (crossPosition > 0) {
//                    if (board[row][col] != null) {
//                        return false;
//                    }
//                    row -= 1;
//                    col += 1;
//                    crossPosition -= 1;
//                }
//                return true;
//
//            } else {
//                int row = newPosition.getRow() + 1;
//                int col = newPosition.getCol() + 1;
//                if (crossPosition == 0 && board[row][col] != null && board[row][col].isWhite() == isWhite()) {
//                    return false;
//                }
//                while (crossPosition > 0) {
//                    if (board[row][col] != null) {
//                        return false;
//                    }
//                    row += 1;
//                    col += 1;
//                    crossPosition -= 1;
//                }
//                return true;
//            }
//
//        } else if (newPosition.getCol() == this.position.getCol()) {
//            int minRow;
//            int maxRow;
//            if (newPosition.getRow() >= this.position.getRow()) {
//                minRow = this.position.getRow();
//                maxRow = newPosition.getRow();
//            } else {
//                minRow = newPosition.getRow();
//                maxRow = this.position.getRow();
//            }
//            if (Math.abs(minRow - maxRow) == 1
//                    && board[newPosition.getRow()][newPosition.getCol()] != null
//                    && board[newPosition.getRow()][newPosition.getCol()].isWhite() == isWhite()
//            ) {
//                return false;
//            }
//            for (int r = minRow + 1; r < maxRow; r++) {
//                if (board[r][this.position.getCol()] != null) {
//                    return false;
//                }
//            }
//            return true;
//
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
//            if (Math.abs(minCol - maxCol) == 1
//                    && board[newPosition.getRow()][newPosition.getCol()] != null
//                    && board[newPosition.getRow()][newPosition.getCol()].isWhite() == isWhite()
//            ) {
//                return false;
//            }
//            for (int col = minCol + 1; col < maxCol; col++) {
//                if (board[this.position.getRow()][col] != null) {
//                    return false;
//                }
//            }
//            return true;
//
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
        return "Queen{" + super.toString();
    }
}
//    @Override
//    public boolean move(Position newPosition, Piece[][] board) {
//        return false;
//    }