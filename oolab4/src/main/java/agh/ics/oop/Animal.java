package agh.ics.oop;

public class Animal {
    public MapDirection facing = MapDirection.NORTH;
    public Vector2d position = new Vector2d(2,2);

    public String toString(){
        return("Position: "+position.toString()+", Direction: "+facing);
    }

    public boolean isAt(Vector2d position){
        if (this.position.x==position.x)
            if (this.position.y==position.y)
                return true;
        return false;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.facing=this.facing.previous();
            case RIGHT -> this.facing=this.facing.next();
            case FORWARD -> this.position=this.position.add(this.facing.toUnitVector());
            case BACKWARD -> this.position=this.position.add(this.facing.toUnitVector().oposite());
        }
        if (this.position.x>4)
            this.position.x=4;
        if (this.position.y>4)
            this.position.y=4;
        if (this.position.x<0)
            this.position.x=0;
        if (this.position.y<0)
            this.position.y=0;
    }
}
