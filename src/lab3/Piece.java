package lab3;

import java.util.ArrayList;

/**
 * @author Kaiya Takahashi
 */

public abstract class Piece {

    protected Position position;

    private int value;
    private boolean isWhite;

    Piece(int value, boolean isWhite){
        this.value = value;
        this.isWhite = isWhite;
    }

    public abstract boolean move(Position newPosition, Piece[][] board);

    public abstract String getIcon();

    public void setPiece(Piece piece){
    }

    public abstract boolean isValidMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger);

    public String numberToAlphabet(int row){
        switch (row){
            case 0 -> { return "a";}
            case 1 -> { return "b";}
            case 2 -> { return "c";}
            case 3 -> { return "d";}
            case 4 -> { return "e";}
            case 5 -> { return "f";}
            case 6 -> { return "g";}
            case 7 -> { return "h";}
            default -> {return "";}
        }
    }

    public abstract void printPossibleMove(ArrayList<Integer> pieceIndex, Piece[][] board, int turnChanger);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value && isWhite == piece.isWhite;
    }

    @Override
    public String toString() {
        return  "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void move() {
    }
}