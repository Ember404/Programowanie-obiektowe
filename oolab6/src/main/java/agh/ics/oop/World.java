package agh.ics.oop;
import java.util.Scanner;

public class World {
    public static void conv(String[] moves){
        Direction[] pom = new Direction[moves.length];
        for (int i=0;i< (moves.length);i++){
            switch(moves[i]){
                case "f":
                    pom[i]=Direction.FORWARD;
                    break;
                case "b":
                    pom[i]=Direction.BACKWARD;
                    break;
                case "r":
                    pom[i]=Direction.RIGHT;
                    break;
                case "l":
                    pom[i]=Direction.LEFT;
                    break;
            }
        }
        run(pom);
    }


    public static void run(Direction[] moves){
        for (int i=0;i< (moves.length);i++){
            switch(moves[i]){
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        Vector2d v = new Vector2d(3,5);
        GrassField map = new GrassField(5);
        //map.grasses.put(v,new Grass(v));
        System.out.println(map.grasses);
        Animal rufus= new Animal(new Vector2d(3,2));

        map.place(rufus);
        rufus.addObserver(map);

        System.out.println(map.toString());
        ;
        rufus.move(MoveDirection.RIGHT,map);
        rufus.move(MoveDirection.FORWARD,map);

        System.out.println(map.animals.toString());


        //System.out.println(map.isOccupied(new Vector2d(3,0)));
    }
}
