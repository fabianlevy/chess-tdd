package org.digitalstack.chess;

public class ChessBoard {

    public static final int BOARD_WIDTH = 7;
    public static final int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;
    private int blackPawnCount = 0;
    private int whitePawnCount = 0;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];  // Ensure the size matches board dimensions
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        // check the limit
        if ((pieceColor == PieceColor.BLACK && blackPawnCount >= 8) ||
                (pieceColor == PieceColor.WHITE && whitePawnCount >= 8)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
            // exit if no more pawns can be added
        }

        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);

            // Pawn counter
            if (pieceColor == PieceColor.BLACK) {
                blackPawnCount++;
            } else {
                whitePawnCount++;
            }
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < BOARD_WIDTH &&
                yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;
    }
}