package usantatecla.draughts.models;

public abstract class PairMoveChecker {
    protected PairMoveChecker next;
    protected Board board;
    protected Turn turn;

    public PairMoveChecker(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
    }

    public PairMoveChecker linkWith(PairMoveChecker next) {
        this.next = next;
        return next;
    }

    public abstract Error check(int pair, Coordinate... coordinates);

    protected Error checkNext(int pair, Coordinate... coordinates) {
        if (next == null) {
            return null;
        }
        return next.check(pair, coordinates);
    }

}
