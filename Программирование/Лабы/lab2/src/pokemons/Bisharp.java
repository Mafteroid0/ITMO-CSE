package pokemons;

import moves.StoneEdge;
import ru.ifmo.se.pokemon.Type;


public final class Bisharp extends Pawniard {
    public Bisharp(String name, int level){
        super(name, level);
        super.setType(Type.DARK, Type.STEEL);
        super.setStats(65, 125, 100, 60, 70, 70);

        StoneEdge stoneEdge = new StoneEdge();

        super.addMove(stoneEdge);

    }
}
