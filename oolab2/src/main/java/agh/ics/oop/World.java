package agh.ics.oop;

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
        String[] moves = new String[] {"l", "r", "b","f"};
        System.out.println("System wystartował");
        conv(moves);
        //metoda run jest wywoływana w funkcji conv
        System.out.println("System zakończył działanie");
    }
}
