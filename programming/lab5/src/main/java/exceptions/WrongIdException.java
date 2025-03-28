package exceptions;

/**
 * Исключение, вызываемое при неверно введённом id
 */
public class WrongIdException extends RuntimeException {
    public WrongIdException(String message) {
        super(message);
    }
}
