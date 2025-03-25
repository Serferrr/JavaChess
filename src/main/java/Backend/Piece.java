package Backend;

public class Piece {
    public Color color;
    public Position position;
    public Piece(Position position, Color color) {this.position = position;
    this.color = color;}

    public boolean canMove(Position position, ChessBoard board) {
        return true;
    }
}
