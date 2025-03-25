package Backend;

public class Chess {
    public ChessBoard board;
    public Color whosTurn;
    MoveValidator moveValidator;

    public Chess() {this.board = new ChessBoard();
    whosTurn = Color.WHITE;
    moveValidator = new MoveValidator();};
}
