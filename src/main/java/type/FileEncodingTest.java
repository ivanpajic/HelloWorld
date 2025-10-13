package type;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileEncodingTest {
    private static final String TEST_DIR = "test_files/é/â/ï/";
    private Path testPath;

    @BeforeEach
    void setUp() throws IOException {
        testPath = Path.of(TEST_DIR);
        Files.createDirectories(testPath);
    }

    @AfterEach
    void cleanup() throws IOException {
        Files.walk(testPath)
                .forEach(path -> {
                    try{
                        Files.deleteIfExists(path);
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
                });
        Files.deleteIfExists(testPath);
    }

    @Test
    void testUtf8Encoding() throws IOException {
        String content = "Hello UTF-8 ? ñ ? ??";
        Path filePath = testPath.resolve("utf8.txt");
        writeFile(filePath, content, StandardCharsets.UTF_8);
        String result = readFile(filePath, StandardCharsets.UTF_8);
        Assertions.assertEquals(content, result);
    }

    @Test
    void testAsciiEncoding() throws IOException {
        String content = "Hello ASCII";
        Path filePath = testPath.resolve("ascii.txt");
        writeFile(filePath, content, StandardCharsets.US_ASCII);
        String result = readFile(filePath, StandardCharsets.US_ASCII);
        Assertions.assertEquals(content, result);
    }

    @Test
    void testIso88591Encoding() throws IOException {
        String content = "Hello ISO-8859-1 é è à";
        Path filePath = testPath.resolve("iso.txt");
        writeFile(filePath, content, StandardCharsets.ISO_8859_1);
        String result = readFile(filePath, StandardCharsets.ISO_8859_1);
        Assertions.assertEquals(content, result);
    }

    private void writeFile( Path path, String content, java.nio.charset.Charset charset ) throws IOException {
        Files.write(path, content.getBytes(charset));
    }

    private String readFile( Path path, java.nio.charset.Charset charset ) throws IOException {
        return Files.readString(path, charset);
    }
}
