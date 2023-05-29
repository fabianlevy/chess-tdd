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

    public void move(MovementType movementType, int newX, int newY)
    {
        int direction = -1;
        //the x coordinate must be the same (the pawn can't be moved left or right)
        // the pawn can be moved a maximum of 1 square straight forward
        //the direction depends on the pawn color

        if(this.pieceColor == PieceColor.BLACK)
        {
            direction = 1;
        }

        if(this.getXCoordinate() == newX &&  this.getYCoordinate() - newY == direction )
        {
            if (movementType == MovementType.MOVE && chessBoard.isLegalBoardPosition(newX, newY))
            {
                chessBoard.add(this, newX, newY, this.pieceColor);
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
