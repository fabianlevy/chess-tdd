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

    void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    private boolean isValidMove(int newX, int newY) {
        int direction = (pieceColor == PieceColor.WHITE) ? 1 : -1;

        // Pawn movement validation logic
        // Allow forward movement one square and backward movement for WHITE pawns
        return (newX == xCoordinate && newY == yCoordinate + direction) ||
                (newX == xCoordinate && newY == yCoordinate - direction);
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE) {
            if (isValidMove(newX, newY)) {
                xCoordinate = newX;
                yCoordinate = newY;
            }
        }
        //throw new UnsupportedOperationException("Need to implement Pawn.move()") ;
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
