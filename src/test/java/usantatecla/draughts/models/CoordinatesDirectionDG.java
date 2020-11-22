package usantatecla.draughts.models;

public class CoordinatesDirectionDG {

    private CoordinatesDG coordinates;
    private Direction direction;

    public CoordinatesDirectionDG(Coordinate originCoordinate, Coordinate targetCoordinate, Direction direction) {
        this.coordinates = new CoordinatesDG(originCoordinate, targetCoordinate);
        this.direction = direction;
    }

    public CoordinatesDG getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }
}
