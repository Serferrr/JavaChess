import Backend.*;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void canMoveDiagonallyToEmptySquare() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        assertTrue(bishop.canMove(new Position(4, 2), board));
    }

    @Test
    void cannotMoveHorizontally() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        assertFalse(bishop.canMove(new Position(2, 2), board));
    }

    @Test
    void cannotMoveVertically() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        assertFalse(bishop.canMove(new Position(4, 0), board));
    }

    @Test
    void cannotMoveThroughOtherPieces() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        board.placePiece(new Pawn(new Position(3, 1), Color.WHITE));
        assertFalse(bishop.canMove(new Position(4, 2), board));
    }

    @Test
    void canCaptureOpponentPiece() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        board.placePiece(new Pawn(new Position(4, 2), Color.BLACK));
        assertTrue(bishop.canMove(new Position(4, 2), board));
    }

    @Test
    void cannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard();
        Bishop bishop = new Bishop(new Position(2, 0), Color.WHITE);
        board.placePiece(bishop);
        board.placePiece(new Pawn(new Position(4, 2), Color.WHITE));
        assertFalse(bishop.canMove(new Position(4, 2), board));
    }
}