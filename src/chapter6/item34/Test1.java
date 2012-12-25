/**
 * 
 */
package chapter6.item34;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * 
 * @author Mars Zheng
 */
public class Test1 {
    public static void main(String[] args) {
        double x = 4.0;
        double y = 2.0;
        test(BasicOperation.class, x, y);
        test(Arrays.asList(BasicOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet,
            double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x,
            double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
