package Backend;

public class King extends Piece {
    boolean hasCastled = false;
    boolean inCheck = false;
    boolean hasMoved = false;
    public King(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMove(Position position, ChessBoard board) {
        int rowDiff = Math.abs(this.position.row - position.row);
        int colDiff = Math.abs(this.position.col - position.col);
        if ((rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1) || (rowDiff == 1 && colDiff == 1)) {
            return board.board[position.row][position.col] == null || board.board[position.row][position.col].color != this.color;
        }
        return false;
    }
}
