public class Piece {
    private boolean exist;
    private String type;

    public Piece(){
        this.exist = true;
    }

    public Piece(String type, char aColor, int x, int y){
        this.exist = true;
        this.type = type;
    } 
}
