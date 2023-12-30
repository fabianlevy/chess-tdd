package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
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

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE) {
            int deltaX = newX - xCoordinate;
            int deltaY = newY - yCoordinate;

            if (deltaX == 0 && deltaY == -1 && newX >= 0 && newX < ChessBoard.BOARD_WIDTH && newY >= 0 && newY < ChessBoard.BOARD_HEIGHT) {
                xCoordinate = newX;
                yCoordinate = newY;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported movement type");
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
