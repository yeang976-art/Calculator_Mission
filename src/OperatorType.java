import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    AD('+',(a,b)-> a + b),
    SB('-',(a,b)-> a - b),
    MT('*',(a,b)-> a * b),
    DV('/',(a,b)-> {
        if (b == 0) throw new ArithmeticException();
        return a / b;
    });

    private final char symbol;
    private final DoubleBinaryOperator operation;

    OperatorType(char symbol, DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double calculate(double a, double b) {
        return operation.applyAsDouble(a, b);
    }

    public static OperatorType from(char symbol) {
        for (OperatorType type : values()) {
            if (type.symbol == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException();
    }
}