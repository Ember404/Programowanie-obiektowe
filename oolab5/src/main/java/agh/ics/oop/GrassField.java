package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    //public ArrayList<Animal> animals = new ArrayList<>();
    public ArrayList<Grass> grasses = new ArrayList<>();

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
                grasses.add(new Grass(new Vector2d(x,y)));
                licznik=licznik+1;
            }
        }

    }
    public boolean canMoveTo(Vector2d position){
        for (Animal animal : animals){
            if (animal.position.x==position.x && animal.position.y==position.y)
                return false;
        }
        return true;
    }

    public boolean isOccupied(Vector2d position){
        for (Animal animal : animals){
            if (animal.position.x==position.x && animal.position.y==position.y)
                return true;
        }
        for (Grass grass : grasses){
            if (grass.position.x==position.x && grass.position.y==position.y)
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
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean place(Grass grass) {
        if (canMoveTo(grass.position)) {
            grasses.add(grass);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for (Animal animal : animals){
            if (animal.position.x==position.x && animal.position.y==position.y)
                return animal;
        }
        for (Grass grass : grasses){
            if (grass.position.x==position.x && grass.position.y==position.y)
                return grass;
        }
        return null;
    };

    public String toString(){
        ////for (Animal animal: animals){
        //    area[animal.position.y][animal.position.x]=animal;
        // }

        int llx,lly,urx,ury;
        llx=animals.get(0).position.x;
        urx=animals.get(0).position.x;
        lly=animals.get(0).position.y;
        ury=animals.get(0).position.y;

        for (Animal animal : animals){
            if (animal.position.x<llx){
                llx=animal.position.x;
            }
            if (animal.position.x>urx){
                urx=animal.position.x;
            }
            if (animal.position.y<lly){
                lly=animal.position.y;
            }
            if (animal.position.y>ury){
                ury=animal.position.y;
            }
        }

        for (Grass grass : grasses){
            if (grass.position.x<llx){
                llx=grass.position.x;
            }
            if (grass.position.x>urx){
                urx=grass.position.x;
            }
            if (grass.position.y<lly){
                lly=grass.position.y;
            }
            if (grass.position.y>ury){
                ury=grass.position.y;
            }
        }


        MapVisualizer m= new MapVisualizer(this);

        return(m.draw(new Vector2d(llx,lly),new Vector2d(urx,ury)));
    }
}
