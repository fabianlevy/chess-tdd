package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

        if (!isLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);

        } else if (getNumberOfPawns(pieceColor) >= 7 || isDuplicatePosition(xCoordinate, yCoordinate, pieceColor)) {
            // dacă s-a atins limita de pioni de aceeași culoare sau poziția este deja ocupată, păstrăm coordonatele la -1
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        } else {
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
        }
    }

    private boolean isDuplicatePosition(int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        return pieces[xCoordinate][yCoordinate] != null &&
                pieces[xCoordinate][yCoordinate].getPieceColor() == pieceColor;

    }

    private int getNumberOfPawns(PieceColor pieceColor) {
        int count = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (pieces[i][j] != null && pieces[i][j].getPieceColor() == pieceColor) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate < BOARD_WIDTH) && (yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT);
    }
}
