package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        // Set default position for pawn as (-1, -1)
        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
        if(isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate < 7 && xCoordinate >= 0 && yCoordinate < 7 && yCoordinate >= 0;
    }
    
    public boolean isValidMove(int newX, int newY, int oldX, int oldY) {
        return !(oldX - newX > 1 || newX - oldX > 1 || oldY - newY > 1 || newY - oldY > 1);
    }
    
    public boolean isFree(int firstX, int firstY, int secondX, int secondY) {
        return firstX != secondX && firstY != secondY;
    }
}
