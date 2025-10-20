package level_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            int num1 = readInt(sc, "첫 번째 숫자 입력: ");

            char operator;
            // 사칙연산 입력 검증
            while (true) {
                System.out.print("사칙연산 기호 입력 (+, -, *, /): ");
                operator = sc.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("올바른 연산자가 아닙니다.");
                }
            }

            // 나눗셈 연산에 0으로 나누기 방지
            int num2;
            while (true) {
                num2 = readInt(sc, "두 번째 숫자 입력: ");
                if (operator == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    break;
                }
            }

            // 사칙연산 계산기 메서드 호출
            calculator.calculate(num1, num2, operator);
            System.out.println("계산 결과: " + num1 + " " + operator + " " + num2 + " = " + calculator.getResult().get(0));
            // 계산 결과가 담긴 컬렉션을 출력
            System.out.println("\n-----계산 결과 리스트-----");
            System.out.println(calculator.getResult());

            System.out.println("\n더 계산하시겠습니까? (del 입력 시 삭제, exit 입력 시 종료)");


            /* 반복문 종료 */
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("del")) {
                calculator.removeResult();
                System.out.println("-----삭제 후 리스트-----");
                System.out.println(calculator.getResult() + "\n");
            }

        }
    }

    // 정수 값만 입력 받도록 검증하는 메서드
    public static int readInt(Scanner sc, String msg) {
        int num = 0;
        while (true) {
            try {
                System.out.print(msg);
                num = sc.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("❗숫자만 입력할 수 있습니다 ❗");
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
