package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileReader implements Reader {

    private Path pathToFile;

    public TextFileReader(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<String> read() throws IOException {
        return Files.readAllLines(pathToFile);
    }
}
