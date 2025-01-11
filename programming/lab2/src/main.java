

import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args){
        Battle b = new Battle();
        Pokemon mawile = new Mawile("Матвей", 1);
        Pokemon pawniard = new Pawniard("Паша", 1);
        Pokemon bisharp = new Bisharp("Борис", 1);
        Pokemon ralts = new Ralts("Рита", 1);
        Pokemon kirlia = new Kirlia("Кира", 1);
        Pokemon gallade = new Gallade("Галя", 1);
        b.addAlly(mawile);
        b.addAlly(pawniard);
        b.addAlly(bisharp);
        b.addFoe(ralts);
        b.addFoe(kirlia);
        b.addFoe(gallade);
        b.go();
    }
}
