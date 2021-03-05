package ee.taltech.iti0202.files.input; // Use a Buffer reader

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> result = new ArrayList<>();
        Path path = Paths.get("morse.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (true) {
                String line = reader.readLine();
                result.add(line);
                if (line == null) break;
            }
        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return result;
    }
}