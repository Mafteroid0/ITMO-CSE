package exceptions;

/**
 * Исключение, вызываемое при достижении максимальной глубины рекурсии
 */
public class RecursionDepthException extends RuntimeException {
    public RecursionDepthException(String message) {
        super(message);
    }
}
