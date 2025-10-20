package level_1;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = "";

        while (true) {
            System.out.print("첫 번째 숫자 입력: ");
            int num1 = sc.nextInt();

            System.out.print("연산자 입력: ");
            char operator = sc.next().charAt(0);

            System.out.print("두 번째 숫자 입력: ");
            int num2 = sc.nextInt();

            int result = 0; // 결과

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
                    if (num2 != 0) {
                        result = num1 * num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                default:
                    break;
            }

            System.out.println("계산 결과: " + num1 + " " + operator + " " + num2 + " = " + result);

            System.out.print("계산을 더 하시겠습니까? (종료시 exit 입력): ");
            exit = sc.next();
            if(exit.equals("exit"))
                break;
        }
    }
}