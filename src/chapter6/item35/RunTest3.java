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
public class RunTest3 {
    public static void main(String[] args) {
        Class<Sample3> testClass = Sample3.class;
        int tests = 0;
        int passed = 0;
        for (Method m : testClass.getDeclaredMethods()) {
            tests++;
            try {
                m.invoke(null);
                System.out.printf("Test %s failed: no exception%n", m);
            } catch (InvocationTargetException e) {
                Throwable exc = e.getCause();
                Class<? extends Exception>[] excTypes = m.getAnnotation(
                        ExceptionTest2.class).value();
                int oldPassed = passed;
                for (Class<? extends Exception> excType : excTypes) {
                    if (excType.isInstance(exc)) {
                        passed++;
                        break;
                    }
                }
                if (passed == oldPassed) {
                    System.out.printf("Test %s failed: %s%n", m, exc);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
