/**
 * 
 */
package chapter6.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * 
 * @author Mars Zheng
 */
public class RunTest {

    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        Class<Sample> testClass = Sample.class;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
