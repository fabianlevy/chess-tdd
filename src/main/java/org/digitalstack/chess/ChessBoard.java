package org.digitalstack.chess;
/**
 * Usually the standard chessboard size is 8x8, but I am not going to change
 * the size as there are existing tests expecting 7x7 layout.
 */
public class ChessBoard {
    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;
    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    /**
     * I created an overloaded add() method to reduce the number of parameters,
     * as the constructor of the Pawn class already includes the piece color,
     * there's no need for a fourth parameter in the add() method declaration.
     * Instead, we can use the getter to obtain the piece color.
     *
     * @param pawn
     * @param xCoordinate represents the column of the chessboard, starting from 0
     * @param yCoordinate represents the row of the chessboard, starting from 0
     */
    public void add(Pawn pawn, int xCoordinate, int yCoordinate) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && (pieces[yCoordinate][xCoordinate] == null) && (countPawns(pawn.getPieceColor()) < BOARD_WIDTH)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setChessBoard(this);
            pieces[yCoordinate][xCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && (pieces[yCoordinate][xCoordinate] == null) && (countPawns(pieceColor) < BOARD_WIDTH)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setChessBoard(this);
            pieces[yCoordinate][xCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (((xCoordinate < 0) || (yCoordinate < 0)) || ((xCoordinate > BOARD_WIDTH - 1) || (yCoordinate > BOARD_HEIGHT - 1))) {
            return false;
        }
        return true;
    }

    public int countPawns(PieceColor color) {
        int counter = 0;
        for (Pawn[] row : pieces) {
            for (Pawn pawn : row) {
                if (pawn != null && pawn.getPieceColor() == color) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public Pawn[][] getPieces() {
        return pieces;
    }

    public Pawn getPawn(int x, int y) {
        return pieces[y][x];
    }

    public void printChessBoard() {
        System.out.println("");
        for (int i = 0; i < this.BOARD_WIDTH; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        int j = 0;
        for (Pawn[] row : pieces) {
            for (Pawn pawn : row) {
                if (pawn != null && pawn.getPieceColor() == PieceColor.BLACK) {
                    System.out.print("B ");
                } else if (pawn != null && pawn.getPieceColor() == PieceColor.WHITE) {
                    System.out.print("W ");
                } else System.out.print("- ");
            }
            System.out.println(" " + j++);
        }
    }
}
