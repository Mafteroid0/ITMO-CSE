public abstract class Element {
    protected final String name;
    public Element(String name) {
        this.name = name;
    }


    abstract void describe();
    public abstract String getName();
}
