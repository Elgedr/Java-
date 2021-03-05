package ee.taltech.iti0202.files.input;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> result = new ArrayList<>();
        Path path = Paths.get("ee/taltech/iti0202/files/output/morse.txt");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                result.add(scanner.next());
            }
        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return result;
    }
}