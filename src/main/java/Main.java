import services.ImplWordStorage;
import services.WordStorage;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String QUIT = "q";
    private static final String SEARCH_WORDS_CASE_SENSITIVE = "si";
    private static final String SEARCH_WORDS = "s";

    public static void main(String... arg) {
        System.out.println("Application is up!");
        WordStorage wordStorage = new ImplWordStorage();
        System.out.println("Commands:");
        System.out.printf("'%s' \t - to quit.\n", QUIT);
        System.out.printf("'%s' \t - to search.\n", SEARCH_WORDS);
        System.out.printf("'%s' \t - to search with ignoring case sensitive.\n", SEARCH_WORDS_CASE_SENSITIVE);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean quit = false;
            do {
                System.out.println("Enter command: ");
                final String next = scanner.nextLine().trim();
                switch (next) {
                    case SEARCH_WORDS_CASE_SENSITIVE: {
                        System.out.println("Enter text: ");
                        final String text = scanner.nextLine().trim();
                        printResult(text, wordStorage.searchWordsCaseSensitive(text));
                        break;
                    }
                    case SEARCH_WORDS: {
                        System.out.println("Enter text: ");
                        final String text = scanner.nextLine().trim();
                        printResult(text, wordStorage.searchWords(text));
                        break;
                    }
                    case QUIT: {
                        quit = true;
                        break;
                    }
                    default:
                        System.out.println("Alert: unknown command!");
                }
            } while (!quit);
            System.out.println("Application is down!");
        }
    }

    static void printResult(String text, List<String> words) {
        for (String word : words) {
            text = text.replaceAll(word, " " + word + " ");
        }
        System.out.printf("'%s' %d words found \n", text, words.size());
    }

}
