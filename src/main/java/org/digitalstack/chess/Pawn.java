package org.digitalstack.chess;

import static java.lang.Math.abs;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Pawn(Pawn pawn, PieceColor pieceColor){
        this.xCoordinate = pawn.getXCoordinate();
        this.yCoordinate = pawn.getYCoordinate();
        this.pieceColor = pawn.getPieceColor();
    }

    public Pawn(int xCoordinate, int yCoordinate, PieceColor pieceColor){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if(movementType == MovementType.MOVE && newX == this.xCoordinate && abs(newY - this.yCoordinate) == 1){
            this.yCoordinate = newY;
        }
        else if (movementType == MovementType.CAPTURE && newY - this.yCoordinate == 1 && abs(newX - this.xCoordinate) == 1) {
            this.xCoordinate = newX;
            this.yCoordinate = newY;
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
