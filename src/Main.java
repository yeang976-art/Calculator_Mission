import java.util.*;

void main() {
    Scanner sc = new Scanner(System.in);
    String esc = "";
    System.out.println("[사칙연산 계산기]");

    // Step 1
    /*
     while (!esc.equals("exit")) {
            System.out.println("첫 번째 숫자를 입력하시오");
            int a = sc.nextInt();
            System.out.println("'+','-','*','/' 연산기호 중 하나를 입력하시오");
            char l = sc.next().charAt(0);
            System.out.println("두 번째 숫자를 입력하시오");
            int b = sc.nextInt();

            switch (l) {
                case '+':
                    System.out.println("결과: " + (a + b));
                    break;
                case '-':
                    System.out.println("결과: " + (a - b));
                    break;
                case '*':
                    System.out.println("결과: " + (a * b));
                    break;
                case '/':
                    if (b == 0) {
                        System.err.println("결과: 값이 안나옵니다.");
                    } else {
                        System.out.println("결과: " + (a / b));
                    }
                    break;
                default:
                    System.err.println("결과: 흠.. 뭔가 잘못된 것 같습니다.");
                    break;
            }
        sc.nextLine();
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        esc = sc.nextLine();
    }
    sc.close(); */

    // Step 2
    /*
    Calculator calculator1 = new Calculator();
    while (!esc.equals("exit")) {
        System.out.println("첫 번째 숫자를 입력하시오");
        int a = sc.nextInt();
        System.out.println("'+','-','*','/' 연산기호 중 하나를 입력하시오");
        char l = sc.next().charAt(0);
        System.out.println("두 번째 숫자를 입력하시오");
        int b = sc.nextInt();

        calculator1.calculate(a,l,b);
        System.out.println(calculator1);
        calculator1.setSaveList(); // 오름차순 정렬
        calculator1.getSaveList();

        sc.nextLine();
        System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
        esc = sc.nextLine();
    }
    calculator1.removeResult();
    sc.close(); */

    // Step 3
    ArithmeticCalculator<Integer> calculator2 = new ArithmeticCalculator<>();
    while (!esc.equals("exit")) {
        try {
            System.out.println("첫 번째 숫자를 입력하시오");
            int a = sc.nextInt();
            System.out.println("'+','-','*','/' 연산기호 중 하나를 입력하시오");
            char l = sc.next().charAt(0);
            System.out.println("두 번째 숫자를 입력하시오");
            int b = sc.nextInt();

            calculator2.calculate(a, l, b);
            System.out.println(calculator2);
            calculator2.setSaveList(); // 오름차순 정렬
            calculator2.getSaveList();
            calculator2.printResultsGreaterThan(a, "첫");
            calculator2.printResultsGreaterThan(b, "두");

        } catch (InputMismatchException e) {
            System.err.println("[ERR-1001] 숫자를 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            if ("NEGATIVE_NUMBER".equals(e.getMessage())) {
                System.err.println("[ERR-1003] 음수 입력은 허용되지 않습니다.");
            } else {
                System.err.println("[ERR-1002] 지원하지 않는 연산자입니다.");
            }
        } catch (ArithmeticException e) {
            System.err.println("[ERR-2001] 계산할 수 없습니다.");
        } catch (NoSuchElementException e) {
            System.err.println("[ERR-1005] 입력값이 없습니다.");
        } catch (IllegalStateException e) {
            System.err.println("[ERR-9001] 입력 장치가 닫혀 있습니다.");
        }

        sc.nextLine();
        System.out.println("\n계속하려면 아무 키나 입력하고, 종료하려면 exit을 입력하세요.");
        esc = sc.nextLine();
    }
    calculator2.removeResult();
    sc.close();
}

