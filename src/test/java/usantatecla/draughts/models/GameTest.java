package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game getBaseErrorGame () {
        return new GameBuilder().rows(
                "        ",
                "  n n   ",
                "        ",
                "        ",
                "   b    ",
                "    b   ",
                "        ",
                "        ").build();
    }
    @Test
    public void givenBoardWhenMoveThenErrorEmptyOrigin () {
        Error error = this.getBaseErrorGame().move(new Coordinate(2,2),new Coordinate(2,2));
        assertEquals(error, Error.EMPTY_ORIGIN);
    }

    @Test
    public void givenBoardWhenMoveThenErrorOppositePiece () {
        Error error = this.getBaseErrorGame().move(new Coordinate(1,2),new Coordinate(2,2));
        assertEquals(error, Error.OPPOSITE_PIECE);
    }

    @Test
    public void givenBoardWhenMoveThenErrorNonDiagonal () {
        Error error = this.getBaseErrorGame().move(new Coordinate(5,4),new Coordinate(5,5));
        assertEquals(error, Error.NOT_DIAGONAL);
    }

    @Test
    public void givenBoardWhenMoveThenErrorNotEmptyTarget () {
        Error error = this.getBaseErrorGame().move(new Coordinate(5,4),new Coordinate(4,3));
        assertEquals(error, Error.NOT_EMPTY_TARGET);
    }

    @Test
    public void givenBoardWhenMoveThenErrorNonAdvanced () {
        Error error = this.getBaseErrorGame().move(new Coordinate(5,4),new Coordinate(6,3));
        assertEquals(error, Error.NOT_ADVANCED);
    }

    @Test
    public void givenBoardWhenMoveThenCompareOk () {
        Game origin = new GameBuilder().rows(
                "        ",
                "  n n   ",
                "        ",
                "        ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build();

        origin.move(new Coordinate(5,4),new Coordinate(4,3));

        Game destination = new GameBuilder().rows(
                "        ",
                "  n n   ",
                "        ",
                "        ",
                "   b    ",
                "  b     ",
                "        ",
                "        ").build();

        this.checkGames(origin, destination);
    }

    @Test
    public void givenBoardWhenEatenAPieceThenCompareOk () {
        Game origin = new GameBuilder().rows(
                "        ",
                "        ",
                "  n n   ",
                "   b    ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build();

        origin.move(new Coordinate(3,3),new Coordinate(1,1));

        Game destination = new GameBuilder().rows(
                "        ",
                " b      ",
                "    n   ",
                "        ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build();

        this.checkGames(origin, destination);
    }

    @Test
    public void givenBoardWhenMoveToEndThenCreatesDraught () {
        Game origin = new GameBuilder().rows(
                "        ",
                "  n n  b",
                "        ",
                "        ",
                "        ",
                "  b     ",
                "        ",
                "        ").build();

        origin.move(new Coordinate(1,7),new Coordinate(0,6));

        Game destination = new GameBuilder().rows(
                "      B ",
                "  n n   ",
                "        ",
                "        ",
                "        ",
                "  b     ",
                "        ",
                "        ").build();

        this.checkGames(origin, destination);
    }

    @Test
    public void givenBoardWhenEatenAPieceAndGetEndThenCompareOk () {
        Game origin = new GameBuilder().rows(
                "        ",
                "  n n   ",
                "   b    ",
                "        ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build();

        origin.move(new Coordinate(2,3),new Coordinate(0,1));

        Game destination = new GameBuilder().rows(
                " B      ",
                "    n   ",
                "        ",
                "        ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build();

        this.checkGames(origin, destination);
    }

    @Test
    public void givenBoardWhenMoveDraughtThenCompareOk () {
        Game origin = new GameBuilder().rows(
                "      B ",
                "  n n   ",
                "        ",
                "        ",
                "        ",
                "  b     ",
                "        ",
                "        ").build();

        origin.move(new Coordinate(0,6),new Coordinate(5,1));

        Game destination = new GameBuilder().rows(
                "        ",
                "  n n   ",
                "        ",
                "        ",
                "        ",
                " Bb     ",
                "        ",
                "        ").build();

        this.checkGames(origin, destination);
    }

    void checkGames(Game origin, Game destination) {
        for (int i = 0; i < origin.getDimension(); i++) {
            for (int j = 0; j < origin.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Piece p1 = origin.getPiece(coordinate);
                Piece p2 = destination.getPiece(coordinate);
                if (p1 != null && p2 != null) {
                    assertEquals(p1.getCode(), p2.getCode());
                }
                else if (p1 == null ^ p2 == null) {
                    fail();
                }

            }
        }
    }

    @Test
    public void givenBoardWhenIsBlockedThenReturnsFalse () {
        assertFalse(new GameBuilder().rows(
                "        ",
                "  n n   ",
                "        ",
                "        ",
                "        ",
                "  b b   ",
                "        ",
                "        ").build().isBlocked()
        );
    }

    @Test
    public void givenBoardWhenIsBlockedThenReturnsTrue () {
        assertTrue(new GameBuilder().rows(
                "        ",
                "  n   n ",
                "   n n  ",
                "    b   ",
                "        ",
                "        ",
                "        ",
                "        ").build().isBlocked()
        );
    }
}
