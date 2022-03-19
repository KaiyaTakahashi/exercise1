package lab3;

import java.util.ArrayList;

/**
 * @author Kaiya Takahashi
 */

public class Bishop extends Piece{
    /**
     * Constructor
     * @param value
     * @param isWhite
     */
    Bishop(int value, boolean isWhite){
        super(3, isWhite);
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♝";
        }else{
            return "♗";
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
//        } else {
//            System.out.println("Invalid move!");
//            System.out.println("Bishop moves only diagonally");
//        }
        return false;
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

        // go up right and go down left
        if (Math.abs(originalCol + originalRow) == Math.abs(destinationCol + destinationRow)) {
            // go up right
            if (originalCol > destinationCol && originalRow < destinationRow) {
                int movableCol = originalCol - 1;
                int movableRow = originalRow + 1;
                // check if there is any piece on the way to the destination
                while (movableCol != -1 || movableRow != 8) {
                    if (board[movableCol][movableRow] == null) {
                        if (movableCol == destinationCol || movableRow == destinationRow) return true;
                        movableCol--;
                        movableRow++;
                    } else {
                        if ((board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (!(board[movableCol][movableRow].isWhite()) && turnChanger % 2 == 0)) {
                            if (movableCol == destinationCol || movableRow == destinationRow) return true;
                            System.out.print("Possible move to go up right: ");
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol++;
                                movableRow--;
                            }
                        } else if ((!board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (board[movableCol][movableRow].isWhite() && turnChanger % 2 == 0)) {
                            System.out.print("Possible move to go up right: ");
                            movableCol++;
                            movableRow--;
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol++;
                                movableRow--;
                            }
                        }
                        return false;
                    }
                }
            }
            // go down left
            if (originalCol < destinationCol && originalRow > destinationRow) {
                int movableCol = originalCol + 1;
                int movableRow = originalRow - 1;
                // check if there is any piece on the way to the destination
                while (movableCol != 8 || movableRow != -1) {
                    if (board[movableCol][movableRow] == null) {
                        if (movableCol == destinationCol || movableRow == destinationRow) return true;
                        movableCol++;
                        movableRow--;
                    } else {
                        if ((board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (!(board[movableCol][movableRow].isWhite()) && turnChanger % 2 == 0)) {
                            if (movableCol == destinationCol || movableRow == destinationRow) return true;
                            System.out.print("Possible move to go down left: ");
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol--;
                                movableRow++;
                            }
                        } else if ((!board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (board[movableCol][movableRow].isWhite() && turnChanger % 2 == 0)) {
                            System.out.print("Possible move to go down left: ");
                            movableCol--;
                            movableRow++;
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol--;
                                movableRow++;
                            }
                        }
                        return false;
                    }
                }
            }
        }

        // go up left and go down right
        if (Math.abs(originalCol - originalRow) == Math.abs(destinationCol - destinationRow)) {
            // go up left
            if (originalCol > destinationCol && originalRow > destinationRow) {
                int movableCol = originalCol - 1;
                int movableRow = originalRow - 1;
                // check if there is any piece on the way to the destination
                while (movableCol != -1 || movableRow != -1) {
                    if (board[movableCol][movableRow] == null) {
                        if (movableCol == destinationCol || movableRow == destinationRow) return true;
                        movableCol--;
                        movableRow--;
                    } else {
                        if ((board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (!(board[movableCol][movableRow].isWhite()) && turnChanger % 2 == 0)) {
                            if (movableCol == destinationCol || movableRow == destinationRow) return true;
                            System.out.print("Possible move to go up left: ");
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol++;
                                movableRow++;
                            }
                        } else if ((!board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (board[movableCol][movableRow].isWhite() && turnChanger % 2 == 0)) {
                            System.out.print("Possible move to go up left: ");
                            movableCol++;
                            movableRow++;
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol++;
                                movableRow++;
                            }
                        }
                        return false;
                    }
                }
            }
            // go down right
            if (originalCol < destinationCol && originalRow < destinationRow) {
                int movableCol = originalCol + 1;
                int movableRow = originalRow + 1;
                // check if there is any piece on the way to the destination
                while (movableCol != 8 || movableRow != 8) {
                    if (board[movableCol][movableRow] == null) {
                        if (movableCol == destinationCol || movableRow == destinationRow) return true;
                        movableCol++;
                        movableRow++;
                    } else {
                        if ((board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (!(board[movableCol][movableRow].isWhite()) && turnChanger % 2 == 0)) {
                            if (movableCol == destinationCol || movableRow == destinationRow) return true;
                            System.out.print("Possible move to go down left: ");
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol--;
                                movableRow--;
                            }
                        } else if ((!board[movableCol][movableRow].isWhite() && turnChanger % 2 != 0) ||
                                (board[movableCol][movableRow].isWhite() && turnChanger % 2 == 0)) {
                            System.out.print("Possible move to go down left: ");
                            movableCol--;
                            movableRow--;
                            while (movableCol != originalCol || movableRow != originalRow) {
                                String alphabetRow = numberToAlphabet(movableRow);
                                System.out.print("[" + alphabetRow + movableCol + "]");
                                movableCol--;
                                movableRow--;
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String numberToAlphabet(int row) {
        return super.numberToAlphabet(row);
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
        return "Bishop{" + super.toString();
    }
}