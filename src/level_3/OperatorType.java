package level_3;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/')
    ;

    // 속 - private
    private char operator;

    // enum - 기본 접근제어자 private (생략 가능)
    OperatorType(char operator) {
        this.operator = operator;
    }

    // 기능
    public char getOperator() {
        return this.operator;
    }
}
