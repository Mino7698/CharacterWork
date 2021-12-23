package service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class CharCombinationService {
    final char[] charArray;
    final WritingChars writer;
    int lengthOfSequence = 0;
    int iterationCount = 0;

    public CharCombinationService(String pathToRead, String pathToWrite) throws FileNotFoundException {
        char[] chars = ReadindChars.readChars(pathToRead);
        assert chars != null;
        Arrays.sort(chars);
        this.charArray = chars;
        this.writer = new WritingChars(pathToWrite);
    }

    public void createAllDifferentSequences(int lengthOfSequence) throws IOException {
        this.lengthOfSequence = lengthOfSequence;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<lengthOfSequence; i++){
            str.append(0);
        }
        writer.write( "");
        setCharInSequence2(str,0);
    }

    public void setCharInSequence2(StringBuilder str, int numberOfChar) throws IOException {
        for (int i = 0; i < charArray.length; i++) {
            str.setCharAt(numberOfChar,charArray[i]);
            if (numberOfChar < lengthOfSequence-1){
                setCharInSequence2(str,numberOfChar+1);
            }else{
                iterationCount++;
                writer.write(str + "");
                if (iterationCount%Math.pow(charArray.length,2) == 0){
                    writer.write("\n");
                }
                if (iterationCount == (int) Math.pow(charArray.length,lengthOfSequence-1)){
                    writer.write("\n");
                    iterationCount = 0;
                }
            }
        }
    }

}

