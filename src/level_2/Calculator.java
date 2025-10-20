package level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 속성 - 변수 private 접근 제어자 설정
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<Integer> result = new ArrayList<>();

    // 생성자의 특징
    // 1. 클래스명이 동일하다.
    // 2. 반환 데이터 타입이 없다.
    // 3. 여러 개가 존재할 수 있다.

    // 기능
    // getter
    public List<Integer> getResult() {
        return this.result;
    }

    // setter
    public void setResult(List<Integer> result) {
        this.result = result;
    }



}