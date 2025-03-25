package com.example.chess2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PieceView extends ImageView {
    private String type;
    private Color color;

    public PieceView(String type, Color color) {
        this.type = type;
        this.color = color;
        String colorName = color == Color.WHITE ? "white" : "black";
        String fileName = String.format("/pieces/chess_piece_2_%s_%s.png", colorName, type.toLowerCase());
        this.setImage(new Image(getClass().getResourceAsStream(fileName)));
        this.setFitWidth(40);
        this.setFitHeight(40);
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}