import java.util.List;

/**
 * 
 */

/**
 * A bitmap interface. This bitmap only holds none duplicate numbers(those duplicates will be abandoned).
 * @author Jiexin Guo
 */
public interface Bitmap <T extends Number>{
    /**
     * Add an element to bitmap.
     * @param elem the element to be added.
     * @return true if the element is added successfully(not in the bitmap);false if it is not added successfully.
     */
    boolean add(T elem);
    /**
     * Add a list of elements into the bitmap.
     * @param elems
     * @return
     */
    boolean add(List<? extends Number> elems);
    /**
     * Remove an element from bitmap;
     * @param elem the element to be removed.
     * @return true if the element is removed successfully(it is in the bitmap).
     */
    boolean remove(T elem);
    /**
     * See if the element is inside the bitmap.
     * @param elem
     * @return
     */
    boolean exists(T elem);
    List<T> getSortedArray();
}
