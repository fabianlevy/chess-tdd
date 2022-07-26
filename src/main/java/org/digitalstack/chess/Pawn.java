package org.digitalstack.chess;

import Chess.MovementType;

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
    	if(MovementType.MOVE.equals(movementType)) {
    		if(this.getYCoordinate() > 1 && (this.getXCoordinate() == newX || this.getXCoordinate()-1 == newX)) {
    			this.setXCoordinate(newX);
                this.setYCoordinate(newY);
               }
    	   }
    	else {
    		if(this.getYCoordinate()+1 == newX && (this.getXCoordinate()<= newX || this.getXCoordinate()-1 == newX)) {
    			this.setXCoordinate(newX);
    			this.setYCoordinate(newY);
    		   }
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
