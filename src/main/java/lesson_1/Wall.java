package lesson_1;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isAcross(OvercomingObstacles object) {
        return object.jump(this);
    }
}
