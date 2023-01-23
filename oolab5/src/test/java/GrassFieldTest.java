import agh.ics.oop.Animal;
import agh.ics.oop.GrassField;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {

    Vector2d v = new Vector2d(1,2);
    GrassField m = new GrassField(8);
    Animal rufus = new Animal(m,v);

    @Test
    public void amountOfGrass(){
        assert m.grasses.size()==8;
    }

    @Test
    public void isOccupiedTest(){
        m.place(rufus);
        assert m.isOccupied(v);

    }

    @Test
    public void CanMoveToTest(){
        m.place(rufus);
        assert m.canMoveTo(new Vector2d(2,3))  && !(m.canMoveTo(v)) && m.canMoveTo(new Vector2d(1324123,123551));

    }

    @Test
    public void objectAtTest(){
        m.place(rufus);
        assert m.objectAt(v)==rufus;
    }

}
