package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class BulkUp  extends StatusMove {
    public BulkUp(){
        super(Type.FIGHTING, 0, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK, 1);
        p.setMod(Stat.SPEED, 1);
    }
    @Override
    protected java.lang.String describe(){
        return "Кастует Bulk up";
    }
}
