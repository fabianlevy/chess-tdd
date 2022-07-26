package org.digitalstack.chess;

import Chess.PieceColor;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	int numberOfWhites = 0;
        int numberOfBlacks = 0;
    	if(isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null 
    			&& isValidPawn(pieceColor,numberOfWhites,numberOfBlacks)) {
            if(PieceColor.BLACK.equals(pieceColor)) {
            	numberOfBlacks++;
            }
            else {
            	numberOfWhites++;
            }
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = pawn;
            }
        else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        	}
    	}
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	return xCoordinate >= 0 && xCoordinate <= 7 && yCoordinate >= 0 && yCoordinate <= 7;
    }
    
    public boolean isValidPawn(PieceColor pieceColor, int numberOfWhites, int numberOfBlacks) {
	    if(PieceColor.BLACK.equals(pieceColor) && numberOfWhites < 7) {
	    	return true;
	    }
	    else if(PieceColor.WHITE.equals(pieceColor) && numberOfBlacks < 7) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
}
