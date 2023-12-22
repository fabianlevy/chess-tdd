package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    private boolean isOpponentPieceAt(int x, int y) {
        //check if a specific square on the chessboard is occupied by an opponent's piece
        Pawn piece = chessBoard.getPieceAt(x, y);
        return piece != null && piece.getPieceColor() != this.pieceColor;
    }

    public void move(MovementType movementType, int newX, int newY) {

        if (!chessBoard.isLegalBoardPosition(newX, newY)) {return;}
        int yDirection = (pieceColor == PieceColor.WHITE) ? 1 : -1; //set the direction in which the pawn should move
        //handle standard pawn movement
        if (movementType == MovementType.MOVE) {
            boolean isOneStepMove = (newY - yCoordinate == yDirection) && newX == xCoordinate;
            if (isOneStepMove) {
                setYCoordinate(newY);
                setXCoordinate(newX);}
        }//then, handle pawns capture
        else if (movementType == MovementType.CAPTURE) {
            boolean isDiagonalCapture = Math.abs(newX - xCoordinate) == 1 && newY - yCoordinate == yDirection;
            if (isDiagonalCapture && isOpponentPieceAt(newX, newY)) {
                setXCoordinate(newX);
                setYCoordinate(newY);
        }
    }
}

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
