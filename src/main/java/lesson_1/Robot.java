package lesson_1;

public class Robot implements OvercomingObstacles{
    private String model;
    private int distance;
    private int height;

    public Robot(String model, int distance, int height) {
        this.model = model;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean jump(Obstacle object) {
        return (this.height>=object.getHeight());
    }

    @Override
    public boolean run(Obstacle object) {
        return (this.distance>=object.getLength());
    }

    @Override
    public String toString() {
        return "Робот " +
                "model = '" + model + '\'';
    }


}
