package agh.ics.oop;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){

        return("("+x+","+y+")");
    }

    public boolean precedes(Vector2d other){
        if (this.x<=other.x) {
            if (this.y <= other.y) {
                return true;
            }
        }
        return false;
    }

    boolean follows(Vector2d other){
        if (this.x>=other.x) {
            if (this.y >= other.y) {
                return true;
            }
        }
        return false;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x,this.y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int a;
        int b;
        if (this.x>=other.x)
            a=this.x;
        else
            a=other.x;

        if (this.y>=other.y)
            b=this.y;
        else
            b=other.y;
        return new Vector2d(a,b);
    }
    public Vector2d lowerLeft(Vector2d other){
        int a;
        int b;
        if (this.x<=other.x)
            a=this.x;
        else
            a=other.x;

        if (this.y<=other.y)
            b=this.y;
        else
            b=other.y;
        return new Vector2d(a,b);
    }

    public Vector2d oposite(){
        return new Vector2d(this.x*(-1),this.y*(-1));
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        // tutaj przeprowadzane jest faktyczne porównanie
        if (this.x==that.x)
            if (this.y==that.y)
                return true;
        return false;
    }
}
