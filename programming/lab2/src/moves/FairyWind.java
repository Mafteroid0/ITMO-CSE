package moves;
import ru.ifmo.se.pokemon.*;
public final class FairyWind extends SpecialMove{
    public FairyWind(){
        super(Type.FAIRY, 40, 100);

    }
    @Override
    protected java.lang.String describe(){
        return "Использует Fairy Wind";
    }

}
