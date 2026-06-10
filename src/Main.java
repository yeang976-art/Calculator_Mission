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
    sc.close();
}

