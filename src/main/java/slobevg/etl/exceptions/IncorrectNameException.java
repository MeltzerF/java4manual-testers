package slobevg.etl.exceptions;

public class IncorrectNameException extends Exception {
    private String name;
    public IncorrectNameException() {
        super();
    }
    public IncorrectNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectNameException(String message, Throwable cause, String name) {
        super(message, cause);
        this.name = name;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
