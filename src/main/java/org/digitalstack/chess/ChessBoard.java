package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;
    public static final int MAX_PAWNS_PER_COLUMN = 1;
    private final int[] pawnsPerColumn;
    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
        pawnsPerColumn = new int[BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) &&  canPlacePawnInColumn(yCoordinate) && !isPawnAlreadyPlaced(pawn)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
            pieces[xCoordinate][yCoordinate] = pawn;
            pawnsPerColumn[yCoordinate]++;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }
    private boolean canPlacePawnInColumn(int column) {
        return pawnsPerColumn[column] < MAX_PAWNS_PER_COLUMN;
    }
    private boolean isPawnAlreadyPlaced(Pawn pawn) {
        for (Pawn[] piece : pieces) {
            for (Pawn value : piece) {
                if (value == pawn) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >=0 && xCoordinate < pieces.length && yCoordinate >=0 && yCoordinate <pieces[0].length;
    }
}
