package lab3;

import java.util.ArrayList;

public class Game {
    private Piece[][] board;

    public Game(){
        board = new Piece[8][8];
        board[1][0] = new Pawn(1, true);
        board[1][1] = new Pawn(1, true);
        board[1][2] = new Pawn(1, true);
        board[1][3] = new Pawn(1, true);
        board[1][4] = new Pawn(1, true);
        board[1][5] = new Pawn(1, true);
        board[1][6] = new Pawn(1, true);
        board[1][7] = new Pawn(1, true);

        board[6][0] = new Pawn(1, false);
        board[6][1] = new Pawn(1, false);
        board[6][2] = new Pawn(1, false);
        board[6][3] = new Pawn(1, false);
        board[6][4] = new Pawn(1, false);
        board[6][5] = new Pawn(1, false);
        board[6][6] = new Pawn(1, false);
        board[6][7] = new Pawn(1, false);

        board[0][0] = new Rook(3, true);
        board[0][7] = new Rook(3, true);

        board[7][0] = new Rook(3, false);
        board[7][7] = new Rook(3, false);

        board[0][1] = new Knight(5, true);
        board[0][6] = new Knight(5, true);

        board[7][1] = new Knight(5, false);
        board[7][6] = new Knight(5, false);

        board[0][2] = new Bishop(5, true);
        board[0][5] = new Bishop(5, true);

        board[7][2] = new Bishop(5, false);
        board[7][5] = new Bishop(5, false);

        board[0][3] = new Queen(5, true);
        board[7][3] = new Queen(5, false);

        board[0][4] = new King(5, true);
        board[7][4] = new King(5, false);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    /**
     * Move piece from current position to destination
     * @param pieceIndex takes in ArrayList from InputCollector,[originalCol, originalRow, destinationCol, destinationRow]
     */
    public void setPiece(ArrayList<Integer> pieceIndex){
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        int destinationCol = pieceIndex.get(2);
        int destinationRow = pieceIndex.get(3);
        this.board[destinationCol][destinationRow] = board[originalCol][originalRow];
        this.board[originalCol][originalRow] = null;
    }

    /**
     * Print board method
     */
    public void printBoard(){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(board[i][j] == null){
                    System.out.print("・ ");
                }else{
                    System.out.print(board[i][j].getIcon() + " ");
                }
            }
            System.out.println(" " + i);
        }
        System.out.println();
        System.out.print("a　b　c　d　e　f　g　h");
        System.out.println();
    }

    /**
     * THE MAIN GAME FLOW
     */
    public void run(){
        while (true) {
            InputCollector inputCollector = new InputCollector();

            // get user input (ex, e6e4)  <- need a validation
            setPiece(inputCollector.pickAndMove());
            // print board
            printBoard();
            // win check
            // change turn
        }
    }
}
