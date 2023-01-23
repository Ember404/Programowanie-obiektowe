package agh.ics.oop;

public class SimulationEngine implements IEngine{
    MoveDirection[] moves;
    RectangularMap map;
    Vector2d[] positions;
    public SimulationEngine(MoveDirection[] moves_p,RectangularMap map_p, Vector2d[] positions_p){
        this.moves=moves_p;
        this.map=map_p;
        this.positions=positions_p;

    }

    @Override
    public void run() {
        for (Vector2d position : positions){
            Animal a = new Animal(map,position);
            map.place(a);
        }

        int animals_amount=map.animals.size();
        int len=moves.length;

        int licznik;
        for (int i=0;i<len;i++){
            licznik=i%animals_amount;
            Animal pom =map.animals.get(licznik);
            pom.move(moves[i],map);
        }
    }
}
