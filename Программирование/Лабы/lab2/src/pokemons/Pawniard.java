package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.Facade;
import moves.RockPolish;
import moves.RockTomb;
import moves.StoneEdge;

public class Pawniard extends Pokemon {
    public Pawniard(String name, int level){
        super(name, level);
        super.setType(Type.DARK, Type.STEEL);
        super.setStats(45, 85, 70, 40, 40, 60);

        Facade facade = new Facade();
        RockPolish rockPolish = new RockPolish();
        RockTomb rockTomb = new RockTomb();
        StoneEdge stoneEdge = new StoneEdge();

        super.setMove(facade, rockPolish, rockTomb, stoneEdge);
    }
}
