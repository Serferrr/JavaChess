package Backend;

public class Knight extends Piece {
    public Knight(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMove(Position position, ChessBoard board) {
        int rowDiff = Math.abs(this.position.row - position.row);
        int colDiff = Math.abs(this.position.col - position.col);
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            return board.board[position.row][position.col] == null || board.board[position.row][position.col].color != this.color;
        }
        return false;
    }
}
