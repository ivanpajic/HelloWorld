package type;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SupportFiles {

    public boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    public String readFileContent(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public void writeFileContent(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }
}
