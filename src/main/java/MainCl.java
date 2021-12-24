import model.CharArrayModel;
import service.CharCombinationService;

import java.io.IOException;

public class MainCl {
    public static void main(String[] args) throws IOException {
        CharArrayModel charArrayModel = new CharArrayModel();
        CharCombinationService distributionOfLettersService
                = new CharCombinationService(charArrayModel);
        distributionOfLettersService.createAllDifferentSequences(6);
    }
}

