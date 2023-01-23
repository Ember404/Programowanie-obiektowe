package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] tab){

        int i = 0;
        for (String x : tab){
            switch (x){
                case "f" -> i=i+1;
                case "forward" -> i=i+1;
                case "b" -> i=i+1;
                case "backward" -> i=i+1;
                case "r" -> i=i+1;
                case "right" -> i=i+1;
                case "l" -> i=i+1;
                case "left" -> i=i+1;
                default -> i=i+0;
            }
        }

        MoveDirection[] result = new MoveDirection[i];

        for (int j=0;j<i;j++){
            switch (tab[j]){
                case "f" -> result[j]=MoveDirection.FORWARD;
                case "forward" -> result[j]=MoveDirection.FORWARD;
                case "b" -> result[j]=MoveDirection.BACKWARD;
                case "backward" -> result[j]=MoveDirection.BACKWARD;
                case "r" -> result[j]=MoveDirection.RIGHT;
                case "right" -> result[j]=MoveDirection.RIGHT;
                case "l" -> result[j]=MoveDirection.LEFT;
                case "left" -> result[j]=MoveDirection.LEFT;
                default -> j=j;
            }
        }
        return result;
    }
}
