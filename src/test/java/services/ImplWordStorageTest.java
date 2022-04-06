package services;

import error.SearchWordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ImplWordStorageTest {

    private WordStorage wordStorage;

    public ImplWordStorageTest() {
        this.wordStorage = new ImplWordStorage();
    }

    //Test SearchWords method
    @Test
    void SearchWords_PassTextLowerCase_Return3Words() {
        final String testSearch = "djkhofjkhacatalogdsahf";
        final List<String> words = this.wordStorage.searchWords(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 3);
        Assertions.assertAll("words",
                () -> Assertions.assertEquals("of", words.get(0)),
                () -> Assertions.assertEquals("cat", words.get(1)),
                () -> Assertions.assertEquals("log", words.get(2))
        );

    }

    @Test
    void SearchWords_PassTextWithNumbers_Return3Words() {
        final String testSearch = "djkhofjkhacatalogdsahf";
        final List<String> words = this.wordStorage.searchWords(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 3);
        Assertions.assertAll("words",
                () -> Assertions.assertEquals("of", words.get(0)),
                () -> Assertions.assertEquals("cat", words.get(1)),
                () -> Assertions.assertEquals("log", words.get(2))
        );

    }

    @Test
    void SearchWords_PassEmptyText_ReturnZeroWords() {
        final String testSearch = "";
        final List<String> words = this.wordStorage.searchWords(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 0);

    }

    @Test
    void SearchWords_PassNull_ThrowSearchWordValidationException() {
        Assertions.assertThrows(SearchWordValidationException.class, () -> {
            this.wordStorage.searchWords(null);
        });
    }


    //Test SearchWordsCaseSensitive method
    @Test
    void SearchWordsCaseSensitive_PassText_Return3Words() {
        final String testSearch = "DJKHOfJKHACatALOGDSaHf";
        final List<String> words = this.wordStorage.searchWordsCaseSensitive(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 3);
        Assertions.assertAll("words",
                () -> Assertions.assertEquals("of", words.get(0)),
                () -> Assertions.assertEquals("cat", words.get(1)),
                () -> Assertions.assertEquals("log", words.get(2))
        );

    }

    @Test
    void SearchWordsCaseSensitive_PassTextWithNumbers_Return3Words() {
        final String testSearch = "DJKHOf12312JKHA12323CatALOGDSaHf12121";
        final List<String> words = this.wordStorage.searchWordsCaseSensitive(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 3);
        Assertions.assertAll("words",
                () -> Assertions.assertEquals("of", words.get(0)),
                () -> Assertions.assertEquals("cat", words.get(1)),
                () -> Assertions.assertEquals("log", words.get(2))
        );

    }

    @Test
    void SearchWordsCaseSensitive_PassEmptyText_ReturnZeroWords() {
        final String testSearch = "";
        final List<String> words = this.wordStorage.searchWordsCaseSensitive(testSearch);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 0);

    }

    @Test
    void SearchWordsCaseSensitive_PassNull_ThrowSearchWordValidationException() {
        Assertions.assertThrows(SearchWordValidationException.class, () -> {
            this.wordStorage.searchWordsCaseSensitive(null);
        });
    }
}