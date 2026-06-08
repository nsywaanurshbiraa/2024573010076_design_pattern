package praktikum_6.bagian_2.tanpa_lsp;

class SocialMediaPost {
    protected String content;

    public SocialMediaPost(String content) {
        this.content = content;
    }

    public void publish() {
        System.out.println("Publishing post: " + content);
    }

    public int calculateMaxCharacters() {
        return 1000; // Batas karakter
    }
}
