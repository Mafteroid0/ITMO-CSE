public class Bush extends WorldObject {
    public Fruit fruit;

    public Bush(Size size, Fruit fruit) {
        super("Куст", size);
        this.fruit = fruit;
    }
    @Override
    public void describe(){
        System.out.println("Это куст. На нём растёт " + this.fruit.getColor().getTitle() + " " + fruit.getFruitType().getTitle());
    }
    public Fruit getFruit() {
        return fruit;
    }
}
