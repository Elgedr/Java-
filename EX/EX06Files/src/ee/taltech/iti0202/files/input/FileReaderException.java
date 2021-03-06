package ee.taltech.iti0202.files.input;

public class FileReaderException extends RuntimeException {
    private String message;
    private Throwable reason;

    /**
     *
     * @param message .
     * @param reason .
     */
    public FileReaderException(String message, Throwable reason) {
        super(message, reason);
    }
}
