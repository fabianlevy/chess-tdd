package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!isValidMove(movementType, newX, newY)) {
            return;
        }

        if (movementType == MovementType.MOVE) {
            setYCoordinate(newY);
            setXCoordinate(newX);
        } else if (movementType == MovementType.CAPTURE) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
    }

    private boolean isValidMove(MovementType movementType, int newX, int newY) {
        int yDirection = (pieceColor == PieceColor.WHITE) ? 1 : -1;

        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return false;
        }

        if (movementType == MovementType.MOVE) {
            return (newY - yCoordinate == yDirection) && newX == xCoordinate;
        } else if (movementType == MovementType.CAPTURE) {
            return Math.abs(newX - xCoordinate) == 1 && newY - yCoordinate == yDirection && isOpponentPieceAt(newX, newY);
        }

        return false;
    }

    private boolean isOpponentPieceAt(int x, int y) {
        Pawn piece = chessBoard.getPieceAt(x, y);
        return piece != null && piece.getPieceColor() != this.pieceColor;
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
