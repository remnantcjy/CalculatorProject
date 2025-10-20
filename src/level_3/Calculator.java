package level_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    // 속성
    // 계산 결과를 담을 Double형 리스트
    private List<Double> result = new ArrayList<>();

    // 생성자

    // 기능
    // getter
    public List<Double> getResult() {
        return this.result;
    }

    // setter
    public void setResult(List<Double> result) {
        this.result = result;
    }

    // 사칙연산 수행 및 계산 결과를 컬렉션에 더해주는 메서드
    public void calculate(double num1, double num2, OperatorType operator) {

        switch (operator) {
            case ADD:
                result.add(num1 + num2);
                break;
            case SUBTRACT:
                result.add(num1 - num2);
                break;
            case MULTIPLY:
                result.add(num1 * num2);
                break;
            case DIVIDE:
                result.add(num1 / num2);
                break;
            default:
                break;
        }
    }


    // 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void removeResult() {
        System.out.println("\n" + result.get(0) + "을 삭제합니다.");
        result.remove(result.get(0));
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
    public void printBigResult(double N) {
        List<Double> collect = result.stream()
                .filter(i -> i > N)      // 입력받은 N 값보다 큰 요소만 필터링
                .toList();                      // 결과를 새로운 리스트로 수집
        System.out.println((int)N + "보다 큰 값: " + collect + "\n");
    }
}