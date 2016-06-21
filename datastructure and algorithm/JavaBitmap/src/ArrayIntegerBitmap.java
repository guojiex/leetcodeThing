import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Jiexin Guo
 */
public class ArrayIntegerBitmap implements Bitmap<Integer> {
    private int[] bitmap = new int[Integer.MAX_VALUE >> 5 + 1];
    private final int BIT_MASK = 0x1f;
    private int size=0;
    private int getIndex(Number elem) {
        return elem.intValue() >> 5;
    }

    private int getOffset(Number elem) {
        return elem.intValue() & BIT_MASK;
    }

    @Override
    public List<Integer> getSortedArray() {
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bitmap[i] != 0) {
                int j = 0;
                int temp = bitmap[i];
                while (temp != 0) {
                    if ((temp & 1) != 0) {
                        sorted.add((i << 5) + j);
                    }
                    j++;
                    temp >>>= 1;
                }
            }
        }
        return sorted;
    }

    @Override
    public boolean add(Integer elem) {
        boolean numberExists = this.exists(elem);
        if (!numberExists) {
            if(getIndex(elem)>size){
                size=getIndex(elem)+1;
            }
            bitmap[getIndex(elem)] |= (1 << getOffset(elem));
        }
        return !numberExists;
    }

    @Override
    public boolean remove(Integer elem) {
        boolean numberExists = this.exists(elem);
        if (numberExists) {
            bitmap[getIndex(elem)] &= ((~1) << getOffset(elem));
        }
        return numberExists;
    }

    @Override
    public boolean exists(Integer elem) {
        return ((bitmap[getIndex(elem)] >> getOffset(elem)) & 1) == 1;
    }

    @Override
    public boolean add(List<? extends Number> elems) {
        boolean result = true;
        for (Number elem : elems) {
            result &= this.add(elem.intValue());
        }
        return result;
    }

}
