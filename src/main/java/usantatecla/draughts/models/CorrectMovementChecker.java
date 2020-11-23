package usantatecla.draughts.models;

import java.util.List;

public class CorrectMovementChecker extends PairMoveChecker {

    public CorrectMovementChecker(Board board, Turn turn) {
        super(board, turn);
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {

        List<Piece> betweenDiagonalPieces = this.board.getBetweenDiagonalPieces(coordinates[pair], coordinates[pair + 1]);
        Error error = this.board.getPiece(coordinates[pair]).isCorrectMovement(betweenDiagonalPieces, pair, coordinates);

        if (error != null)
            return error;

        return checkNext(pair, coordinates);
    }
}
