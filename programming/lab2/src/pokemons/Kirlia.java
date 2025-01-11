package pokemons;

import ru.ifmo.se.pokemon.Type;
import moves.Growl;

public class Kirlia extends Ralts {
    public Kirlia(String name, int level){
        super(name, level);
        super.setType(Type.FAIRY, Type.PSYCHIC);
        super.setStats(38, 35, 35, 65, 55, 50);

        Growl growl = new Growl();
        super.addMove(growl);
}}
