package usantatecla.draughts.models;

public class OppositePieceChecker extends PairMoveChecker {

    public OppositePieceChecker(Board board, Turn turn) {
        super(board, turn);
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {
        if (this.turn.getOppositeColor() == this.board.getColor(coordinates[pair]))
            return Error.OPPOSITE_PIECE;
        return checkNext(pair, coordinates);
    }
}
