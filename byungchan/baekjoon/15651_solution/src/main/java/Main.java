import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄: 정수 n 입력
        int cnt = Integer.parseInt(br.readLine());

        // 두 번째 줄: 문자열 입력
        String input = br.readLine();

        // 문자열을 정수 리스트로 변환
        List<Integer> numbers = new ArrayList<>();
        for (char c: input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        // 주어진 숫자의 합 계산
        int sum = 0;
        for (int num: numbers ) {
            sum += num;
        }

        // 결과 출력
        System.out.println(sum);
    }
}
