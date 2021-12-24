package model;

import lombok.experimental.SuperBuilder;
import service.ReadindChars;
import service.WritingChars;

import java.io.FileNotFoundException;
import java.io.IOException;

@SuperBuilder
public class CharArrayModel {
    private final char[] charArray;
    private final WritingChars writer;
    private int lengthOfSequence = 0;
    public int iterationCount = 0;

    public void setLengthOfSequence(int lengthOfSequence) {
        this.lengthOfSequence = lengthOfSequence;
    }

    public char[] getCharArray() {
        return charArray;
    }

    public WritingChars getWriter() {
        return writer;
    }

    public int getLengthOfSequence() {
        return lengthOfSequence;
    }

    public CharArrayModel() throws FileNotFoundException {
        this.charArray = ReadindChars.readChars("src/main/java/resources/charSequence.txt");
        this.writer = new WritingChars("src/main/java/resources/allCharCombination.txt");
    }

    public void setCharInSequence(StringBuilder str, int numberOfChar) throws IOException {
        for (char c : charArray) {
            str.setCharAt(numberOfChar, c);
            if (numberOfChar < lengthOfSequence - 1) {
                setCharInSequence(str, numberOfChar + 1);
            } else {
                iterationCount++;
                writer.write(str + "");
                if (iterationCount % Math.pow(charArray.length, 2) == 0) {
                    writer.write("\n");
                }
                if (iterationCount == (int) Math.pow(charArray.length, lengthOfSequence - 1)) {
                    writer.write("\n");
                    iterationCount = 0;
                }
            }
        }
    }

}
