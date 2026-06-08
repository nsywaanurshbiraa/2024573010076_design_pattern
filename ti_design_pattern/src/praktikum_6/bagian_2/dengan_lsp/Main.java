package praktikum_6.bagian_2.dengan_lsp;

public class Main {
    public static void sharePost(Publishable post) {
        if (post.canPublish()) {
            post.publish();
            System.out.println("Max length: " + post.getMaxContentLength());
        } else {
            System.out.println("Cannot publish this post now");
        }
    }

    public static void main(String[] args) {
        Publishable tweet = new TwitterPost("Hello Twitter!");
        Publishable longTweet = new TwitterPost("This is way too long...".repeat(20));
        Publishable blog = new BlogPost("My thoughts on clean code");

        System.out.println("Sharing valid tweet:");
        sharePost(tweet);

        System.out.println("\nSharing invalid tweet:");
        sharePost(longTweet);

        System.out.println("\nSharing blog post:");
        sharePost(blog);

        System.out.println("\nSharing blog post again:");
        sharePost(blog); // Now handles gracefully

        System.out.println("\nEditing published blog:");
        ((BlogPost)blog).editContent("Updated thoughts on clean code");
    }
}
