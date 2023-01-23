package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class RectangularMap extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    public int h;
    public int w;

    public RectangularMap (int width, int height){
        this.h=height;
        this.w=width;

    }

    public Object objectAt(Vector2d position){
        if (animals.get(position)!=null){
            return animals.get(position);
        }
        else return null;
    };

    public boolean canMoveTo(Vector2d position){
        if (animals.get(position)!=null){
            return false;
        }
        else if (position.x<0 || position.y<0 || position.x>w ||position.y>h){
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
            return true;
        }
        return false;
    }

    public String toString(){
        ////for (Animal animal: animals){
        //    area[animal.position.y][animal.position.x]=animal;
       // }

        Vector2d ll= new Vector2d(0,0);
        Vector2d ur = new Vector2d(w-1,h-1);

        MapVisualizer m= new MapVisualizer(this);

        return(m.draw(ll,ur));
    }

    public void PositionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal rufus = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,rufus);
    }

}
