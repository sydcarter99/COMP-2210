import java.util.Comparator;
import java.util.Arrays;
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      int start = 0;
      int end = a.length - 1;
      int idx = -1;
      while(start <= end) {
         int mid = (start + end) / 2;
         int c = comparator.compare(a[mid], key);
         if(c >= 0) {
            // take left side to get first index
            if(c == 0) {
             // latest found index
               idx = mid;
            }
            end = mid - 1;
         } else {
          // take right side
            start = mid + 1;
         }
      }
      return idx;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      int start = 0, end = a.length - 1;
      int idx = -1;
      while(start <= end) {
         int mid = (start + end) / 2;
         int c = comparator.compare(a[mid], key);
         if(c <= 0) {
                                // take right side to get last index
            if(c == 0) {
                                        // latest found index
               idx = mid;
            }
            start = mid + 1;
         } else {
                                // take left side
            end = mid - 1;
         }
      }
      return idx;
   }
}
