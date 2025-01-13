public class Trap extends WorldObject{
    public Trap(Size size) {
        super("Капкан", size);
    }

    @Override
    public void touch(Creature creature){
        System.out.println(creature.getName() + " попал в капкан.");
        creature.getDamage(90);
    }

}
