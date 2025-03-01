package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        // 입력값 저장
        String input = br.readLine();

        // 입력 문자열에 대해 각 문자 별로 대문자, 소문자 여부 체크 후 변환
        for (char c: input.toCharArray()) {
            if (Character.isUpperCase(c)) output.append(Character.toUpperCase(c));
            else output.append(Character.toLowerCase(c));
        }

        // 결과 출력
        System.out.println(output.toString());
    }
}