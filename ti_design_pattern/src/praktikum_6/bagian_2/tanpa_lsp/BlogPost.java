package praktikum_6.bagian_2.tanpa_lsp;

public class BlogPost extends SocialMediaPost {
    private boolean isDraft;

    public BlogPost(String content) {
        super(content);
        this.isDraft = true;
    }

    @Override
    public void publish() {
        if (!isDraft) {
            throw new IllegalStateException("Blog ini sudah di pulbish!");
        }
        isDraft = false;
        super.publish();
    }

    public void editContent(String newContent) {
        if (!isDraft) {
            throw new IllegalStateException("Blog yang sudah di publish tidak bisa diedit!");
        }
        this.content = newContent;
    }
}