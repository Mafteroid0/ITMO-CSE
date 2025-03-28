

import managers.CollectionManager;
import utility.Invoker;
import utility.Console;
import utility.StandartConsole;

public class Main
{
    public static void main(String[] args){

        Invoker invoker = new Invoker();
        Console console = new StandartConsole();
        CollectionManager collectionManager = new CollectionManager();
        invoker.run(console, collectionManager);
    }
}
