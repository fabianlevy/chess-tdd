package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }


    private int pawnCounter = 0;
    private static final int MAX_PAWNS = 7; // Change this value according to your requirements

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (pawnCounter < MAX_PAWNS) {
            if (isLegalBoardPosition(xCoordinate, yCoordinate)) {
                if (pieces[xCoordinate][yCoordinate] == null && pawn.getPieceColor() == pieceColor) {
                    pieces[xCoordinate][yCoordinate] = pawn;
                    pawn.setXCoordinate(xCoordinate);
                    pawn.setYCoordinate(yCoordinate);
                    pawnCounter++;
                } else {
                    pawn.setXCoordinate(-1);
                    pawn.setYCoordinate(-1);
                }
            } else {
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }



    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < BOARD_WIDTH &&
                yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;
//        throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
