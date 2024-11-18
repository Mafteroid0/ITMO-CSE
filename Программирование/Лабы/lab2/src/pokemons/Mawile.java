package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.FairyWind;
import moves.Growl;
import moves.RockTomb;
import moves.Swagger;

public final class Mawile extends Pokemon {
    public Mawile(String name, int level){
        super(name, level);
        super.setType(Type.FAIRY, Type.STEEL);
        super.setStats(50, 85, 85, 55, 55, 50);

        FairyWind fairyWind = new FairyWind();
        RockTomb rockTomb = new RockTomb();
        Growl growl = new Growl();
        Swagger swagger = new Swagger();
        super.setMove(rockTomb, fairyWind, growl, swagger);

    }


}
