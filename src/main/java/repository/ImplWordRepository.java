package repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImplWordRepository implements WordRepository {

    @Override
    public List<String> loadWords() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("input.txt");
        if (is == null) {
            throw new RuntimeException("File 'input.txt' is not found!");
        }
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            final Stream<String> lines = bufferedReader.lines()
                    .filter(x -> !x.isEmpty())
                    .map(String::trim);
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
