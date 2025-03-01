import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MainTest {
    @Test
    public void testMain() throws IOException {
        String input = "WrongAnswer";
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringBuilder output = new StringBuilder();
        String inputStr = br.readLine();

        for (char c: inputStr.toCharArray()) {
            if (Character.isUpperCase(c)) output.append(Character.toLowerCase(c));
            else output.append(Character.toUpperCase(c));
        }

        assertEquals("wRONGaNSWER", output.toString());
    }
}
