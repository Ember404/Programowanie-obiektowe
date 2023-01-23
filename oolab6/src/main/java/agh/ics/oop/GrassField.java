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

    Map<Vector2d, Animal> animals = new HashMap<>();
    Map<Vector2d, Grass> grasses = new HashMap<>();

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
       /* if (canMoveTo(animal.position)) {
            if (objectAt(animal.position)!=null){
                int flag=0;
                int i=-1;
                while (flag==0){
                    i+=1;
                    if(grasses.get(i).position==animal.position){
                        flag=1;
                    }
                }
                flag=0;
                int x;
                int y;
                double pom = grasses.size()*10;
                int granica = (int)Math.sqrt(pom);
                while (flag==0){
                    x=ThreadLocalRandom.current().nextInt(0, granica);
                    y=ThreadLocalRandom.current().nextInt(0, granica);
                    if (!isOccupied(new Vector2d(x,y))){
                        grasses.get(i).position.x=x;
                        grasses.get(i).position.y=y;
                        flag=1;
                    }
                }
            }
            else {
                animals.add(animal);
                return true;
            }
        }*/
        if (canMoveTo(animal.position)) {
            animals.put(animal.position,animal);
            return true;
        }
        return false;
    }

    public boolean place(Grass grass) {
        if (canMoveTo(grass.position)) {
            grasses.put(grass.position,grass);
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
        ////for (Animal animal: animals){
        //    area[animal.position.y][animal.position.x]=animal;
        // }

        double llx,lly,urx,ury;
        llx=Double.POSITIVE_INFINITY;
        urx=0;
        lly=Double.POSITIVE_INFINITY;
        ury=0;

        Set<Vector2d> kset = animals.keySet();
        ArrayList<Vector2d> pom =new ArrayList<>(kset) ;
        for (Vector2d v : pom){
            if (v.x<llx){
                llx=v.x;
            }
            if (v.x>urx){
                urx=v.x;
            }
            if (v.y<lly){
                lly=v.y;
            }
            if (v.y>ury){
                ury=v.y;
            }
        }

        Set<Vector2d> kset_g = grasses.keySet();
        ArrayList<Vector2d> pom_g =new ArrayList<>(kset_g) ;
        for (Vector2d v : pom_g){
            if (v.x<llx){
                llx=v.x;
            }
            if (v.x>urx){
                urx=v.x;
            }
            if (v.y<lly){
                lly=v.y;
            }
            if (v.y>ury){
                ury=v.y;
            }
        }
        MapVisualizer m= new MapVisualizer(this);

        return(m.draw(new Vector2d((int)llx,(int)lly),new Vector2d((int)urx, (int)ury)));
    }

    public void PositionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal pom = animals.remove(oldPosition);
        animals.put(newPosition,pom);
    }
}
