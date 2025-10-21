package level_3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 입력하고 있는 값은 하나인데 List로 받아올 필요 없음 Double
             double num1 = readDouble(sc, "첫 번째 숫자 입력: ");

            // 열거형 참조변수 선언
            OperatorType operatorType;

            // 사칙연산 입력 검증 메서드의 char형 인자변수 선언
            char input;
            // 사칙연산 입력 검증
            while (true) {
                try {
                    System.out.print("사칙연산 기호 입력 (+, -, *, /): ");

                    input = sc.next().charAt(0);
                    // 사칙연산 입력 메서드 호출 및 반환
                    operatorType = OperatorType.fromChar(input);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // 나눗셈 연산에 0으로 나누기 방지
            double num2;
            while (true) {
                num2 = readDouble(sc, "두 번째 숫자 입력: ");
                if (operatorType.getOperator() == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    break;
                }
            }

            // 사칙연산 계산기 메서드 호출
            calculator.calculate(num1, num2, operatorType);
            System.out.println("계산 결과: " + num1 + " " + operatorType.getOperator() + " " + num2 + " = " + calculator.getResult().get(calculator.getResult().size()-1));
            // 계산 결과가 담긴 컬렉션을 출력
            System.out.println("\n-----계산 결과 리스트-----");
            System.out.println(calculator.getResult());

            System.out.println("\n계속 계산하려면 아무 키나 입력하세요 (big: 큰 값 조회 / del: 삭제 / exit: 종료)");

            String userChoice = sc.next();

            // exit 입력시 계산기 종료
            if (userChoice.equalsIgnoreCase("exit")) {
                break;
            } else if (userChoice.equalsIgnoreCase("del")) {
                // del 입력시 리스트의 첫 번째 저장 값 삭제
                while (true) {
                    if (calculator.getResult().isEmpty()) {
                        System.out.println("리스트가 비어 있어 삭제할 수 없습니다.\n");
                        break;
                    }
                    calculator.removeResult();
                    System.out.println("-----삭제 후 리스트-----");
                    System.out.println(calculator.getResult() + "\n");
                    System.out.println("더 삭제하시려면 아무 키 입력\n계산으로 돌아가기는 cal 입력");
                    if (sc.next().equalsIgnoreCase("cal")) {
                        break;
                    }
                }
            } else if (userChoice.equalsIgnoreCase("big")) {
                // big 입력시 스캐너로 입력받은 값보다 큰 값 비교하여 출력하기
                while (true) {
                    if (calculator.getResult().isEmpty()) {
                        System.out.println("리스트가 비어 있어 조회할 수 없습니다.");
                        break;
                    } else {
                        System.out.println("-----현재 리스트-----");
                        System.out.println(calculator.getResult() + "\n");
                        System.out.print("비교할 값 입력: ");
                        double N = sc.nextDouble();
                        calculator.printBigResult(N);
                        System.out.println("더 비교하시려면 아무 키 입력\n계산으로 돌아가기는 cal 입력");
                        if (sc.next().equalsIgnoreCase("cal")) {
                            break;
                        }
                    }
                }
            }
        }
    }

    // 정수 값만 입력 받도록 검증하는 메서드 - double로 받기
    public static double readDouble(Scanner sc, String msg) {
        double num = 0.0;
        while (true) {
            try {
                System.out.print(msg);
                num = sc.nextDouble();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("❗숫자만 입력할 수 있습니다 ❗");
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
