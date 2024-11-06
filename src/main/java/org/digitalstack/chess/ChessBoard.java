package org.digitalstack.chess;

import java.util.Arrays;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add( Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor ) {
        // Verificam daca pozitia pionului e valida
        if ( isLegalBoardPosition( xCoordinate, yCoordinate ) ) {
            // Verificam daca pozitia e ocupata
            if ( pieces[xCoordinate][yCoordinate] != null ) {

                pawn.setXCoordinate( -1 );
                pawn.setYCoordinate( -1 );
                return;
            }

            // Daca pozitia e libera punem pionul la coordonatele x,y
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setXCoordinate( xCoordinate );
            pawn.setYCoordinate( yCoordinate );
        } else {
            pawn.setXCoordinate( -1 );
            pawn.setYCoordinate( -1 );
        }
    }

    public boolean isLegalBoardPosition( int xCoordinate, int yCoordinate ) {
        if ( xCoordinate < 0 || yCoordinate < 0 || xCoordinate > 6 || yCoordinate > 6 ) {
            return false;
        }
        return true;
    }
}
