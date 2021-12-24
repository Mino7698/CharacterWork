package service;

import java.io.*;

public class WritingChars {
    String path;

    public WritingChars(String path) throws FileNotFoundException {
        this.path = path;
        PrintWriter writer = new PrintWriter(path);
        writer.print("");
        writer.close();
    }

    public void write(String str) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.append(' ');
            writer.append(str);
        }
    }
}
