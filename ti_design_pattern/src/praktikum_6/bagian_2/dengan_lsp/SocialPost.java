package praktikum_6.bagian_2.dengan_lsp;

public class SocialPost implements Publishable {
    protected String content;

    public SocialPost(String content) {
        this.content = content;
    }

    @Override
    public void publish() {
        System.out.println("Publishing: " + content);
    }

    @Override
    public boolean canPublish() {
        return content.length() <= getMaxContentLength();
    }

    @Override
    public int getMaxContentLength() {
        return 1000;
    }
}
