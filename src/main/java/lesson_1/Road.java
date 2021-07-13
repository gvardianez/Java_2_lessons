package lesson_1;

public class Road extends Obstacle {
    private int length;

    public Road(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isAcross(OvercomingObstacles object) {
        return object.run(this);
    }
}
