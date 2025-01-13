//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Human neznayka = new Human("Незнайка", 50);
        Human fisk = new Human("Фикс", 60);

        Air air = new Air(1 + (int) (Math.random() * (100)));



        Moonfruit pear = new Moonfruit(FruitType.PEAR, 40, Color.WHITE);
        Moonfruit apple = new Moonfruit(FruitType.APPLE, 10, Color.GREEN);
        Fence fence = new Fence(Size.Large);
        Bush bush = new Bush(Size.Small, new Moonfruit(FruitType.BERRY, 80, Color.RED));

        Human.Eyes fiskeyes = fisk.new Eyes();

        Cloth blazer = new Cloth(ClothElement.Blazer, Color.GINGER);
        Cloth cap = new Cloth(ClothElement.Cap, Color.GINGER);
        Cloth trousers = new Cloth(ClothElement.Trousers, Color.BLUE);
        Cloth sandals = new Cloth(ClothElement.Sandals, Color.BLUE);
        Cloth spacesuit = new Cloth(ClothElement.Spacesuit, Color.WHITE);
        blazer.putOn(fisk);
        cap.putOn(fisk);
        trousers.putOn(fisk);
        sandals.putOn(fisk);
        spacesuit.putOn(neznayka);


        Broom broom = new Broom();
        fisk.take(broom);

        Trap trap = new Trap(Size.Medium);

        Tree tree = new Tree(Size.Medium, apple);

        System.out.println("\n----История о Незнайке----\n");
        neznayka.takeClothOff(ClothElement.Spacesuit);
        neznayka.checkAirQuality(air);
        neznayka.inhale(air, 70);
        neznayka.putAwayItem(Direction.AWAY, 100);
        neznayka.lookAround();

        tree.describe();
        neznayka.checkHeight(tree);

        neznayka.taste(tree.getFruit(), TastingNature.TASTE);
        neznayka.take(pear);
        neznayka.taste(pear, TastingNature.TASTE);




        neznayka.putAwayItem(Direction.AWAY, 20);
        neznayka.describeStatiety();
        neznayka.move(Direction.AWAY);
        fence.describe();
        bush.describe();
        Fruit berry = bush.getFruit();
        neznayka.taste(berry, TastingNature.ORIGIN);
        neznayka.eat(berry);
        neznayka.describeStatiety();
        fiskeyes.follow(neznayka);
        fiskeyes.describeOwner();
        fisk.describeCloth();
        fisk.describeActiveItem();
        neznayka.eat(berry);
        trap.touch(neznayka);
        fisk.move(neznayka);
        fisk.hit(neznayka);
        neznayka.shrug();




        }
    }
