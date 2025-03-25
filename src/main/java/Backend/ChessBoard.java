package Backend;

public class ChessBoard {
    public Piece[][] board;

    public ChessBoard() {
         board = new Piece[8][8];

        // Place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(new Position(1, i), Color.WHITE);
            board[6][i] = new Pawn(new Position(6, i), Color.BLACK);
        }

        // Place white main pieces
        board[0][0] = new Rook(new Position(0, 0), Color.WHITE);
        board[0][7] = new Rook(new Position(0, 7), Color.WHITE);
        board[0][1] = new Knight(new Position(0, 1), Color.WHITE);
        board[0][6] = new Knight(new Position(0, 6), Color.WHITE);
        board[0][2] = new Bishop(new Position(0, 2), Color.WHITE);
        board[0][5] = new Bishop(new Position(0, 5), Color.WHITE);
        board[0][3] = new Queen(new Position(0, 3), Color.WHITE);
        board[0][4] = new King(new Position(0, 4), Color.WHITE);

        // Place black main pieces
        board[7][0] = new Rook(new Position(7, 0), Color.BLACK);
        board[7][7] = new Rook(new Position(7, 7), Color.BLACK);
        board[7][1] = new Knight(new Position(7, 1), Color.BLACK);
        board[7][6] = new Knight(new Position(7, 6), Color.BLACK);
        board[7][2] = new Bishop(new Position(7, 2), Color.BLACK);
        board[7][5] = new Bishop(new Position(7, 5), Color.BLACK);
        board[7][3] = new Queen(new Position(7, 3), Color.BLACK);
        board[7][4] = new King(new Position(7, 4), Color.BLACK);
    }

    public boolean isOutsideBoard(Position position)
    {
        if(position.col > 7 || position.col < 0 || position.row > 7 || position.row < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Color getPieceColor(Position position)
    {
        if(isOccupied(position))
        {
            return board[position.row][position.col].color;
        }
        else
        {
            return null;
        }
    }

    public boolean isOccupied(Position position)
    {
        return board[position.row][position.col] != null;
    }

    public boolean isOccupiedBySameColor(Position position, Color color)
    {
      return isOccupied(position) && getPieceColor(position) == color;

    }

    public void placePiece(Piece piece)
    {
        if (isOutsideBoard(piece.position)) {
            throw new IllegalArgumentException("Position is outside the board");
        }
        if (isOccupied(piece.position)) {
            throw new IllegalArgumentException("Position is already occupied");
        }
        board[piece.position.row][piece.position.col] = piece;
    }


}
