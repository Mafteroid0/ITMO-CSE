package exceptions;

/**
 * Исключение, вызываемое во время ошибки выполнения команды
 */
public class CommandExecutionException extends Exception {
    public CommandExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}