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

    public void moveX(MovementType movementType, int newX, int newY) {
        if((MovementType.MOVE.equals(movementType)) && (getChesssBoard().isLegalBoardPosition(newX,newY))) {
            if (newX - getXCoordinate() == 1 || getXCoordinate() - newX == 1) {
                setXCoordinate(newX);
                setYCoordinate(newY);
                System.out.println("Moved pawn to position (" + getXCoordinate() + "," + getYCoordinate() + ")");
            } else
                System.out.println("Pawn cannot be moved to position (" + newX + "," + newY + "). Only one position can be moved.");
        }
    }

    public void moveY(MovementType movementType, int newX, int newY) {
        if((MovementType.MOVE.equals(movementType)) && (getChesssBoard().isLegalBoardPosition(newX,newY))) {
            if (newY - getYCoordinate() == 1 || getYCoordinate() - newY == 1) {
                setXCoordinate(newX);
                setYCoordinate(newY);
                System.out.println("Moved pawn to position (" + getXCoordinate() + "," + getYCoordinate() + ")");
            } else
                System.out.println("Pawn cannot be moved to position (" + newX + "," + newY + "). Only one position can be moved.");
        }
    }

    public void moveXY(MovementType movementType, int newX, int newY) {
        if((MovementType.MOVE.equals(movementType)) && (getChesssBoard().isLegalBoardPosition(newX,newY))) {
            if ((newX - getXCoordinate() == 1 || getXCoordinate() - newX == 1) && (newY - getYCoordinate() == 1 || getYCoordinate() - newY == 1)) {
                setXCoordinate(newX);
                setYCoordinate(newY);
                System.out.println("Moved pawn to position (" + getXCoordinate() + "," + getYCoordinate() + ")");
            } else
                System.out.println("Pawn cannot be moved to position (" + newX + "," + newY + "). Only one position can be moved.");
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
