package type;

import java.io.*;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class FileEncodingTest {
    private static final List<Charset> SUPPORTED_CHARSETS = Arrays.asList(
            StandardCharsets.UTF_8,
            StandardCharsets.UTF_16,
            StandardCharsets.UTF_16BE,
            StandardCharsets.UTF_16LE,
            StandardCharsets.ISO_8859_1
    );

    public Charset detectFileEncoding( String filePath ) throws IOException {
        byte[] bytes = readFileBytes(filePath);
        String accentCharacters = "дск";

        for(Charset charset : SUPPORTED_CHARSETS){
            try{
                new String(bytes, charset).getBytes(charset);
                return charset;
            }catch(CharacterCodingException e) {
                continue;
            }
        }
        return StandardCharsets.UTF_8;
    }

    public void convertFileEncoding( String inputPath, String outputPath,
                                     Charset fromCharset, Charset toCharset ) throws IOException {
        String content = new String(readFileBytes(inputPath), fromCharset);
        try(Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(outputPath), toCharset))){
            writer.write(content);
        }
    }

    private byte[] readFileBytes( String filePath ) throws IOException {
        File file = new File(filePath);
        byte[] bytes = new byte[(int)file.length()];
        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
        }
        return bytes;
    }
}
