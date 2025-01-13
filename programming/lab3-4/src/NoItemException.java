public class NoItemException extends Exception {
  @Override
  public String getMessage(){
    return "Нечего выбрасывать.";
  }
}
