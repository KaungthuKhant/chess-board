public class Pawn {
    private int color; // -1 for white and 1 for black
    private boolean firstMove;
    private int xPosition;
    private int yPosition;

    public Pawn(int aColor, int x, int y){
        this.color = aColor;
        this.firstMove = true;
        this.xPosition = x;
        this.yPosition = y;
    }

    public void move(int x, int y){
        if (this.color == -1){
            whiteMove();
        }
        else{
            blackMove();
        }
    }

    public void whiteMove(){

    }

    public void blackMove(){

    }
}
