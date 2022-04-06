package services;

import error.SearchWordValidationException;
import repository.ImplWordRepository;
import repository.WordRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImplWordStorage implements WordStorage {

    private final WordRepository wordRepository;

    private final List<String> words;

    public ImplWordStorage() {
        this.wordRepository = new ImplWordRepository();
        this.words = wordRepository.loadWords();
    }

    @Override
    public List<String> getWords() {
        return words;
    }

    public List<String> searchWords(final String search, final boolean ignoreCase) {
        if (search == null) {
            throw new SearchWordValidationException("Search parameter must be not null");
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < search.length(); i++) {
            for (String word : words) {
                final boolean matches = search.regionMatches(ignoreCase, i, word, 0, word.length());
                if (matches) {
                    result.add(word);
                    i += word.length() - 1;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public List<String> searchWords(String search) {
        return searchWords(search, false);
    }

    @Override
    public List<String> searchWordsCaseSensitive(String search) {
        return searchWords(search, true);
    }

}
