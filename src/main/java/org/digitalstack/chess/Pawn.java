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

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }

        int xDiff = newX - xCoordinate;
        int yDiff = newY - yCoordinate;

        switch (movementType) {
            case MOVE:
                handleMove(xDiff, yDiff, newX, newY);
                break;
            case CAPTURE:
                handleCapture(xDiff, yDiff, newX, newY);
                break;
            default:
                throw new IllegalArgumentException("Unknown movement type: " + movementType);
        }
    }

    private void handleMove(int xDiff, int yDiff, int newX, int newY) {
        if (pieceColor == PieceColor.WHITE && xDiff == 0 && yDiff == 1) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        } else if (pieceColor == PieceColor.BLACK && xDiff == 0 && yDiff == -1) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
    }

    private void handleCapture(int xDiff, int yDiff, int newX, int newY) {
        if (pieceColor == PieceColor.WHITE && Math.abs(xDiff) == 1 && yDiff == 1) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        } else if (pieceColor == PieceColor.BLACK && Math.abs(xDiff) == 1 && yDiff == -1) {
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
