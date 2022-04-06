package services;

import java.util.List;

public interface WordStorage {

    List<String> getWords();

    List<String> searchWords(final String search);

    List<String> searchWordsCaseSensitive(final String search);

}
