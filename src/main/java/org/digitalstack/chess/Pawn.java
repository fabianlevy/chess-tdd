package org.digitalstack.chess;

//import com.sun.org.apache.xpath.internal.operations.Bool;

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

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE && chessBoard != null) {

            if (checkMove(newX, newY) && chessBoard.isLegalBoardPosition(newX, newY)) {
                xCoordinate = newX;
                yCoordinate = newY;
            }
        }
    }

    public Boolean checkMove(int currX, int currY) {
        if (currX >= 0 && currX < ChessBoard.BOARD_WIDTH && currY >= 0 && currY < ChessBoard.BOARD_HEIGHT) {
            if (getPieceColor() == PieceColor.BLACK) {
                return currX >= getXCoordinate();
            } else if (getPieceColor() == PieceColor.WHITE) {
                return currY >= getYCoordinate();
            }
            return true;
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
