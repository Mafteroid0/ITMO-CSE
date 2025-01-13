

public class Fruit extends Food {
    private final FruitType fruitType;
    private final Color color;
    public Fruit(FruitType fruitType, int taste, Color color) {
        super(fruitType.getTitle(), taste);
        this.fruitType = fruitType;
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
}
