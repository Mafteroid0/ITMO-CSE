import java.util.ArrayList;
import java.util.Objects;

public class Human extends Creature {

    private int caution = 1 + (int) (Math.random() * (100));
    private int statiety = 1 + (int) (Math.random() * (100));
    private final ArrayList<Cloth> cloths = new ArrayList<>();
    private Item activeitem;
    public Human(String name, int height) {
        super(name, height);

        System.out.println("Прибыл " + name);
    }
    private String removeitem() throws NoItemException{
        if (activeitem == null){
            throw new NoItemException();
        } else{
            String somename =  activeitem.getName();
            activeitem = null;
            return somename;
        }
    }

    private void increaseStatiety(int amount){
        statiety += amount;
        System.out.println("Сытость " + name + " понемногу поднимается.");
    }
    private void decreaseStatiety(int amount){
        statiety -= amount;
        System.out.println("Сытость " + name + " падает.");
    }
    private void decreaseCaution(int amount){
        caution -= amount;
        System.out.println("Внимательность " + name + " упала");
    }
    private void increaseCaution(int amount){
        caution += amount;
        System.out.println("Внимательность " + name + " поднялась");
    }
    public void getDamage(int damage){
        if (damage < 20) System.out.println(name + " стало неприятно.");
        else if (damage < 50) System.out.println(name + " почувствовал боль");
        else if (damage < 70) System.out.println(name + " почувствовал сильную боль");
        else System.out.println(name + " вскрикнул от боли");
    }
    public void checkHeight(HasHeight hasHeight){
        System.out.println(hasHeight.getName() + " ростом как " +
                (float) hasHeight.getHeight()/ (float) this.getHeight() + " роста " + this.getName());
    }
    public void lookAround(){
        System.out.println(name + " осматривается.");
    }
    public int getHeight(){
        return height;
    }



    void taste(Fruit fruit, TastingNature tastingNature){
        String description = fruit.getFruitType().getTitle();
        System.out.println(name + " пробует " + description);
        switch (tastingNature) {
            case TASTE:
                int taste = fruit.getTaste();
                if (taste < 20) System.out.println(name + " тут же выплюнул это. До того оно оказалось кислое.");
                else if (taste < 50) System.out.println("Оно оказалось безвуксным, к тому же терпким.");
                else if (taste < 70) System.out.println(name + " понравилось это.");
                else System.out.println(name + " был в восторге от вкуса.");
                break;
            case ORIGIN:
                if (fruit instanceof Moonfruit) {
                    System.out.println(name + " убедился что это лунный " + description);
                } else System.out.println(name + " убедился что это обычный " + description);
                break;

        }}


    void inhale(Air air, Integer deep){
        if (deep < 50){
            System.out.println(name + " сделал вдох.");
        }
        else {
            System.out.println(name + " сделал вдох полной грудью.");
            if (air.quality() >= 70){
                System.out.println("Сердце " + name + " стало спокойнее биться.");
            } else if (air.quality() < 50) {
                System.out.println("От этого в груди у " + name + " заболело.");
            }
        }
    }
    void checkAirQuality(Air air){
        this.inhale(air, 10);
        if (air.quality() < 10){
            System.out.println("Этим просто невозможно дышать!");
        } else if (air.quality() < 35) {
            System.out.println("Воздух был явно плохой.");
        } else if (air.quality() < 50) {
            System.out.println("Воздух был хуже Земного");
        }else if (air.quality() < 70) {
            System.out.println("Воздух был такой же как и на Земле");
        }else System.out.println("Воздух вокруг гораздо лучше Земного");

    }
    public void eat(Food food){
        System.out.println(name + " ест " + food.getName());
        increaseStatiety(10);
        decreaseCaution(10);
    };
    void take(Item item){
        if (activeitem == null) {
            activeitem = item;
            System.out.println(name + " взял " + activeitem.getName());
        }
        else throw new TooManyItemsException(this, item);
    }
    void putAwayItem(Direction direction, Integer accuracy){
        String describeword;
        if (accuracy < 20) describeword = " кинул ";
        else if (accuracy < 50) describeword = " отшвырнул ";
        else if (accuracy < 70) describeword = " положил ";
        else describeword = " аккуратно положил ";
        try {
            System.out.println(name + describeword + removeitem() + " " + direction.getTitle());
        } catch (NoItemException e) {
            System.out.println(name + " ничего не " + describeword);
        }
    };
    void describeStatiety(){
        if (statiety < 20) {
            System.out.println(name + " голоден!");
        } else if (statiety < 40) {
            System.out.println(name + " хочет есть.");
        } else if (statiety < 85){
            System.out.println(name + " не против подкрепиться.");
        } else{
            System.out.println(name + " сыт.");
        }
    }

    void describeActiveItem(){
        if (activeitem != null){
            System.out.println(name + " держит в руках " + activeitem.getName());
        } else System.out.println(name + " ничего не держит в руках.");

    }
    public void hit(Creature creature){
        if (this.activeitem == null){
            System.out.println(name + " ударил " + creature.getName() + " рукой.");
        } else System.out.println(name + " ударил " + creature.getName() + " при помощи " + activeitem.getName());
    }
    public void shrug(){
        System.out.println(name + " пожал плечами.");
    }




    public void move(Direction direction){
        System.out.println(name + " прошёл " + direction.getTitle());
    }
    public void move(Stayable stayable){
        System.out.println(name + " подошёл к " + stayable.getName());
    }

    Integer getCaution(){
        return caution;
    }
    void payAttention(int thresholdValue){
        if (this.getCaution() < thresholdValue){
            System.out.println(name + " ничего не заметил потому что вёл себя недостаточно осторожно.");
        }
        else{
            System.out.println(name + " вёл себя достаточно осторожно чтобы заметить это.");
        }
    }
    public String getName(){
        return name;
    }

    public void addCloth(Cloth cloth){
        cloths.add(cloth);
    }

    public void describeCloth(){
        boolean has_trousers = false;
        boolean has_boots = false;
        for (Cloth cloth : cloths) {
            System.out.println("На " + name + " надето " + cloth.getDescription());
            if (cloth.getElement() == ClothElement.Trousers){has_trousers = true;}
            if (cloth.getElement() == ClothElement.Boots){has_boots = true;}
        }
        if (has_trousers){
            System.out.println("Такие штаны обычно носят заткнув в сапоги");
            if (has_boots){
                System.out.println("Именно так он их и носил.");
            } else {
                System.out.println("Но сапог не было.");
            }
        }
    }

    public void takeClothOff(ClothElement type){
        for (Cloth cloth : cloths) {
            if (cloth.getElement() == type){
                System.out.println(name + " снял " + cloth.getDescription());
                try {
                    this.take(cloth);
                } catch (TooManyItemsException e) {
                    this.putAwayItem(Direction.AWAY, 100);
                    this.take(cloth);
                }
                cloths.remove(cloth);
                break;
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return caution == human.caution && statiety == human.statiety && Objects.equals(cloths, human.cloths) && Objects.equals(activeitem, human.activeitem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caution, statiety, cloths, activeitem);
    }

    @Override
    public String toString() {
        return "Human{"
                + "name='" + name + '\''
                + ", activeitem=" + activeitem
                + ", caution=" + caution
                + ", statiety=" + statiety
                + '}';
    }


    public class Eyes{
        public Eyes(){
        }
        public void follow(Human other) {
                System.out.println("За " + other.getName() + " следили чьи-то глаза.");
                other.payAttention(75);

        }
        public void describeOwner(){
            System.out.println("Глаза принадлежат " + name);
        }
    }

}
