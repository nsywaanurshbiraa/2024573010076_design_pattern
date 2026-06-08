package praktikum_6.bagian_2.dengan_lsp;

public class TwitterPost implements Publishable {
    private static final int MAX_LENGTH = 280;
    private String content;

    public TwitterPost(String content) {
        this.content = content;
    }

    @Override
    public void publish() {
        if (!canPublish()) {
            throw new IllegalArgumentException("Tweet exceeds " + MAX_LENGTH + " characters");
        }
        System.out.println("Posting tweet: " + content);
    }

    @Override
    public boolean canPublish() {
        return content.length() <= MAX_LENGTH;
    }

    @Override
    public int getMaxContentLength() {
        return MAX_LENGTH;
    }
}