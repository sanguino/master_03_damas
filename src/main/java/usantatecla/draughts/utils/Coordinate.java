package usantatecla.draughts.utils;

public class Coordinate {

	protected int row;

	protected int column;

	protected Coordinate() {
	}

	protected Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	protected usantatecla.draughts.models.Coordinate substract(usantatecla.draughts.models.Coordinate coordinate) {
		return new usantatecla.draughts.models.Coordinate(this.row - coordinate.row, this.column - coordinate.column);
	}

	protected usantatecla.draughts.models.Coordinate plus(usantatecla.draughts.models.Coordinate coordinate) {
		return new usantatecla.draughts.models.Coordinate(this.row + coordinate.row, this.column + coordinate.column);
	}

	public boolean isBlack() {
		return (this.row + this.column) % 2 != 0;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
