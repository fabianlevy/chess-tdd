package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public Pawn[][] getPieces() {
        return pieces;
    }


    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(isLegalBoardPosition(xCoordinate, yCoordinate)&&pieces[xCoordinate][yCoordinate]==null){
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
            System.out.println(pawn.getXCoordinate());
                pieces[xCoordinate][yCoordinate]=pawn;
                System.out.println("Added pawn of color "+pieceColor+" to position ("+xCoordinate+","+yCoordinate+")");
        }
        else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            System.out.println("Can't add pawn");
        }
//        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate>=0&&xCoordinate<BOARD_WIDTH&&yCoordinate>=0&&yCoordinate<=BOARD_HEIGHT)
        {
           return true;
        }
        else{
            return false;
        }
    }
}
