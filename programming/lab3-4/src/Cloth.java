public class Cloth extends Item implements Wearable {
    final ClothElement element;
    final Color color;
    public Cloth(ClothElement element, Color color) {
        super(element.getTitle());
        this.element = element;
        this.color = color;
    }
    public void putOn(Human human) {
        human.addCloth(this);
        System.out.println(human.name + " надел " + this.getDescription());
    }
    public String getDescription() {
        return element.getTitle() + " " + color.getTitle() + " цвета";
    }
    public ClothElement getElement(){
        return element;
    }

}
