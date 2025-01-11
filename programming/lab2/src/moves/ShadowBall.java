package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class ShadowBall extends SpecialMove {
    public ShadowBall(){
        super(Type.GHOST, 80, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        if (Math.random() < 0.2){
            target.setMod(Stat.SPECIAL_DEFENSE, -1);
        }

    }
    @Override
    protected java.lang.String describe(){
        return "Использует Shadow Ball";
    }
}
