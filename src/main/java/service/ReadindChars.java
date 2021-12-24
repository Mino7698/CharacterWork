package service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadindChars {
    private ReadindChars() {
    }
    public static char[] readChars(String path) {
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            fr.read(chars);
            Arrays.sort(chars);
            return chars;
        } catch (IOException e) {
            e.printStackTrace();
            return (new char[]{0});
        }
    }
}