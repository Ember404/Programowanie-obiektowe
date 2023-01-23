package agh.ics.oop;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;



public class MapBoundary implements IPositionChangeObserver{
    ArrayList<AbstractObject> x= new ArrayList<>();
    ArrayList<AbstractObject> y= new ArrayList<>();
    public void PositionChanged(Vector2d oldPosition, Vector2d newPosition){
        Collections.sort(x,new compx());
        Collections.sort(y,new compy());

    }

    public class compx implements Comparator<AbstractObject>{
        public int compare(AbstractObject a,AbstractObject b){
            if (a.position.x>b.position.x){
                return 1;
            }
            if (b.position.x>a.position.x){
                return -1;
            }
            if (a instanceof Animal){
                return 1;
            }
            if (b instanceof Animal){
                return -1;
            }
            return 0;

        };
    }

    public class compy implements Comparator<AbstractObject>{
        public int compare(AbstractObject a,AbstractObject b){
            if (a.position.y>b.position.y){
                return 1;
            }
            if (b.position.y>a.position.y){
                return -1;
            }
            if (a instanceof Animal){
                return 1;
            }
            if (b instanceof Animal){
                return -1;
            }
            return 0;

        };
    }

    public void add(AbstractObject o){
        x.add(o);
        Collections.sort(x,new compx());
        y.add(o);
        Collections.sort(y,new compy());
    }
}
