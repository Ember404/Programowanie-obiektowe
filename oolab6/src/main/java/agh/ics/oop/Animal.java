package agh.ics.oop;

import java.util.ArrayList;

public class Animal {
    public MapDirection facing = MapDirection.NORTH;
    public Vector2d position = new Vector2d(-1,-1);
    public ArrayList<IPositionChangeObserver> observers= new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
            this.facing = MapDirection.NORTH;
            this.position = initialPosition;
    }

    public Animal( Vector2d initialPosition){
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

    public void positionChanged(Vector2d oldposition, Vector2d newposition){
        for (IPositionChangeObserver o : observers){
            o.PositionChanged(oldposition,newposition);
        }
    }

    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void move(MoveDirection direction, IWorldMap map) {
        Vector2d oldposition = new Vector2d(this.position.x,this.position.y);
        Vector2d p = new Vector2d(0, 0);
        switch (direction) {
            case LEFT -> {this.facing = this.facing.previous(); return;}
            case RIGHT -> {this.facing = this.facing.next(); return;}
            case FORWARD -> p = this.position.add(this.facing.toUnitVector());
            case BACKWARD -> p = this.position.add(this.facing.toUnitVector().oposite());
        }


        if (oldposition.x != p.x || oldposition.y != p.y ) {
            if (map.canMoveTo(p)) {
                this.position = new Vector2d(p.x,p.y);
                Vector2d newposition = new Vector2d(this.position.x,this.position.y);
                positionChanged(oldposition, newposition);

            }

        }


    }

}
