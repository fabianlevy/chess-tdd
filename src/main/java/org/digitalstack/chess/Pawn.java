package org.digitalstack.chess;

import static org.digitalstack.chess.PieceColor.BLACK;

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
        if(chessBoard.isLegalBoardPosition(newX, newY)) {
            if(pieceColor==BLACK){
                if(getXCoordinate()==newX) {
                    if(getYCoordinate()-1==newY) {
                        setNewCoordinates(newX,newY);
                    }else if(getYCoordinate()==6 && (getYCoordinate()-2)==newY){
                        setNewCoordinates(newX,newY);
                    }
                }
            }else{
                if(getXCoordinate()== newX){
                    if((getYCoordinate()+1) == newY){
                        setNewCoordinates(newX,newY);
                    }
                }else if(getYCoordinate()==1 && (getXCoordinate()+2)==newY){
                    setNewCoordinates(newX,newY);
                }
            }
        }
        //throw new UnsupportedOperationException("Need to implement Pawn.move()") ;
    }
    private void setNewCoordinates(int newX, int newY) {
        setXCoordinate(newX);
        setYCoordinate(newY);
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
