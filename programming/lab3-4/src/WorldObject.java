import java.util.Objects;

public class WorldObject extends Element implements HasHeight, Stayable{
    private final Size size;
    private final int height;
    public WorldObject(String name, Size size){
        super(name);
        this.size = size;
        this.height = size.toHeight();
    }
    public void describe(){
        System.out.println("Это " + name + " " + size.getTitle());
    }
    public String getName(){
        return name;
    };
    public void touch(Creature creature){
        System.out.println(creature.getName() + " коснулся " + this.getName());
    }
    public void checkHeight(HasHeight hasHeight){
        System.out.println(hasHeight.getName() + " ростом как " +
                (float) hasHeight.getHeight()/ (float) this.getHeight() + " роста " + this.getName());
    }
    public int getHeight(){
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldObject that = (WorldObject) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
