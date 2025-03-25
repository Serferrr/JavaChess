package Backend;

public class Rook extends Piece {
    public Rook(Position position, Color color) {
        super(position, color);
    }

    public boolean canMove(Position position, ChessBoard board) {
        if (this.position.row == position.row) {
            int colStep = this.position.col < position.col ? 1 : -1;
            for (int col = this.position.col + colStep; col != position.col; col += colStep) {
                if (board.board[this.position.row][col] != null) {
                    return false;
                }
            }
            return board.board[position.row][position.col] == null || board.board[position.row][position.col].color != this.color;
        } else if (this.position.col == position.col) {
            int rowStep = this.position.row < position.row ? 1 : -1;
            for (int row = this.position.row + rowStep; row != position.row; row += rowStep) {
                if (board.board[row][this.position.col] != null) {
                    return false;
                }
            }
            return board.board[position.row][position.col] == null || board.board[position.row][position.col].color != this.color;
        }
        return false;
    }
}
