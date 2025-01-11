package moves;

import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;

public final class Growl extends StatusMove {
    public Growl(){
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        target.setMod(Stat.ATTACK, -1);
    }
    @Override
    protected java.lang.String describe(){
        return "Использует Growl";
    }


}
