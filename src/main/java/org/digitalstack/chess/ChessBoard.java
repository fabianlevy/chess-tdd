package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    private static final int MAX_PAWNS_PER_COLOR = 8;
    private int blackPawnCount = 0;
    private int whitePawnCount = 0;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

        if (!isLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        if (pieceColor == PieceColor.BLACK && blackPawnCount >= MAX_PAWNS_PER_COLOR) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        } else if (pieceColor == PieceColor.WHITE && whitePawnCount >= MAX_PAWNS_PER_COLOR) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        if (xCoordinate >= BOARD_WIDTH) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        if (!isPositionOccupied(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;

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

    public static boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate <= BOARD_WIDTH) && (yCoordinate >= 0 && yCoordinate <= BOARD_HEIGHT);
    }

    public boolean isPositionOccupied(int x, int y) {
        return pieces[x][y] != null;
    }

}
