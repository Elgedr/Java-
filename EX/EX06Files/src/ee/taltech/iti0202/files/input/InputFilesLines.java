package ee.taltech.iti0202.files.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputFilesLines implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> res = new ArrayList<>();
        Path path = Paths.get("morse.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            res = lines;

        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return res;
    }
}