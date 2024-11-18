package moves;
import ru.ifmo.se.pokemon.*;

public final class RockTomb extends PhysicalMove{
    public RockTomb(){
        super(Type.ROCK, 60, 95);

    }
    @Override
    protected java.lang.String describe(){
        return "Кастует Rock Tomb";
    }

}
