package Backend;

public class Pawn extends Piece {
    boolean hasDoubleMoved = false;

    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMove(Position position, ChessBoard board) {
        int direction = this.color == Color.WHITE ? 1 : -1;
        int startRow = this.color == Color.WHITE ? 1 : 6;

// Normal forward move
        if (position.col == this.position.col && position.row == this.position.row + direction) {
            return board.board[position.row][position.col] == null;
        }

// Double forward move
        if (this.position.row == startRow && position.col == this.position.col && position.row == this.position.row + 2 * direction) {
             boolean moved = board.board[position.row][position.col] == null && board.board[this.position.row + direction][position.col] == null;
             if (moved) {
                 hasDoubleMoved = true;
             }
             return moved;
        }

// Capturing move
        if (Math.abs(position.col - this.position.col) == 1 && position.row == this.position.row + direction) {
            Piece target = board.board[position.row][position.col];
            return target != null && target.color != this.color;
        }

// Invalid move
        return false;

    }
}
