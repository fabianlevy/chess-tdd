package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        // check if the given coordinates are within the legal board position
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null ) {
            // place the pawn at the specified coordinates
            pieces[xCoordinate][yCoordinate] = pawn;
            // set the pawn's color and coordinates
            pawn.setPieceColor(pieceColor);
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
        } else {
            // invalidate the pawn's coordinates if the position is occupied
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        // ensure that the provided coordinates are within the bounds defined by BOARD_WIDTH and BOARD_HEIGHT
        if (xCoordinate >= 0 && xCoordinate < BOARD_WIDTH) {
            if (yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT) {
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
