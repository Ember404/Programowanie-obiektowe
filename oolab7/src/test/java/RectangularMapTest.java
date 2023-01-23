import agh.ics.oop.Animal;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    Vector2d v = new Vector2d(1,2);
    RectangularMap m = new RectangularMap(3,4);
    Animal rufus = new Animal(m,v);

    @Test
    public void isOccupiedTest(){
        m.place(rufus);
        assert m.isOccupied(v);

    }

    @Test
    public void CanMoveToTest(){
        m.place(rufus);
        assert m.canMoveTo(new Vector2d(2,3)) && ! m.canMoveTo(v) && ! m.canMoveTo(new Vector2d(10,12345));

    }

    @Test
    public void objectAtTest(){
        m.place(rufus);
        assert m.objectAt(v)==rufus;
    }


}
