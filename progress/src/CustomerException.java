import java.io.IOException;

public class CustomerException extends IOException {
    public CustomerException(String message) {
        super(message);
    }
}
