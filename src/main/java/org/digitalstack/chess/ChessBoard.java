package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        /*Chiar daca o tabla de sah este de obicei o matrice patratica nu era corect sa o instantiam cu BOARD_WIDTH
        linii si BOARD_HEIGHT coloane. */
        pieces = new Pawn[BOARD_HEIGHT][BOARD_WIDTH];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[yCoordinate][xCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[yCoordinate][xCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate < ChessBoard.BOARD_WIDTH)
                && (yCoordinate >= 0 && yCoordinate < ChessBoard.BOARD_HEIGHT);
    }
}
