package praktikum_6.bagian_2.dengan_lsp;

public class BlogPost implements Publishable {
    private String content;
    private boolean isPublished;

    public BlogPost(String content) {
        this.content = content;
        this.isPublished = false;
    }

    @Override
    public void publish() {
        if (isPublished) {
            return; // Idempotent operation
        }
        isPublished = true;
        System.out.println("Publishing blog: " + content);
    }

    @Override
    public boolean canPublish() {
        return !isPublished;
    }

    @Override
    public int getMaxContentLength() {
        return Integer.MAX_VALUE; // No practical limit
    }

    public void editContent(String newContent) {
        if (isPublished) {
            System.out.println("Adding update to published blog");
        }
        this.content = newContent;
    }
}