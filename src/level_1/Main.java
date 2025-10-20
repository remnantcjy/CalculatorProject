package level_1;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = "";

        while (true) {
            int num1 = readInt(sc, "첫 번째 정수 입력: ");

            // 연산자 입력 및 사칙연산만 입력받게 검증
            char operator;
            while(true) {
                System.out.print("연산자 입력 (+, -, *, /): ");
                operator = sc.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("올바른 연산자를 입력해주세요.");
                }
            }


            // 나눗셈 연산에서 두 번째 숫자에 0을 입력 받았을 때 검증 처리
            int num2;
            while (true) {
                num2 = readInt(sc, "두 번째 정수 입력: ");

                if (operator == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                } else {
                    break;
                }
            }

            double result = 0.0; // 결과
            boolean double_flag = false;    // 나눗셈 연산에서 소수점을 출력하기 위한 flag

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (double) num1 / num2;
                    double_flag = true;
                default:
                    break;
            }

            if (double_flag) {
                System.out.println("계산 결과: " + num1 + " " + operator + " " + num2 + " = " + String.format("%.2f", result));
            } else {
                System.out.println("계산 결과: " + num1 + " " + operator + " " + num2 + " = " + (int)result);

            }

            System.out.print("계산을 더 하시겠습니까? (종료시 exit 입력): ");
            exit = sc.next();
            if(exit.equalsIgnoreCase("exit"))
                break;
        }
    }

    // 입력 검증 메서드 - 0을 포함한 양의 정수만 받을 수 있게
    public static int readInt(Scanner sc, String msg) {
        while (true) {
            try {
                // 입력 메시지 출력
                System.out.print(msg);
                int num = sc.nextInt();
                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("0이상 양의 정수만 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                // 예외처리 - 직접적인 복구는 아니지만, 코드로 흉내냄
                System.out.println("❗숫자만 입력할 수 있습니다 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }
    }
}