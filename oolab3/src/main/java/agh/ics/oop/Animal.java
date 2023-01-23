package agh.ics.oop;

public class Animal {
    public MapDirection facing = MapDirection.NORTH;
    public Vector2d position = new Vector2d(-1,-1);


    public Animal(IWorldMap map, Vector2d initialPosition){
            this.facing = MapDirection.NORTH;
            this.position = initialPosition;

    }

    public String toString(){
        String s="";
        switch (facing){
            case NORTH -> s= ("^");
            case EAST -> s=(">");
            case WEST -> s=("<");
            case SOUTH -> s=("V");
        }
        return s;
    }

    public boolean isAt(Vector2d position){
        if (this.position.x==position.x)
            if (this.position.y==position.y)
                return true;
        return false;
    }

    public void move(MoveDirection direction, IWorldMap map){
        Vector2d p = new Vector2d(0,0);
        switch (direction){
            case LEFT -> this.facing=this.facing.previous();
            case RIGHT -> this.facing=this.facing.next();
            case FORWARD -> p=this.position.add(this.facing.toUnitVector());
            case BACKWARD -> p=this.position.add(this.facing.toUnitVector().oposite());
        }
        if (map.canMoveTo(p)){
            this.position=p;
        }

    }
}
