import java.util.Objects;

public class Item extends Element {

    public Item(String name) {
        super(name);
    }

    public void describe(){
        System.out.println("Это " + name);
    }
    public String getName(){
        return name;
    };

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name);
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + '}';
    }

}
