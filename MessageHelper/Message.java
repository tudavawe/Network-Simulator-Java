package MessageHelper;

public class Message {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessageAsString() {
        return message;
    }

    public int[] getMessageAsArray() {
        return message.chars().map(c -> c - '0').toArray();
    }
}
