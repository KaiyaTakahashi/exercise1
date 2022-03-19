//package lab3;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class InputCollector {
//
//    private Integer originalRow;
//    private Integer originalCol;
//    private Integer destinationRow;
//    private Integer destinationCol;
//
//    /**
//     * Pick and move a piece method  !!!1NEED VALIDATION!!!!!
//     * @return [originalCol, originalRow, destinationCol, destinationRow]
//     */
//    public ArrayList<Integer> pickAndMove() {
//        ArrayList<Integer> pieceIndex = new ArrayList<>(4);
//        Scanner scanner = new Scanner(System.in);
//        boolean validInput = false;
//        while (!validInput) {
//            validInput = true;
//            System.out.println("Type `help` to see help menu");
//            System.out.print("Enter the position of piece and destination: ");
//            try {
//                String piecePosition = scanner.nextLine();
//                if (piecePosition.length() > 6) {
//                    System.out.println("Invalid input");
//                    validInput = false;
//                } else {
//                    char tempOriginalRow = piecePosition.charAt(0);
//                    char tempOriginalCol = piecePosition.charAt(1);
//                    char tempDestinationRow = piecePosition.charAt(2);
//                    char tempDestinationCol = piecePosition.charAt(3);
//
//                    //using to call helpMenu method in Game
//                    if (piecePosition.length() == 4 && tempOriginalRow == 'h' && tempOriginalCol == 'e' && tempDestinationRow == 'l' && tempDestinationCol == 'p'){
//                        tempOriginalRow = 'z';
//                        tempOriginalCol = '9';
//                        tempDestinationRow = 'z';
//                        tempDestinationCol = '9';
//                    } else if (piecePosition.length() == 4 && tempOriginalRow == 'q' && tempOriginalCol == 'u' && tempDestinationRow == 'i' && tempDestinationCol == 't') {
//                        tempOriginalRow = 'z';
//                        tempOriginalCol = '0';
//                        tempDestinationRow = 'z';
//                        tempDestinationCol = '0';
//                    }
//                    switch (tempOriginalRow) {
//                        case 'a' -> originalRow = 0;
//                        case 'b' -> originalRow = 1;
//                        case 'c' -> originalRow = 2;
//                        case 'd' -> originalRow = 3;
//                        case 'e' -> originalRow = 4;
//                        case 'f' -> originalRow = 5;
//                        case 'g' -> originalRow = 6;
//                        case 'h' -> originalRow = 7;
//                        case 'z' -> originalRow = 9;
//                        default -> {
//                            validInput = false;
//                        }
//                    }
//                    switch (tempOriginalCol) {
//                        case '0' -> originalCol = 0;
//                        case '1' -> originalCol = 1;
//                        case '2' -> originalCol = 2;
//                        case '3' -> originalCol = 3;
//                        case '4' -> originalCol = 4;
//                        case '5' -> originalCol = 5;
//                        case '6' -> originalCol = 6;
//                        case '7' -> originalCol = 7;
//                        case '9' -> originalCol = 9;
//                        default -> {
//                            validInput = false;
//                        }
//                    }
//                    switch (tempDestinationRow) {
//                        case 'a' -> destinationRow = 0;
//                        case 'b' -> destinationRow = 1;
//                        case 'c' -> destinationRow = 2;
//                        case 'd' -> destinationRow = 3;
//                        case 'e' -> destinationRow = 4;
//                        case 'f' -> destinationRow = 5;
//                        case 'g' -> destinationRow = 6;
//                        case 'h' -> destinationRow = 7;
//                        case 'z' -> destinationRow = 9;
//                        default -> {
//                            validInput = false;
//                        }
//                    }
//                    switch (tempDestinationCol) {
//                        case '0' -> destinationCol = 0;
//                        case '1' -> destinationCol = 1;
//                        case '2' -> destinationCol = 2;
//                        case '3' -> destinationCol = 3;
//                        case '4' -> destinationCol = 4;
//                        case '5' -> destinationCol = 5;
//                        case '6' -> destinationCol = 6;
//                        case '7' -> destinationCol = 7;
//                        case '9' -> destinationCol = 9;
//                        default -> {
//                            validInput = false;
//                        }
//                    }
//                    if (!validInput) {
//                        System.out.println("Invalid input");
//                    }
//                }
//            }catch (Exception e){
//                System.out.println("Invalid input");
//                validInput = false;
//            }
//        }
//        pieceIndex.add(originalCol);
//        pieceIndex.add(originalRow);
//        pieceIndex.add(destinationCol);
//        pieceIndex.add(destinationRow);
//        return pieceIndex;
//    }
//}
package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class InputCollector {

    private Integer originalRow;
    private Integer originalCol;
    private Integer destinationRow;
    private Integer destinationCol;

    /**
     * Pick and move a piece method  !!!1NEED VALIDATION!!!!!
     * @return [originalCol, originalRow, destinationCol, destinationRow]
     */
    public ArrayList<Integer> pickAndMove() {
        ArrayList<Integer> pieceIndex = new ArrayList<>(4);
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            validInput = true;
            System.out.println("Type `help` to see help menu");
            System.out.print("Enter the position of piece and destination: ");
            try {
                String piecePosition = scanner.nextLine();
                if (piecePosition.length() > 6) {
                    System.out.println("Invalid input");
                    validInput = false;
                } else {
                    char tempOriginalRow = piecePosition.charAt(0);
                    char tempOriginalCol = piecePosition.charAt(1);
                    char tempDestinationRow = piecePosition.charAt(2);
                    char tempDestinationCol = piecePosition.charAt(3);

                    //using to call helpMenu method in Game
                    if (piecePosition.length() == 4 && tempOriginalRow == 'h' && tempOriginalCol == 'e' && tempDestinationRow == 'l' && tempDestinationCol == 'p'){
                        //help command
                        tempOriginalRow = 'z';
                        tempOriginalCol = '9';
                        tempDestinationRow = 'z';
                        tempDestinationCol = '9';
                    } else if (piecePosition.length() == 4 && tempOriginalRow == 'q' && tempOriginalCol == 'u' && tempDestinationRow == 'i' && tempDestinationCol == 't') {
                        //quit command
                        tempOriginalRow = 'z';
                        tempOriginalCol = '0';
                        tempDestinationRow = 'z';
                        tempDestinationCol = '0';
                    } else if (piecePosition.length() == 6 && tempOriginalRow == 'r' && tempOriginalCol == 'e' && tempDestinationRow == 's' && tempDestinationCol == 'i' && piecePosition.charAt(4) == 'g' && piecePosition.charAt(5) == 'n') {
                        //resign command
                        tempOriginalRow = 'z';
                        tempOriginalCol = '1';
                        tempDestinationRow = 'z';
                        tempDestinationCol = '1';
                    }


                    switch (tempOriginalRow) {
                        case 'a' -> originalRow = 0;
                        case 'b' -> originalRow = 1;
                        case 'c' -> originalRow = 2;
                        case 'd' -> originalRow = 3;
                        case 'e' -> originalRow = 4;
                        case 'f' -> originalRow = 5;
                        case 'g' -> originalRow = 6;
                        case 'h' -> originalRow = 7;
                        case 'z' -> originalRow = 9;
                        default -> {
                            validInput = false;
                        }
                    }

                    switch (tempOriginalCol) {
                        case '0' -> originalCol = 0;
                        case '1' -> originalCol = 1;
                        case '2' -> originalCol = 2;
                        case '3' -> originalCol = 3;
                        case '4' -> originalCol = 4;
                        case '5' -> originalCol = 5;
                        case '6' -> originalCol = 6;
                        case '7' -> originalCol = 7;
                        case '9' -> originalCol = 9;
                        default -> {
                            validInput = false;
                        }
                    }

                    switch (tempDestinationRow) {
                        case 'a' -> destinationRow = 0;
                        case 'b' -> destinationRow = 1;
                        case 'c' -> destinationRow = 2;
                        case 'd' -> destinationRow = 3;
                        case 'e' -> destinationRow = 4;
                        case 'f' -> destinationRow = 5;
                        case 'g' -> destinationRow = 6;
                        case 'h' -> destinationRow = 7;
                        case 'z' -> destinationRow = 9;
                        default -> {
                            validInput = false;
                        }
                    }
                    switch (tempDestinationCol) {
                        case '0' -> destinationCol = 0;
                        case '1' -> destinationCol = 1;
                        case '2' -> destinationCol = 2;
                        case '3' -> destinationCol = 3;
                        case '4' -> destinationCol = 4;
                        case '5' -> destinationCol = 5;
                        case '6' -> destinationCol = 6;
                        case '7' -> destinationCol = 7;
                        case '9' -> destinationCol = 9;
                        default -> {
                            validInput = false;
                        }
                    }
                    if (!validInput) {
                        System.out.println("Invalid input");
                    }
                }
            }catch (Exception e){
                System.out.println("Invalid input");
                validInput = false;
            }
        }
        pieceIndex.add(originalCol);
        pieceIndex.add(originalRow);
        pieceIndex.add(destinationCol);
        pieceIndex.add(destinationRow);
        return pieceIndex;
    }
}