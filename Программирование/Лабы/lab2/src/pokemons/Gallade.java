package pokemons;

import ru.ifmo.se.pokemon.Type;
import moves.BulkUp;

public final class Gallade extends Kirlia {
    public Gallade(String name, int level){
        super(name, level);
        super.setType(Type.FIGHTING, Type.PSYCHIC);
        super.setStats(68, 125, 65, 65, 115, 80);

        BulkUp bulkUp = new BulkUp();
        super.addMove(bulkUp);
}}
