package level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 속성 - 변수 private 접근 제어자 설정
    private List<Integer> result = new ArrayList<>();

    // 생성자

    // 기능
    // getter
    public List<Integer> getResult() {
        return this.result;
    }

    // setter
    public void setResult(List<Integer> result) {
        this.result = result;
    }

    // 사칙연산 수행 및 계산 결과를 컬렉션에 더해주는 메서드
    public void calculate(int num1, int num2, char operator) {

        switch (operator) {
            case '+':
                result.add(num1 + num2);
                break;
            case '-':
                result.add(num1 - num2);
                break;
            case '*':
                result.add(num1 * num2);
                break;
            case '/':
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
}