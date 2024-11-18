package moves;

import ru.ifmo.se.pokemon.*;

public final class StoneEdge extends PhysicalMove {
    public StoneEdge(){
        super(Type.ROCK, 100, 80);
    }

    @Override
    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if (Math.random() < 0.125) {
            System.out.println("critical");
            return 2.0;
        } else {
            return 1.0;
        }
    }
    @Override
    protected java.lang.String describe(){
        return "Использует Stone Edge";
    }

}
