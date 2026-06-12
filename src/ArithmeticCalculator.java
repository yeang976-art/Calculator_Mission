import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticCalculator<N extends Number> {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private final List<Double> save;
    private Double answer;

    public ArithmeticCalculator() {
        save = new ArrayList<>();
    }

    public void getSaveList() {
        System.out.print("저장된 수 현황: ");
        for (double ea : save) {
            System.out.print("[" + ea + "], ");
        }
    }

    public void setSaveList() {
        Collections.sort(save);
    }

    // 모든 숫자형 타입을 받은 후 계산 결과를 Double로 저장한다
    public void calculate(N a, char calc, N b) {
        answer = null;
        double x = a.doubleValue();
        double y = b.doubleValue();

        if (x < 0.0 || y < 0.0) throw new IllegalArgumentException("NEGATIVE_NUMBER");
        else {
            OperatorType operator = OperatorType.from(calc);
            answer = operator.calculate(x, y);
            save.add(answer);
        }
    }

    public void printResultsGreaterThan(N target, String id) {
        double standard = target.doubleValue();

        String results = save.stream()
                .filter(result -> result > standard)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        if (results.isEmpty()) {
            System.out.print("\n저장된 결과 중 "+id+"번째 숫자보다 큰 수: 없습니다.");
        } else {
            System.out.print("\n저장된 결과 중 "+id+"번째 숫자보다 큰 수: " + results);
        }
    }

    public void removeResult() {
        save.clear();
    }

    @Override
    public String toString() {
        return "결과: " + answer;
    }
}
