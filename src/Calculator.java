import java.util.*;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private final ArrayList<Integer> save;
    private Integer answer;

    public Calculator() {
        save = new ArrayList<>();
    }

    public void getSaveList() {
        System.out.print("저장된 수 현황: ");
        for (int ea : save) {
            System.out.print("[" + ea + "], ");
        }
    }

    public void setSaveList() {
        Collections.sort(save);
    }

    public void calculate(int a, char calc, int b) {
        answer = null;
        if (a < 0 || b < 0) System.err.println("음수 입력은 허용되지 않습니다.");
        else {
            switch (calc) {
                case '+':
                    answer = a + b;
                    break;
                case '-':
                    answer = a - b;
                    break;
                case '*':
                    answer = a * b;
                    break;
                case '/':
                    if (b == 0) System.err.println("값이 안나옵니다.");
                    else answer = a / b;
                    break;
                default:
                    System.err.println("흠.. 뭔가 잘못된 것 같습니다.");
                    break;
            }
        }
        if (answer != null) save.add(answer);
   }

    public void removeResult() {
        save.clear();
    }

   @Override
    public String toString() {
        return "결과: " + answer;
   }
}
