package screenmatch.models.exceptions;

public class TitleConversionException extends RuntimeException {
    private String message;

    public TitleConversionException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
