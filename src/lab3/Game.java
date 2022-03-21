package lab3;

import java.util.ArrayList;

public class Game {
    private Piece[][] board;
    private int turnChanger = 0;


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
     *
     * @param pieceIndex
     * @return
     */
    public boolean keepPlaying(ArrayList<Integer> pieceIndex){
        boolean res = true;
        boolean sameColour;
        int originalCol = pieceIndex.get(0);
        int originalRow = pieceIndex.get(1);
        if (pieceIndex.size() == 2){
            Piece tempPiece = board[originalCol][originalRow];
            try {
                sameColour = true;
                // check if player picks the valid colour piece
                if (!tempPiece.isWhite()) {
                    if (turnChanger % 2 == 0) {
                        System.out.println("Wrong piece");
                        sameColour = false;
                    }
                } else {
                    if (turnChanger % 2 != 0) {
                        System.out.println("Wrong piece");
                        sameColour = false;
                    }
                }
                if (sameColour) {
                    tempPiece.printPossibleMove(pieceIndex, board, turnChanger);
                }
            }catch (NullPointerException e){
                System.out.println("Invalid input");
            }
            turnChanger++;
            return true;
        }
        int destinationCol = pieceIndex.get(2);
        int destinationRow = pieceIndex.get(3);

        //help command
        if (originalRow == 9 && originalCol == 9 && destinationRow == 9 && destinationCol == 9){
            printHelpMenu();
            turnChanger++;
        } else if (originalRow == 9 && originalCol == 0 && destinationRow == 9 && destinationCol == 0) {
            //quit command
            System.out.println("See ya");
            res = false;
        } else if (originalRow == 9 && originalCol == 1 && destinationRow == 9 && destinationCol == 1) {
            //resign command
            System.out.println("------ Game over ------");
            if (turnWhite()){
                System.out.println("Black won by resignation");
            } else {
                System.out.println("White won by resignation");
            }
            res = false;

        } else {
            setPiece(pieceIndex);
        }
        return res;
    }

    public boolean turnWhite(){
        boolean res;
        res = turnChanger % 2 == 0;
        return res;
    }

    /**
     * Move piece from current position to destination
     */
    public void setPiece(ArrayList<Integer> pieceIndex){
        int originalCol1 = pieceIndex.get(0);
        int originalRow1 = pieceIndex.get(1);
        int destinationCol1 = pieceIndex.get(2);
        int destinationRow1 = pieceIndex.get(3);
        Piece tempPiece = this.board[originalCol1][originalRow1];
        if (tempPiece.isValidMove(pieceIndex, this.board, this.turnChanger)) {
            this.board[destinationCol1][destinationRow1] = board[originalCol1][originalRow1];
            this.board[originalCol1][originalRow1] = null;
            System.out.println("Nice move");
            System.out.println();
        }else{
            System.out.println();
            System.out.println("You can't move there");
            InputCollector inputCollector = new InputCollector();
            keepPlaying(inputCollector.pickAndMove());
        }
    }

//    /**
//     * Print board method
//     */
//    public void printBoard(){
//        for(int i = 0; i < 8; i++){
//            for (int j = 0; j < 8; j++){
//                if(board[i][j] == null){
//                    System.out.print(". ");
//                }else{
//                    System.out.print(board[i][j].getIcon() + " ");
//                }
//            }
//            System.out.println(" " + i);
//        }
//        System.out.print("a b c d e f g h");
//        System.out.println();
//    }

    /**
     * Print board method    !!!!only for my laptop!!!!
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


    public void printHelpMenu(){
        System.out.println();
        System.out.println("type 'help' for help");
        System.out.println("type 'resign' to resign");
        System.out.println("type 'moves' to list all possible moves");
        System.out.println("type 'quit' to stop this app");
        System.out.println("type a square (e.g. a2, b1...) to list all possible moves for that square");
        System.out.println();
    }

    /**
     * THE MAIN GAME FLOW
     */
    public void run(){

        while (true) {
            // print board
            printBoard();
            System.out.println();

            if (turnWhite()){
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            // check user input (ex, e6e4)  <- need a validation
            InputCollector inputCollector = new InputCollector();
            if (!keepPlaying(inputCollector.pickAndMove())){
                break;
            };

            // win check




            turnChanger++;

        }
    }
}