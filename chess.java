import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class chess{
    // public String[][] board;
    public static void main(String[] args){

        // variables
        String winner = "";                     // store the color of winner, "" when game start
        String[] players = {"white", "black"}; // might not need this
        String[] chosenMove;
        int turn = 1;

        // mthods
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to this humble game of Chess!");

        String[] ColumnIndex = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] rowIndex = {"8", "7", "6", "5", "4", "3", "2", "1"};

        String[][] emptyBoard = {
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "}
        };

        String[][] board = {
            {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
            {"bC", "bN", "bB", "bQ", "bK", "bB", "bN", "bC"},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  "},
            {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
            {"wC", "wN", "wB", "wQ", "wK", "wB", "wN", "wC"}
        };

        while(winner == ""){
            if (turn == 1){
                chosenMove = promptUser("white");
                String[] pieces = assignPiece(chosenMove, board); // String[0] contain piece that is moving String: piece or " " from next move
                Boolean valid = checkMoveValidity(chosenMove, pieces, 'w', board);
            }
            else{
                chosenMove = promptUser("black");
                String[] pieces = assignPiece(chosenMove, board);
                Boolean valid = checkMoveValidity(chosenMove, pieces, 'b', board);
            }

            movePieces();
            
            turn = turn * (-1);
        }

        System.out.println("Yay!!!");
        System.out.println("The winner is "+ winner+ " player");


        // ask for what pieces that they want to move (ask for position and confirm the piece)

        // i might not need the two line below
        // the pieces that they can use are stored inside an array 
        // every time they lost a piece, it got taken out from the array

        // ask for position and check if there is a piece there, else ask for position again        done
        // check whether the position chosen is owned by white or black (the current player)   wK for white king and bK for black king

        // check if next position is valid move for chosen piece by calling the following function

        // checkPositionValidity(String curPos, String nextPos) { if nextPos == "  " || nextPos == "%%"} 
        // every piece will have a function that will check if a move is valid based on the current position and 
        // chosen position, is the piece allowed to move to the next position with it's properties and they way it moves
        // (inside this function, it will call another function in the beginning that check if
        // the future position is occupied by a piece of the same color)

        // move the piece to that position and check the following requirements
        // 1. does it capture a piece?
        // 2. does it check the king with the next move?
        input.close();
    }


    // a funciton to prompt the use what they want to see
    public static String[] promptUser(String turn){
        Scanner scn = new Scanner(System.in);
        System.out.println("It is "+ turn + "'s turn.");
        System.out.println("Please put in the current position and next position that you want to move");
        System.out.println("Current Position: ");
        String currPst = scn.nextLine();
        //while (input.hasNextLine()){
        //    currPst = input.nextLine();
        //}
        System.out.println("Next Position: ");
        String nextPst = scn.nextLine();
        String[] chosenMove= {currPst, nextPst};
        scn.close();
        return chosenMove;
    }


    public static boolean checkMoveValidity (String[] moves, String[] pieces, char color, String[][] board){
        // variables
        // check if it is the same color as player
        System.out.println("color "+ pieces[0].charAt(0));
        if (!(pieces[0].charAt(0) == color)){
            return false;
        }
        // check if the move is the right movement for that piece
            // if so, check if there is a piece
                // if so, check if that is opposite color, 
                // else return false
            // else, move the piece to nextPos
        return true;
    }

    public static void movePieces(){
        System.out.println("pieces have been moved");
    }

    public static String[] assignPiece(String[] move, String[][] board){
        ArrayList<String> rowIndex = new ArrayList<String>();
        rowIndex.add("8");
        rowIndex.add("7");
        rowIndex.add("6");
        rowIndex.add("5");
        rowIndex.add("4");
        rowIndex.add("3");
        rowIndex.add("2");
        rowIndex.add("1");
        ArrayList<String> columnIndex = new ArrayList<String>();
        columnIndex.add("a");
        columnIndex.add("b");
        columnIndex.add("c");
        columnIndex.add("d");
        columnIndex.add("e");
        columnIndex.add("f");
        columnIndex.add("g");
        columnIndex.add("h");

        String cr = String.valueOf(move[0].charAt(1));    // cr for current row
        String cc = String.valueOf(move[0].charAt(0));   // cc for current column
        String nr = String.valueOf(move[1].charAt(1));    // nr next row
        String nc = String.valueOf(move[1].charAt(0));     // nc next column

        int[] moveIndex = {rowIndex.indexOf(cr), columnIndex.indexOf(cc), rowIndex.indexOf(nr), columnIndex.indexOf(nc)};
        String[] pieces = {board[moveIndex[0]][moveIndex[1]], board[moveIndex[0]][moveIndex[1]]};
        return pieces;
    }

    // pawn 
    // check if if it is the first move, if it is allow for two jump
    // if first and wants to jump two move, check if there are any pieces in the way
    // if yes, cannot move
    // else, move the piece there and use the smaple empty board index to look for the color
}