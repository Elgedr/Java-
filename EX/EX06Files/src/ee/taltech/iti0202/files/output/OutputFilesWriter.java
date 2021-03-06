package ee.taltech.iti0202.files.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OutputFilesWriter {

    /**
     *
     * @param lines .
     * @param filename .
     * @return .
     */
    public boolean writeLinesToFile(List<String> lines, String filename) {
        Path path = Paths.get(filename);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String str : lines) {
                    writer.write(str + "\n");
                }
            } catch (IOException e) {
                System.out.println("IOException:" + e.getMessage());
                e.printStackTrace();
                return false;
            }
        return true;
    }
}
