import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Pawn {
    private char color; // w for white and b for black
    private boolean firstMove;
    private int xPosition;
    private int yPosition;

    public Pawn(char aColor, int x, int y){
        this.color = aColor;
        this.firstMove = true;
        this.xPosition = x;
        this.yPosition = y;
    }

    // checkAndMove the pawn piece
    public void checkAndMove(int x, int y){
        boolean moveable = false;
        // white
        if (this.color == 'w'){
            moveable = checkIfWhiteMoveIsValid(x, y);
        }
        // black
        else{
            moveable = checkIfBlackMoveIsValid(x, y);
        }
        
        if (moveable){
            this.xPosition = x;
            this.yPosition = y;
        }
    }

    public boolean checkIfWhiteMoveIsValid(int x, int y){
        int xDifference = this.xPosition - x;
        int yDifference = this.yPosition - y;
        // check if the move is horizontally valid
        if (xDifference < -1 || xDifference > 1){
            return false;
        }
        // check if the move is vertically valid
        if (!this.firstMove){
            // needs to be positive in order to be valid
            if (yDifference != 1){
                return false;
            }
        }
        else if(this.firstMove){
            if (yDifference < 1 || yDifference > 2){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfBlackMoveIsValid(int x, int y){
        return false;
    }
}
