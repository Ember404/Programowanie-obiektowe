package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    public ArrayList<Animal> animals = new ArrayList<Animal>();
    public Object[][] area;
    public int h;
    public int w;

    public RectangularMap (int width, int height){
        this.h=height;
        this.w=width;
        this.area = new Object[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++)
                area[i][j]=null;
        }
    }

    public boolean canMoveTo(Vector2d position){
        if (position.y>0 && position.x>0 && position.y<h && position.x<w){
            if (area[position.y][position.x]==null) return true;}
        return false;
    }

    public boolean isOccupied(Vector2d position){
        if (position.y>0 && position.x>0 && position.y<h && position.x<w){
            if (area[position.y][position.x]==null) return false;}
        return true;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            animals.add(animal);
            area[animal.position.y][animal.position.x] = animal;
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        if (area[position.y][position.x]==null) return null;
        for (Animal animal : animals){
            if (animal.position.x==position.x && animal.position.y==position.y)
                return animal;
        }
        return null;
    };

    public String toString(){
        ////for (Animal animal: animals){
        //    area[animal.position.y][animal.position.x]=animal;
       // }
        int check;
        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                check=1;
                for (Animal animal:animals){
                    if (animal.position.x==j && animal.position.y==i)
                    {area[i][j]=animal;
                        check=0;}}
                if (check==1) {area[i][j]=null;}
            }
        }

        Vector2d ll= new Vector2d(0,0);
        Vector2d ur = new Vector2d(w-1,h-1);

        MapVisualizer m= new MapVisualizer(this);

        return(m.draw(ll,ur));
    }
}
