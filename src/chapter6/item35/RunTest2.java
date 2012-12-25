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
public class RunTest2 {
    public static void main(String[] args) {
        Class<Sample2> testClass = Sample2.class;
        int tests = 0;
        int passed = 0;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception> excType = m.getAnnotation(
                            ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: excepted %s, got %s%n", m,
                                excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
