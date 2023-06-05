package TestApiSave;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ReaderUrl {
    static public List<String> readFile(String urlFile) throws FileNotFoundException {
        File file = new File(urlFile);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        return reader.lines().toList();
    }
}
