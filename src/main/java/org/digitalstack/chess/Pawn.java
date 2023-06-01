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
        if (chessBoard.isLegalBoardPosition(newX, newY)) {
            if (movementType == MovementType.MOVE && checkMove(newX, newY)) {
                setXCoordinate(newX);
                setYCoordinate(newY);
            } else if (movementType == MovementType.CAPTURE && checkCapture(newX, newY)) {
                setXCoordinate(newX);
                setYCoordinate(newY);
            }
        }
    }

    private boolean checkMove(int newX, int newY) {
        if (newX == xCoordinate) {
            if (pieceColor == PieceColor.BLACK) {
                return newY == yCoordinate - 1;
            } else if (pieceColor == PieceColor.WHITE) {
                return newY == yCoordinate + 1;
            }
        }

        return false;
    }

    private boolean checkCapture(int newX, int newY) {
        if (newX == xCoordinate - 1 || newX == xCoordinate + 1) {
            if (pieceColor == PieceColor.BLACK) {
                return newY == yCoordinate - 1;
            } else if (pieceColor == PieceColor.WHITE) {
                return newY == yCoordinate + 1;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
