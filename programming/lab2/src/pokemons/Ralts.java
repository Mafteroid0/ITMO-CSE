package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.Facade;
import moves.ShadowBall;

public class Ralts  extends Pokemon {
    public Ralts(String name, int level){
        super(name, level);
        super.setType(Type.FAIRY, Type.PSYCHIC);
        super.setStats(28, 25, 25, 45, 35, 40);

        Facade facade = new Facade();
        ShadowBall shadowBall = new ShadowBall();
        super.setMove(facade, shadowBall);
}}
