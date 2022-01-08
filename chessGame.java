import javax.lang.model.type.PrimitiveType;
import java.util.Scanner;
import java.util.ArrayList;

public class chessGame {
    public static char turn = 'w';
    public static ArrayList<Character> rowIndexes = new ArrayList<Character>();
    public static ArrayList<Character> columnIndexes = new ArrayList<Character>();

    public static Pawn p1 = new Pawn('w', 0, 6);
    
    public static void main(String[] args){
        char winner = 'n';
        
        String[][][] board = {
            {{"bR", "%%", "1"}, {"bN", "  ", "1"}, {"bB", "%%", "1"}, {"bQ", "  ", "1"}, {"bK", "%%", "1"}, {"bB", "  ", "2"}, {"bN", "%%", "2"}, {"bR", "  ", "2"}},
            {{"bP", "  ", "1"}, {"bP", "%%", "2"}, {"bP", "  ", "3"}, {"bP", "%%", "4"}, {"bP", "  ", "5"}, {"bP", "%%", "6"}, {"bP", "  ", "7"}, {"bP", "%%", "8"}},
            {{"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}},
            {{"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}},
            {{"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}},
            {{"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}, {"%%", "%%", "0"}, {"  ", "  ", "0"}},
            {{"wP", "  ", "1"}, {"wP", "%%", "2"}, {"wP", "  ", "3"}, {"wP", "%%", "4"}, {"wP", "  ", "5"}, {"wP", "%%", "6"}, {"wP", "  ", "7"}, {"wP", "%%", "8"}},
            {{"wR", "%%", "1"}, {"wN", "  ", "2"}, {"wB", "%%", "3"}, {"wQ", "  ", "4"}, {"wK", "%%", "5"}, {"wB", "  ", "6"}, {"wN", "%%", "7"}, {"wR", "  ", "8"}}
        };

        rowIndexes.add('8');
        rowIndexes.add('7');
        rowIndexes.add('6');
        rowIndexes.add('5');
        rowIndexes.add('4');
        rowIndexes.add('3');
        rowIndexes.add('2');
        rowIndexes.add('1');
        columnIndexes.add('a');
        columnIndexes.add('b');
        columnIndexes.add('c');
        columnIndexes.add('d');
        columnIndexes.add('e');
        columnIndexes.add('f');
        columnIndexes.add('g');
        columnIndexes.add('h');


        while (winner == 'n'){
            int[] userInput = promptUser(board);
            if (board[userInput[1]][userInput[0]][0].charAt(1) == 'P'){
                System.out.println("yay, it's pawn");
                p1.checkAndMove(userInput[2], userInput[3]);
                int[] position = p1.getPosition();
                board[position[1]][position[0]][0] = "wP";
                board[userInput[1]][userInput[0]][0] = board[userInput[1]][userInput[0]][1];
            }
        }
        
    }

    public static int[] promptUser(String[][][] board){
        Scanner scan = new Scanner(System.in);
        String currentPosition;
        String nextPosition;


        System.out.println(" ");
        if (turn == 'w'){
            turn = 'b';
            for (int i = 0; i < 8; i++){
                System.out.println("-----------------------------------------");
                System.out.print("| ");
                for (int j = 0; j < 8; j++){
                    System.out.print(board[i][j][0] + " | ");
                }
                if (i == 0){
                    System.out.print("     Move: White");
                }
                System.out.println(" ");
            }
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.print("Enter your current piece: ");
            currentPosition = scan.nextLine();
            System.out.println(" ");
            System.out.print("Enter your next move: ");
            nextPosition = scan.nextLine();
        }
        else{
            turn = 'w';
            for (int i = 0; i < 8; i++){
                System.out.println("-----------------------------------------");
                System.out.print("| ");
                for (int j = 0; j < 8; j++){
                    System.out.print(board[i][j][0] + " | ");
                }
                if (i == 0){
                    System.out.print("     Move: Black");
                }
                System.out.println(" ");
            }
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.print("Enter your current piece: ");
            currentPosition = scan.nextLine();
            System.out.println(" ");
            System.out.print("Enter your next move: ");
            nextPosition = scan.nextLine();
        }

        // split the string that user put in into char
        char xCurrent = currentPosition.charAt(0);
        char yCurrent = currentPosition.charAt(1);
        char xNext = nextPosition.charAt(0);
        char yNext = nextPosition.charAt(1);

        // turn the char into x and y coordinates
        int currentXIndex = columnIndexes.indexOf(xCurrent);
        int currentYIndex = rowIndexes.indexOf(yCurrent);
        int nextXIndex = columnIndexes.indexOf(xNext);
        int nextYIndex = rowIndexes.indexOf(yNext);

        // assign to moves
        int[] moves = {currentXIndex, currentYIndex, nextXIndex, nextYIndex};

        System.out.println(" ");
        return moves;
    }
}
