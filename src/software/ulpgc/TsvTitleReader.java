package software.ulpgc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{
    private final File file;

    public TsvTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        return readWith(reader);

    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        List<Title> result = new ArrayList<>();
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            result.add(deserializer.deserialize(line));
        }
        return result;
    }
}
