package moves;

import ru.ifmo.se.pokemon.*;

public final class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL, 0, 85);
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        target.setMod(Stat.ATTACK, -2);
        Effect.confuse(target);
    }
    @Override
    protected String describe(){
        return "Использует Swagger";
    }

}
