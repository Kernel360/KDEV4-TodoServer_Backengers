import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testMain() throws IOException {
        String input = "11\n10987654321";
        BufferedReader br = new BufferedReader(new StringReader(input));
        int cnt = Integer.parseInt(br.readLine());
        String inputStr = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (char c: inputStr.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        int sum = 0;
        for (int num: numbers ) {
            sum += num;
        }
        assertEquals(46, sum); // 예상 결과와 실제 결과 비교
    }
}
