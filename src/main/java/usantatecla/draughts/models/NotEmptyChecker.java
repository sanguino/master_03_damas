package usantatecla.draughts.models;

public class NotEmptyChecker extends PairMoveChecker {

    public NotEmptyChecker(Board board, Turn turn) {
        super(board, turn);
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {
        if (!this.board.isEmpty(coordinates[pair + 1]))
            return Error.NOT_EMPTY_TARGET;
        return checkNext(pair, coordinates);
    }
}
