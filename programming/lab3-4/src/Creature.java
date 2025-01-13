abstract class Creature implements HasHeight, Stayable{
    protected final String name;
    protected final int height;

    public Creature(String name, int height) {
        this.name = name;
        this.height = height;
    }
    public abstract void eat(Food food);
    public abstract String getName();
    public abstract void move(Direction direction);
    public abstract void getDamage(int damage);
    public abstract void checkHeight(HasHeight hasHeight);
    public abstract void hit(Creature creature);
}
