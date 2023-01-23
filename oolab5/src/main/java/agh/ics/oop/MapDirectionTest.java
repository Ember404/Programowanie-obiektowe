package agh.ics.oop;

public class MapDirectionTest {
    public static boolean next_test(){
        if (MapDirection.NORTH.next()==MapDirection.EAST)
            if (MapDirection.EAST.next()==MapDirection.SOUTH)
                if (MapDirection.SOUTH.next()==MapDirection.WEST)
                    if (MapDirection.WEST.next()==MapDirection.NORTH)
                        return true;
        return false;
    }
    public static boolean prev_test(){
        if (MapDirection.NORTH.previous()==MapDirection.WEST)
            if (MapDirection.EAST.previous()==MapDirection.NORTH)
                if (MapDirection.SOUTH.previous()==MapDirection.EAST)
                    if (MapDirection.WEST.previous()==MapDirection.SOUTH)
                        return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println("Poprawność next: "+next_test()+", Poprawność previous: "+prev_test());

    }

}
