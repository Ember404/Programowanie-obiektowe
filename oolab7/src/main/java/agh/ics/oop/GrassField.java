package agh.ics.oop;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    Map<Vector2d, Grass> grasses = new HashMap<>();
    MapBoundary b = new MapBoundary();

    public GrassField (int n) {

        int x;
        int y;
        double pom = n*10;
        int granica = (int)Math.sqrt(pom);
        int licznik=0;
        while (licznik<n){
            x=ThreadLocalRandom.current().nextInt(0, granica);
            y=ThreadLocalRandom.current().nextInt(0, granica);

            if (!isOccupied(new Vector2d(x,y))){
                grasses.put(new Vector2d(x,y),new Grass(new Vector2d(x,y)));
                licznik=licznik+1;
                b.add(new Grass(new Vector2d(x,y)));
            }
        }

    }
    public boolean canMoveTo(Vector2d position){
        if (animals.get(position)!=null){
            return false;
        }
        return true;
    }

    public boolean isOccupied(Vector2d position){
        if (objectAt(position)!=null) {
            return true;
        }
        return false;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            animals.put(animal.position,animal);
            b.add(animal);
            return true;
        }
        throw new IllegalArgumentException(animal.position.toString());
    }

    public boolean place(Grass grass) {
        if (canMoveTo(grass.position)) {
            grasses.put(grass.position,grass);
            b.add(grass);
            return true;
        }
        return false;
    }


    public Object objectAt(Vector2d position){
        if (animals.get(position)!=null){
            return animals.get(position);
        }
        else return grasses.get(position);
    };

    public String toString(){

        int llx=b.x.get(0).position.x;
        int urx=b.x.get(b.x.size()-1).position.x;
        int  lly=b.y.get(0).position.y;
        int ury=b.y.get(b.y.size()-1).position.y;
        MapVisualizer m = new MapVisualizer(this);

        return(m.draw(new Vector2d((int)llx,(int)lly),new Vector2d((int)urx, (int)ury)));
    }

    public void PositionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal pom = animals.remove(oldPosition);
        animals.put(newPosition,pom);
    }
}
