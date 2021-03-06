package ee.taltech.iti0202.files.input;

import java.util.List;

/**
 * Interface.
 */
public interface InputFilesReader {
    List<String> readTextFromFile(String filename);
}
