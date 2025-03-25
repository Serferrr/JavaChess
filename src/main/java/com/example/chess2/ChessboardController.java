package com.example.chess2;

import Backend.Chess;
import Backend.ChessBoard;
import Backend.Piece;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessboardController {

    @FXML
    private GridPane chessboard;

    private Chess chess;

    @FXML
    public void initialize() {
        chess = new Chess();
        ChessBoard board = chess.board;

        int size = 8; // 8x8 chessboard
        double squareSize = 50.0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle square = new Rectangle(squareSize, squareSize);
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.BEIGE);
                } else {
                    square.setFill(Color.SADDLEBROWN);
                }
                StackPane stackPane = new StackPane(square);
                chessboard.add(stackPane, col, row);
            }
        }

        populateBoard(board);
    }

    private void populateBoard(ChessBoard board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.board[row][col];
                if (piece != null) {
                    addPiece(piece, col, row);
                }
            }
        }
    }

    private void addPiece(Piece piece, int col, int row) {
        String type = switch (piece.getClass().getSimpleName()) {
            case "Bishop", "Knight", "Rook", "Queen", "King", "Pawn" -> piece.getClass().getSimpleName();
            default -> "Unknown";
        };

        Color color = piece.color == Backend.Color.WHITE ? Color.WHITE : Color.BLACK;
        PieceView pieceView = new PieceView(type, color);
        StackPane stackPane = (StackPane) chessboard.getChildren().get(row * 8 + col);
        stackPane.getChildren().add(pieceView);
    }
}