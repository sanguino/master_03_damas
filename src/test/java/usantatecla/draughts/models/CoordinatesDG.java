package usantatecla.draughts.models;

public class CoordinatesDG {

    private Coordinate originCoordinate;
    private Coordinate targetCoordinate;

    public CoordinatesDG(Coordinate originCoordinate, Coordinate targetCoordinate) {
        this.originCoordinate = originCoordinate;
        this.targetCoordinate = targetCoordinate;
    }

    public Coordinate getOriginCoordinate() {
        return originCoordinate;
    }

    public Coordinate getTargetCoordinate() {
        return targetCoordinate;
    }

}
