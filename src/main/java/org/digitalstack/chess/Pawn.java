package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private final PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.xCoordinate = -1;
        this.yCoordinate = -1;
        this.chessBoard = new ChessBoard();
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    // Coordinate setters
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    public void move(MovementType movementType, int newX, int newY) {
        if (movementType != MovementType.MOVE) {
            throw new UnsupportedOperationException("Only simple MOVE is supported for pawns");
        }
        int allowedYMove = (pieceColor == PieceColor.BLACK) ? -1 : 1;

        if (newX == xCoordinate && newY == yCoordinate + allowedYMove &&
                chessBoard.isLegalBoardPosition(newX, newY)) {
            setXCoordinate(newX);
            setYCoordinate(newY);
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