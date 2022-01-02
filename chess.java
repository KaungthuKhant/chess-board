import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class chess{
    // public String[][] board;

    // INSTEAD OF STRING, CHAR MIGHT SAVE ME SOME TROUBLE
    public static ArrayList<String> rowIndexes = new ArrayList<String>();
    public static ArrayList<String> ColumnIndexes = new ArrayList<String>();
    public static void main(String[] args){

        // variables
        String winner = "";                     // store the color of winner, "" when game start
        String[] players = {"white", "black"}; // might not need this
        String[] chosenMove = {"", ""};
        int turn = 1;

        // mthods
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to this humble game of Chess!");
        System.out.println(" ");

        String[] ColumnIndex = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] rowIndexes = {"8", "7", "6", "5", "4", "3", "2", "1"};

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
            {"bC", "bN", "bB", "bQ", "bK", "bB", "bN", "bC", "8"},
            {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP", "7"},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%", "6"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  ", "5"},
            {"  ", "%%", "  ", "%%", "  ", "%%", "  ", "%%", "4"},
            {"%%", "  ", "%%", "  ", "%%", "  ", "%%", "  ", "3"},
            {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP", "2"},
            {"wC", "wN", "wB", "wQ", "wK", "wB", "wN", "wC", "1"}, 
            {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" }
        }; 

        

        boolean test = true;

        while(winner == ""){
            Scanner scan = new Scanner(System.in);

            if (turn == 1){
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 9; j++){
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println("");
                }
                for (int k = 0; k < 8; k++){
                    System.out.print(board[8][k] + "  ");
                }
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("It is white's turn.");
                System.out.println("Enter your current piece: ");
                String currentPosition = scan.nextLine();
                System.out.println("Enter your next move: ");
                String nextPosition = scan.nextLine();
                chosenMove[0] = currentPosition;
                chosenMove[1] = nextPosition;
                String[] pieces = assignUserMoveAsPieces(chosenMove, board); // String[0] contain piece that is moving String: piece or " " from next move
                Boolean valid = checkMoveValidityandMove(chosenMove, pieces, 'w', board, emptyBoard);
            }
            else{
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 9; j++){
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println("");
                }
                for (int k = 0; k < 8; k++){
                    System.out.print(board[8][k] + "  ");
                }
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("It is black's turn.");
                System.out.println("Enter your current piece: ");
                String currentPosition = scan.nextLine();
                System.out.println("Enter your next move: ");
                String nextPosition = scan.nextLine();
                chosenMove[0] = currentPosition;
                chosenMove[1] = nextPosition;
                String[] pieces = assignUserMoveAsPieces(chosenMove, board);
                Boolean valid = checkMoveValidityandMove(chosenMove, pieces, 'b', board, emptyBoard);
            }

            //movePieces(moves);
            
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

        // check if next position is valid move for chosen piece by calling the following funextColumntion

        // checkPositionValidity(String curPos, String nextPos) { if nextPos == "  " || nextPos == "%%"} 
        // every piece will have a funextColumntion that will check if a move is valid based on the current position and 
        // chosen position, is the piece allowed to move to the next position with it's properties and they way it moves
        // (inside this funextColumntion, it will call another funextColumntion in the beginning that check if
        // the future position is occupied by a piece of the same color)

        // move the piece to that position and check the following requirements
        // 1. does it capture a piece?
        // 2. does it check the king with the next move?
        input.close();
    }


    // a funextColumniton to prompt the use what they want to see
    public static String[] promptUser(String turn){
        String currPst = "";
        String nextPst = "";
        Scanner scn = new Scanner(System.in);
        System.out.println("It is "+ turn + "'s turn.");
        System.out.println("Please put in the current position and next position that you want to move");
        System.out.println("Current Position: ");
        if (scn.hasNextLine()){
            currPst = scn.nextLine();
        }
        System.out.println("Next Position: ");
        if (scn.hasNextLine()){
            nextPst = scn.nextLine();
        }
        
        /*
        while (scn.hasNextLine()){
            currPst = scn.nextLine();
        }
        System.out.println("Next Position: ");
        while (scn.hasNextLine()){
            nextPst = scn.nextLine();
        }*/
        String[] chosenMove= {currPst, nextPst};
        scn.close();
        return chosenMove;
    }

    public static boolean checkMoveValidityandMove (String[] moves, String[] pieces, char color, String[][] board, String[][] emptyBoard){
        // variables
        // check if it is the same color as player
        System.out.println("color "+ pieces[0].charAt(0));

        // user can only move their piece
        if (!(pieces[0].charAt(0) == color)){
            System.out.println("This is not your piece");
            return false;
        }

        // if destination is occupied by another piece of yours, you cannot move them
        if (pieces[1].charAt(0) == color){
            System.out.println("Cannot move: There is another piece of yours on the spot that you want to move");
            return false;
        }

        // other wise, check the path, for the ones that need to check (queen, bishop, castle, 
        // pawn(exception because they move twice in the first round and there could be sth between the move in later game))

        // pieces that does not need to check, king and knight (they only need to check the destination)

        else{
            //check if the move is a vlid move
            if (pieces[1].charAt(0) == 'w'){
                System.out.println("You have your own piece at the next position that you want to move");
                return false;
            }
            if (pieces[0].charAt(1) == 'P'){
                System.out.println("It is a pawn that you are moving");
                Boolean piecesMoveable = checkPawnMoveValidity(moves, board);
                if (piecesMoveable){
                    Integer[] playerMovesAsIndex = new Integer[4];
                    assignPlayerMoveAsIndex(moves, playerMovesAsIndex);
                    System.out.println("Paw is moveable and it is moving now");
                    movePieces(playerMovesAsIndex, board, emptyBoard);
                }
            }

            
            // make sure there is nothing on the path of moving piece
        }
        // check if the move is the right movement for that piece
            // if so, check if there is a piece
                // if so, check if that is opposite color, 
                // else return false
            // else, move the piece to nextPos
        return true;
    }

    public static boolean checkPawnMoveValidity(String[] moves, String[][] board){
        System.out.println("Pawn move is checking");
        // check if they are in their original destination by checking the number
        char columnAlphabet = moves[0].charAt(0);  // contains the alphabet of the chosen move
        String colAlpha = String.valueOf(columnAlphabet); 
        int indexOfColumn = ColumnIndexes.indexOf(colAlpha);
        System.out.println("The index of the Column: "+ indexOfColumn);
        if (moves[0].charAt(1) == '2' && moves[1].charAt(1) == '4'){
            System.out.println("the location in between has: " + board[5][indexOfColumn]);
            if (board[5][indexOfColumn] == "  " || board[5][indexOfColumn] == "%%"){
                System.out.println("It's a free place");
                return true;
            }
            // String colAlpha = String.valueOf(columnAlphabet); 
            //int boardColumn = board[8].indexOf(colAlpha);
            //if ()
        }
        else if (moves[0].charAt(1) == '7' && moves[1].charAt(1) == '5'){
            System.out.println("the location in between has: " + board[2][indexOfColumn]);
            if (board[2][indexOfColumn] == "  " || board[2][indexOfColumn] == "%%"){
                System.out.println("It's a free place");
                return true;
            }
        }
        else{
            // make sure they are only moving once at a time
            // also make sure, they are not jumping out of the board (ie: don't let them exceed the board number)
            int num = Integer.parseInt("1");
            int currentPosRowNum = moves[0].charAt(1);
            int nextPosRowNum = moves[1].charAt(1);

            int moveNumDifference = currentPosRowNum - nextPosRowNum;
            if (moveNumDifference == 1 && nextPosRowNum >=0 && nextPosRowNum < 8){
                return true;
            }
            else{
                return false;
            }
            // if they are only move one move, then check if there is a move from that person's side
        }
        return false;
    }

    public static void assignPlayerMoveAsIndex(String[] moves, Integer[] playerMovesAsIndex){
        Integer indexOfFirstMove = (int) moves[0].charAt(0) - 97;
        Integer indexOfSecondMove = (int) moves[1].charAt(0) - 97;
        String column0AsString = String.valueOf(moves[0].charAt(1));
        String column1AsString = String.valueOf(moves[1].charAt(1));
        Integer firstMoveColumnIndex = rowIndexes.indexOf(column0AsString);
        Integer SecondMoveColumnIndex = rowIndexes.indexOf(column1AsString);

        playerMovesAsIndex[0] = firstMoveColumnIndex;
        playerMovesAsIndex[1] = indexOfFirstMove;
        playerMovesAsIndex[2] = SecondMoveColumnIndex;
        playerMovesAsIndex[3] = indexOfSecondMove;
    }

    public static void movePieces(Integer[] moves, String[][] board, String[][] emptyBoard){
        // integer move array contains 4 elements that are the index positions of the move
        // use the board to move the pieces
        System.out.println("move pieces got called");
        System.out.println(moves[0]);
        System.out.println(moves[1]);
        System.out.println(moves[2]);
        System.out.println(moves[3]);
        System.out.println(board[moves[0]][moves[1]]);
        board[moves[2]][moves[3]] = board[moves[0]][moves[1]];
        board[moves[0]][moves[1]] = emptyBoard[moves[0]][moves[1]];

        // get the position and move the one
        // need empty board, current board and move indexes
        System.out.println("pieces have been moved");
    }

    public static String[] assignUserMoveAsPieces(String[] move, String[][] board){
        rowIndexes.add("8");
        rowIndexes.add("7");
        rowIndexes.add("6");
        rowIndexes.add("5");
        rowIndexes.add("4");
        rowIndexes.add("3");
        rowIndexes.add("2");
        rowIndexes.add("1");
        ColumnIndexes.add("a");
        ColumnIndexes.add("b");
        ColumnIndexes.add("c");
        ColumnIndexes.add("d");
        ColumnIndexes.add("e");
        ColumnIndexes.add("f");
        ColumnIndexes.add("g");
        ColumnIndexes.add("h");
        //8
        //7
        //6
        //5
        //4
        //3
        //2
        //1
        //  a, b, c, d, e, f, g, h
        String currentRow = String.valueOf(move[0].charAt(1));    // currentRow for current row
        String currentColumn = String.valueOf(move[0].charAt(0));   // currentColumn for current column
        String nextRow = String.valueOf(move[1].charAt(1));    // nextRow next row
        String nextColumn = String.valueOf(move[1].charAt(0));     // nextColumn next column
        System.out.println(currentRow);
        System.out.println(currentColumn);
        System.out.println(nextRow);
        System.out.println(nextColumn);
        int[] moveIndex = {rowIndexes.indexOf(currentRow), ColumnIndexes.indexOf(currentColumn), rowIndexes.indexOf(nextRow), ColumnIndexes.indexOf(nextColumn)};
        String[] pieces = {board[moveIndex[0]][moveIndex[1]], board[moveIndex[2]][moveIndex[3]]};
        System.out.println(pieces[0]);
        System.out.println(pieces[1]);
        return pieces;
    }

    // pawn 
    // check if if it is the first move, if it is allow for two jump
    // if first and wants to jump two move, check if there are any pieces in the way
    // if yes, cannot move
    // else, move the piece there and use the smaple empty board index to look for the color

    public static void promptErrorMessage(String errorName){
        if (errorName == "WRONGCOLOR"){
            System.out.println("You are choosing the pieces that is not yours");
        }
    }
}

