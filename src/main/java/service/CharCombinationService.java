package service;

import lombok.experimental.SuperBuilder;
import model.CharArrayModel;

import java.io.IOException;

@SuperBuilder
public class CharCombinationService {
    private final CharArrayModel charArrayModel;

    public CharCombinationService(CharArrayModel charArrayModel) {
        this.charArrayModel = charArrayModel;
    }

    public void createAllDifferentSequences(int lengthOfSequence) throws IOException {
        charArrayModel.setLengthOfSequence(lengthOfSequence);
        StringBuilder str = new StringBuilder();
        str.append("0".repeat(Math.max(0, lengthOfSequence)));
        setCharInSequence(str,0, charArrayModel);
    }

    public void setCharInSequence(StringBuilder str, int numberOfChar, CharArrayModel charArrayModel) throws IOException {
        for (int i = 0; i < charArrayModel.getCharArray().length; i++) {
            str.setCharAt(numberOfChar,charArrayModel.getCharArray()[i]);
            if (numberOfChar < charArrayModel.getLengthOfSequence()-1){
                setCharInSequence(str,numberOfChar+1, charArrayModel);
            }else{
                charArrayModel.getWriter().write(str + "");
                charArrayModel.iterationCount++;
                addingSpace(charArrayModel);
            }
        }
    }

    private void addingSpace(CharArrayModel charArrayModel) throws IOException {
        if (charArrayModel.iterationCount%Math.pow(charArrayModel.getCharArray().length,2) == 0){
            charArrayModel.getWriter().write("\n");
        }
        if (charArrayModel.iterationCount == (int) Math.pow(charArrayModel.getCharArray().length,charArrayModel.getLengthOfSequence()-1)){
            charArrayModel.getWriter().write("\n");
            charArrayModel.iterationCount = 0;
        }
    }
}

