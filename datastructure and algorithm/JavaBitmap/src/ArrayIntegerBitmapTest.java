import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.event.ListSelectionEvent;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Jiexin Guo
 */
public class ArrayIntegerBitmapTest {
    
    private List<Integer> getRandomIntegers(Random random, int size, int upperBound) {
        List<Integer> result = new ArrayList<>();
        while (size > 0) {
            int temp = random.nextInt(upperBound);
            result.add(temp);
            size--;
        }
        return result;
    }

    @Test
    public void test() {
        long seed = 1000;
        int size = 500;
        int upperBound = 100000;
        Random random = new Random(seed);
        Bitmap<Integer> bitmap = new ArrayIntegerBitmap();
        List<Integer> noDuplicate = this.getRandomIntegers(random, size, upperBound);
        Set<Integer> temp = new HashSet<>();
        temp.addAll(noDuplicate);
        noDuplicate.clear();
        temp.stream().forEach(element -> noDuplicate.add(element));
        bitmap.add(noDuplicate);
        Collections.sort(noDuplicate);
        List<Integer> sortedResult = bitmap.getSortedArray();
        assertTrue(sortedResult.size() == noDuplicate.size());
        size = sortedResult.size();
        System.out.println("real size of the list:"+size);
        for (int i = 0; i < size; i++) {
            assertEquals(sortedResult.get(i), noDuplicate.get(i));
        }
    }

}
