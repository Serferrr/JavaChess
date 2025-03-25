package Backend;

public class MoveValidator {

    public boolean isMoveValid(ChessBoard board, Piece piece, Position position)
    {
        return piece.canMove(position, board);
    }
    public boolean canLongCastle(ChessBoard board, King king)
    {
        return true;
    }
    public boolean canShortCastle(ChessBoard board, King king)
    {
        return true;
    }
    public boolean canEnPassant(ChessBoard board, Pawn move_pawn, Pawn target)
    {
        return true;
    }
}
