import model.CharArrayModel;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import service.CharCombinationService;
import service.ReadindChars;
import service.WritingChars;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;


@RunWith(MockitoJUnitRunner.class)
public class CharCombinationServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void studentServiceTestWithMockingAllTrace() throws IOException {
        CharArrayModel charArrayModel = CharArrayModel.builder().charArray(ReadindChars.readChars("src/test/java/resources/charSequence.txt"))
                .writer(new WritingChars("src/test/java/resources/allCharCombination.txt")).build();
        CharCombinationService charCombinationService = new CharCombinationService(charArrayModel);
        charCombinationService.createAllDifferentSequences(4);

        Assert.assertEquals(new String(readChars("src/test/java/resources/allCharCombination.txt")),
                new String(readChars("src/test/java/resources/fileForComparison.txt")));
    }

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
