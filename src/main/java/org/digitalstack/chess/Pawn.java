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

    /**
     * Verificam daca avem instructiunea de move data ca si parametru.
     * In caz afirmativ verificam daca avem aceeasi coordonata pe axa X. (doar in acest caz se poate muta pionul)
     * Daca se intampla acest lucru verificam daca diferenta dintre vechile si noile coordonate in valoare absoluta
     * ne da rezultatul 1. (conform regulilor de sah, pionul poate parcurge un singur patratel).
     * Daca rezultatul obtinut este 1 atunci schimbam valoarea curenta de pe axa Y cu noua valoare, astfel avasand pionul.
     * @param movementType
     * @param newX
     * @param newY
     */
    public void move(MovementType movementType, int newX, int newY) {

        if (MovementType.MOVE.equals(movementType) && newX == getXCoordinate()) {
            if(Math.abs(getYCoordinate() - newY) == 1){
                setYCoordinate(newY);
            }
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
