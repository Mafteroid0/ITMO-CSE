package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class RockPolish extends StatusMove {
    public RockPolish(){
        super(Type.ROCK, 0, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.SPEED, 2);
    }
    @Override
    protected java.lang.String describe(){
        return "Использует Rock Polish";
    }

}
