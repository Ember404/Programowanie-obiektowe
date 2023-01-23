package agh.ics.oop;

public class Grass extends AbstractObject{
    //public Vector2d position;
    public Grass(Vector2d p){
        this.position=p;
    }
    public String toString(){
        return("*");
    }
}
