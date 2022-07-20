package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH ][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        int numberOfWhitePawns = 0;
        int numberOfBlackPawns = 0;

        if (!isLegalBoardPosition(pawn.getXCoordinate(), pawn.getYCoordinate())) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        for (Pawn[] col : pieces) {
            for (Pawn row : col) {
                if (row != null) {
                    if (pieceColor.equals(PieceColor.WHITE)) numberOfWhitePawns += 1;
                    else numberOfBlackPawns += 1;
                }
            }
        }

        if (!(PieceColor.WHITE.equals(pieceColor) && numberOfWhitePawns < 7 || PieceColor.BLACK.equals(pieceColor) && numberOfBlackPawns < 7)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);

        } else if (pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = pawn;

        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }

    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;
    }
}
