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
        switch (movementType) {
        case MOVE:
            // Verificam daca coordonatele sunt in limitele tablei de joc
            if (!chessBoard.isLegalBoardPosition(newX, newY)) {
                return;
            }
            //Mutare piese negre(descendent)
            if (pieceColor == PieceColor.BLACK) {
                if (newX == this.xCoordinate && newY == this.yCoordinate - 1) {
                    setYCoordinate(newY);
                }
            }

            // Mutare piese albe(ascendent)
            if (pieceColor == PieceColor.WHITE) {
                if (newX == this.xCoordinate && newY == this.yCoordinate + 1) {
                    setYCoordinate(newY);
                }
            }
            break;

        case CAPTURE:
            break;
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
