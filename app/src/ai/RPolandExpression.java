package ai;

import java.util.Stack;

public class RPolandExpression {
    static final double ERROR = -1;

    public static void main(String[] args) {
        System.out.println(eval("1 2 + 3 4 + *") == 21.0);//ok
        System.out.println(eval("+ 1 2") == ERROR);//error
        System.out.println(eval("1 2 +") == 3.0);

    }

    private static double eval(String s) {
        Stack<Double> S = new Stack<>();
        String[] exp = s.split("\\s+");
        for (String tok : exp) {
            if (isNumber(tok)) {
                S.push(Double.parseDouble(tok));
            } else {
                if (S.isEmpty()) {
                    return ERROR;
                }
                double b = S.peek();
                S.pop();
                if (S.isEmpty()) {
                    return ERROR;
                }
                double a = S.peek();
                S.pop();
                double c = 0;
                switch (tok) {
                    case "+":
                        c = a + b;
                        break;
                    case "*":
                        c = a * b;
                        break;

                }
                S.push(c);
            }

        }
        return S.size() != 1 ? ERROR : S.peek();
    }

    private static boolean isNumber(String tok) {
        try {
            Double.parseDouble(tok);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
