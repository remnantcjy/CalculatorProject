package level_3;

public enum OperatorType {
    ADD('+') {
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACT('-') {
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        @Override
        public double apply(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        @Override
        public double apply(double num1, double num2) {
            return num1 / num2;
        }
    };

    // 클래스 생성자와 멤버
    private final char operator;
    // enum - 기본 접근제어자 private (생략 가능)
    OperatorType(char operator) {
        this.operator = operator;
    }

    // getter
    public char getOperator() {
        return this.operator;
    }

    // 열거 객체의 메소드에 사용될 추상 메서드 정의
    public abstract double apply(double num1, double num2);

    // 입력된 문자가 유효한 연산자인지 검증하고, 해당 operatorType을 반환
    public static OperatorType fromChar(char input) {
        for (OperatorType operatorType : values()) {
            if (operatorType.getOperator() == input) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다: " + input);
    }
}

