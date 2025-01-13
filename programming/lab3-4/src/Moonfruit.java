public class Moonfruit extends Fruit{
    private final String name;
    public Moonfruit(FruitType fruitType, int taste, Color color) {
        super(fruitType, taste, color);

        this.name = fruitType.getTitle();
    }
    @Override
    public String getName(){
        return "Лунный " + name;
    }
}
