package org.digitalstack.chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class PawnTest2 {

    private ChessBoard chessBoard;
    private Pawn testSubjectB;
    private Pawn testSubjectW;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubjectB = new Pawn(PieceColor.BLACK);
        this.testSubjectW = new Pawn(PieceColor.WHITE);
    }

    @Test
    public void testChessBoard_AddB_Sets_XYCoordinate() {
        this.chessBoard.add(testSubjectB, 3, 2, PieceColor.BLACK);
        assertEquals(3, testSubjectB.getXCoordinate());
        assertEquals(2, testSubjectB.getYCoordinate());
    }

    @Test
    public void testChessBoard_AddW_Sets_XYCoordinate() {
        this.chessBoard.add(testSubjectW, 4, 3, PieceColor.WHITE);
        assertEquals(4, testSubjectW.getXCoordinate());
        assertEquals(3, testSubjectW.getYCoordinate());
    }



    @Test
    public void testPawn_Capture_LegalCoordinates_Black1_UpdatesCoordinates() {
        this.chessBoard.add(testSubjectW, 3, 2, PieceColor.WHITE);
        this.chessBoard.add(testSubjectB, 4, 3, PieceColor.BLACK);
        this.chessBoard.printChessBoard();
        testSubjectB.move(MovementType.CAPTURE, 3, 2);
        assertEquals(3, testSubjectW.getXCoordinate());
        assertEquals(2, testSubjectW.getYCoordinate());
        this.chessBoard.printChessBoard();
    }

    @Test
    public void testPawn_Capture_LegalCoordinates_White1_UpdatesCoordinates() {
        this.chessBoard.add(testSubjectW, 3, 2, PieceColor.WHITE);
        this.chessBoard.add(testSubjectB, 4, 3, PieceColor.BLACK);
        this.chessBoard.printChessBoard();
        testSubjectW.move(MovementType.CAPTURE, 4, 3);
        assertEquals(4, testSubjectB.getXCoordinate());
        assertEquals(3, testSubjectB.getYCoordinate());
        this.chessBoard.printChessBoard();
    }

    @Test
    public void testPawn_Capture_LegalCoordinates_Black2_UpdatesCoordinates() {
        this.chessBoard.add(testSubjectW, 5, 2, PieceColor.WHITE);
        this.chessBoard.add(testSubjectB, 4, 3, PieceColor.BLACK);
        this.chessBoard.printChessBoard();
        testSubjectB.move(MovementType.CAPTURE, 5, 2);
        assertEquals(5, testSubjectW.getXCoordinate());
        assertEquals(2, testSubjectW.getYCoordinate());
        this.chessBoard.printChessBoard();
    }

    @Test
    public void testPawn_Capture_LegalCoordinates_White2_UpdatesCoordinates() {
        this.chessBoard.add(testSubjectW, 5, 2, PieceColor.WHITE);
        this.chessBoard.add(testSubjectB, 4, 3, PieceColor.BLACK);
        this.chessBoard.printChessBoard();
        testSubjectW.move(MovementType.CAPTURE, 4, 3);
        assertEquals(4, testSubjectB.getXCoordinate());
        assertEquals(3, testSubjectB.getYCoordinate());
        this.chessBoard.printChessBoard();
    }
}