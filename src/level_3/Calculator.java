package level_3;

import java.util.ArrayList;
import java.util.List;

import static level_3.OperatorType.*;

public class Calculator {
    // 속 - 변수 private 접근 제어자 설정
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<Integer> result = new ArrayList<>();

    // 생성자의 특징
    // 1. 클래스명이 동일하다.
    // 2. 반환 데이터 타입이 없다.
    // 3. 여러 개가 존재할 수 있다.

    // 기
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