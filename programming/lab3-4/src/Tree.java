public class Tree extends WorldObject{
    private final Fruit fruit;

    public Tree(Size size, Fruit fruit) {
        super("Карликовое дерево", size);
        this.fruit = fruit;
    }
    @Override
    public void describe(){
        System.out.println("Это карликовое дерево. На нём растёт "
                + this.fruit.getColor().getTitle() +
                " " + fruit.getFruitType().getTitle());
    }

    public Fruit getFruit() {
        return fruit;
    }
}
