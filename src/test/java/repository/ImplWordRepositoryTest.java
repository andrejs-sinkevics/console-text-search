package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.ImplWordStorage;
import services.WordStorage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImplWordRepositoryTest {

    private WordRepository wordRepository;

    public ImplWordRepositoryTest() {
        this.wordRepository = new ImplWordRepository();
    }

    @Test
    void LoadWords_ReturnWords() {
        final List<String> words = wordRepository.loadWords();
        System.out.println(words);
        Assertions.assertNotNull(words);
        Assertions.assertEquals(words.size(), 8);
        Assertions.assertAll("words",
                () -> Assertions.assertEquals("can", words.get(0)),
                () -> Assertions.assertEquals("cat", words.get(1)),
                () -> Assertions.assertEquals("dog", words.get(2)),
                () -> Assertions.assertEquals("catalog", words.get(3)),
                () -> Assertions.assertEquals("log", words.get(4)),
                () -> Assertions.assertEquals("able", words.get(5)),
                () -> Assertions.assertEquals("of", words.get(6)),
                () -> Assertions.assertEquals("an", words.get(7))
        );
    }
}
