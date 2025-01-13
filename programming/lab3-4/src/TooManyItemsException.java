public class TooManyItemsException extends RuntimeException {
  public TooManyItemsException(Human human, Item item) {
    super(human.getName() + " сначала должен выбросить " + item.getName() + " чтобы подобрать новый предмет");
  }
  @Override
  public String getMessage(){
    return "Нужно избавиться от предмета в руках.";
  }
}
