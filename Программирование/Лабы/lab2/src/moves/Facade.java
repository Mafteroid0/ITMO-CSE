package moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL, 70, 100);


    }
    @Override
    protected void applyOppDamage(Pokemon target, double damage){
        switch (target.getCondition()){
            case BURN -> target.setMod(Stat.HP, (int) Math.round(damage*2));
            case POISON -> target.setMod(Stat.HP, (int) Math.round(damage*2));
            case PARALYZE -> target.setMod(Stat.HP, (int) Math.round(damage*2));
            default -> target.setMod(Stat.HP, (int) Math.round(damage));
        }

    }
    @Override
    protected java.lang.String describe(){
        return "Использует Facade";
    }
}
