package lesson_1;

import java.util.ArrayList;
import java.util.List;

public class HomeWork1 {

    public static void main(String[] args) {
        List<OvercomingObstacles> members = new ArrayList<>();
        members.add(new Cat("Murka", 200, 2));
        members.add(new Human("Vasya", 1000, 20));
        members.add(new Robot("RD2", 2500, 100));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Road(100));
        obstacles.add(new Road(2000));
        obstacles.add(new Wall(15));
        obstacles.add(new Wall(50));

        for (OvercomingObstacles member : members) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle.isAcross(member)) {
                    System.out.println(member + "преодолевает препятствие, пробует дальше");
                } else {
                    System.out.println(member + "не преодолел препятствие, дальше не пробует");
                    break;
                }
            }
        }

        //          Консоль
//        Кошка по имени = 'Murka'преодолевает препятствие, пробует дальше
//        Кошка по имени = 'Murka'не преодолел препятствие, дальше не пробует
//        Человек Vasya преодолевает препятствие, пробует дальше
//        Человек Vasya не преодолел препятствие, дальше не пробует
//        Робот model = 'RD2'преодолевает препятствие, пробует дальше
//        Робот model = 'RD2'преодолевает препятствие, пробует дальше
//        Робот model = 'RD2'преодолевает препятствие, пробует дальше
//        Робот model = 'RD2'преодолевает препятствие, пробует дальше

    }

}
