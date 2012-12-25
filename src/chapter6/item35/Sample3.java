/**
 * 
 */
package chapter6.item35;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Mars Zheng
 */
public class Sample3 {

    @ExceptionTest2({ IndexOutOfBoundsException.class,
            NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
