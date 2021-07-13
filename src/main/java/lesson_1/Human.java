package lesson_1;

public class Human implements OvercomingObstacles {

    private String name;
    private int distance;
    private int height;

    public Human(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean jump(Obstacle object) {
        return (this.height >= object.getHeight());
    }

    @Override
    public boolean run(Obstacle object) {
        return (this.distance >= object.getLength());
    }

    @Override
    public String toString() {
        return "Человек" +
                " " + name + " ";
    }

}
