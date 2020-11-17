//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package usantatecla.draughts.models;

public class GameBuilder {
    private Game game;
    private Board board;

    public GameBuilder() {
        this.board = new Board();
        this.game = new Game(this.board);
    }


    public GameBuilder rows(String... rows) {
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for (int j = 0; j < row.length(); j++) {
                char color = row.charAt(j);
                if (color != ' ') {
                    Piece piece = Character.isLowerCase(color) ? new Pawn(this.getColor(color)) : new Draught(this.getColor(color));
                    this.board.put(new Coordinate(i, j), piece);
                }
            }
        }
        return this;
    }

    public static GameBuilder initialBoard() {
        return new GameBuilder().rows(
                " n n n n",
                "n n n n ",
                " n n n n",
                "        ",
                "        ",
                "b b b b ",
                " b b b b",
                "b b b b ");
    }

    private Color getColor(char color) {
        switch (color) {
            case 'b':
            case 'B':
                return Color.WHITE;
            case 'n':
            case 'N':
                return Color.BLACK;
            default:
                return null;
        }
    }

    public Game build() {
        return this.game;
    }
}
