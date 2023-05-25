package org.digitalstack.chess;

import static org.digitalstack.chess.PieceColor.*;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    /**
     * Prima data verificam daca coordonatele pe care le primim ca parametrii, sunt coordonate care  se afla pe tabla de joc.
     * Dupa care verificam daca pe pozitia coordonatelor primite se afla deja o piesa.
     * Daca nu se afla nicio piesa asezam pionul pe pozitia respectiva.
     * In caz ca se afla o piesa deja pe acea pozitie, le atribuim coordonatelor o valoare negativa astfel incat sa nu suprapunem
     * pionii ( sa nu asezam mai multi pioni pe aceeasi pozitie ).
     * De asemenea marcam pe tabla culoarea pionului adaugat.
     * @param pawn
     * @param xCoordinate
     * @param yCoordinate
     * @param pieceColor
     */
    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
            {
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[xCoordinate][yCoordinate] = pawn;

                if(pieceColor.equals(BLACK)){
                    pawn.setPieceColor(BLACK);
                }else{
                    pawn.setPieceColor(WHITE);
                }
            }
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    /**
     * Pentru a avea o pozitie legala pe tabla de sah, coordonatele trebuie sa fie strict pozitive si mai mici
     * sau egale cu 6.
     * @param xCoordinate
     * @param yCoordinate
     * @return
     */
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate < 0 || yCoordinate < 0 || xCoordinate > 6 || yCoordinate > 6){
            return false;
        }
        return true;
    }
}
