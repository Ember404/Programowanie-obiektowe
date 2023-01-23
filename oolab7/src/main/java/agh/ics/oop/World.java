package agh.ics.oop;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

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
        Application.launch(App.class, args);
        try {
            OptionsParser p = new OptionsParser();
            String tab[]={"f","b","left","a"};
            p.parse(tab);

        } catch (IllegalArgumentException e){
            System.out.println(e + " is pretty illegal move specification");
        }

        try {

            GrassField g = new GrassField(7);
            g.place(new Animal(new Vector2d(1,2)));
            //System.out.println(g.toString());
            g.place(new Animal(new Vector2d(1,2)));

        } catch (IllegalArgumentException e){
            System.out.println(e + " is already occupied");
        }

        //System.out.println(map.isOccupied(new Vector2d(3,0)));
    }
}
