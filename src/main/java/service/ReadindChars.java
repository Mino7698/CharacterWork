package service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadindChars {
    public static char[] readChars(String path) {
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            fr.read(chars);
            return chars;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}