import javax.lang.model.type.PrimitiveType;

public class chessGame {
    public static char turn = 'w';
    public static void main(String[] args){
        String[][][] board = {
            {{"bP", "  "}, {"bP", "%%"}, {"bP", "  "}, {"bP", "%%"}, {"bP", "  "}, {"bP", "%%"}, {"bP", "  "}, {"bP", "%%"}},
            {{"bR", "%%"}, {"bN", "  "}, {"bB", "%%"}, {"bQ", "  "}, {"bK", "%%"}, {"bB", "  "}, {"bN", "%%"}, {"bR", "  "}},
            {{"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}},
            {{"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}},
            {{"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}},
            {{"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}, {"", "%%"}, {"", "  "}},
            {{"wP", "  "}, {"wP", "%%"}, {"wP", "  "}, {"wP", "%%"}, {"wP", "  "}, {"wP", "%%"}, {"wP", "  "}, {"wP", "%%"}},
            {{"wR", "%%"}, {"wN", "  "}, {"wB", "%%"}, {"wQ", "  "}, {"wK", "%%"}, {"wB", "  "}, {"wN", "%%"}, {"wR", "  "}}
        };

        int[] test = promptUser(board);
    }

    public static int[] promptUser(String[][][] board){
        int[] moves = {0, 0};
        if (turn == 'w'){
            turn = 'b';
            for (int i = 0; i < 8; i++){
                System.out.println("-----------------------------------------");
                System.out.print("| ");
                for (int j = 0; j < 8; j++){
                    System.out.print(board[i][j][0] + " | ");
                }
                System.out.println(" ");
            }
        }
        else{
            turn = 'w';
        }
        return moves;
    }
}
