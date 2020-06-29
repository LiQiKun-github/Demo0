package ai;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Engine {
    private static final int MAX_RAND_SEARCH_COUNT = 5040;
    final static String[] OPS = "+ - * /".split(" ");

    public static void main(String[] args) {
        System.out.println(solve24(1, 2, 3, 4));
        System.out.println(randSearcher(new int[]{1, 5, 5, 5}));
        System.out.println(randSearcher(new int[]{1, 2, 3, 4}));
        System.out.println(randSearcher(new int[]{1, 5, 7, 1}));
        System.out.println(randSearcher(new int[]{1, 1, 1, 1}));
    }

    private static String randSearcher(int[] a) {
        for (int j = 0; j < 4 * 4 * 4; j++) {
            String[] ops = new String[3];
            int x = j / 16;
            int y = j % 16 / 4;
            int z = j % 4;
            ops[0] = OPS[x];
            ops[1] = OPS[y];
            ops[2] = OPS[z];

            List<String> exp = new Vector<>();
            for (Integer i : a) {
                exp.add(Integer.toString(i));
            }
            for (String op : ops) {
                exp.add(op);

            }

            int tot = 0;
            while (++tot < MAX_RAND_SEARCH_COUNT) {
                Collections.shuffle(exp);
                double result = RPolandExpression.eval(exp);
                if (result == 24) {
                    return (exp).toString();
                }
            }
        }
        return "No solution";
    }

    public static String solve24(int a, int b, int c, int d) {


        return randSearcher(new int[]{a,b,c,d});
    }
}
