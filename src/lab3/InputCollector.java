package lab3;

import java.util.Scanner;

public class InputCollector {

    private char row;
    private char col;

    public String pickPiece() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            validInput = true;
            System.out.print("pick a piece(ex, a0): ");

            String piecePosition = scanner.nextLine();
            char tempRow = piecePosition.charAt(0);
            char tempCol = piecePosition.charAt(1);

            switch (tempRow) {
                case 'a' -> row = '0';
                case 'b' -> row = '1';
                case 'c' -> row = '2';
                case 'd' -> row = '3';
                case 'e' -> row = '4';
                case 'f' -> row = '5';
                case 'g' -> row = '6';
                case 'h' -> row = '7';
                default -> {
                    validInput = false;
                    System.out.println("Invalid input");
                }
            }
            switch (tempCol) {
                case '0' -> col = '0';
                case '1' -> col = '1';
                case '2' -> col = '2';
                case '3' -> col = '3';
                case '4' -> col = '4';
                case '5' -> col = '5';
                case '6' -> col = '6';
                case '7' -> col = '7';
                default -> {
                    validInput = false;
                    System.out.println("Invalid input");
                }
            }
        }
        return row + Character.toString(col);
    }
}
