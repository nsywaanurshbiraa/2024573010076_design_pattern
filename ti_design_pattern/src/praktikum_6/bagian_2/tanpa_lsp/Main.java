package praktikum_6.bagian_2.tanpa_lsp;

public class Main {
    public static void sharePost(SocialMediaPost post) {
        try {
            post.publish();
            System.out.println("Maksimum karakter: " + post.calculateMaxCharacters());
        } catch (Exception e) {
            System.out.println("Gagal membagi: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SocialMediaPost tweet = new TwitterPost("Halo Twitter!");
        SocialMediaPost longTweet = new TwitterPost("Tweet ini sangat panjang, dan melebihi batas karakter...".repeat(10));
        SocialMediaPost blog = new BlogPost("Modul 6 - Liskov Substitution Principle");

        System.out.println("Memposting tweet yang valid:");
        sharePost(tweet);

        System.out.println("\nMemposting tweet yang tidak valid:");
        sharePost(longTweet); // Throws exception

        System.out.println("\nMemposting blog:");
        sharePost(blog);

        System.out.println("\nMemposting blog sekali lagi:");
        sharePost(blog); // Throws different exception
    }
}
