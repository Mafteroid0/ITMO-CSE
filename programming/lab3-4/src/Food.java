public class Food extends Item{
    private final int taste;
    public Food(String name, Integer taste) {
        super(name);
        this.taste = taste;
    }
    public int getTaste() {
        return taste;
    }

}
