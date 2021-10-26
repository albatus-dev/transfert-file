package fr.dropwizard.equisign.exception;

public class TransferFileException extends Exception {

    private String messageError;
    private Throwable cause;

    public TransferFileException() {
        super();
    }

    public TransferFileException(String messageError, Throwable cause) {
       super(messageError, cause);
    }

    public String getMessageError() {
        return messageError;
    }

    public Throwable getCause() {
        return cause;
    }
}
