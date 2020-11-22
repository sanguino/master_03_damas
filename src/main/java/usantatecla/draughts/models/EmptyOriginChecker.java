package usantatecla.draughts.models;

public class EmptyOriginChecker extends PairMoveChecker {

    public EmptyOriginChecker(Board board, Turn turn) {
        super(board, turn);
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {
        if (board.isEmpty(coordinates[pair]))
            return Error.EMPTY_ORIGIN;
        return checkNext(pair, coordinates);
    }
}
