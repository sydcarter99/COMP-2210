import java.util.Arrays;
/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Sydney Carter (slc0070@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  09/02/2020
*
*/
public final class Selector {

/**
  * Can't instantiate this class.
  *
  * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
  *
  */
   public static int min(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int minimum = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] < minimum) {
            minimum = a[i];
         }
      }
      return minimum;
   }
   
/**
  * Selects the minimum value from the array a. This method
  * throws IllegalArgumentException if a is null or has zero
  * length. The array a is not changed by this method.
  */
   public static int max(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int maximum = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] > maximum) {
            maximum = a[i];
         }
      }
      return maximum;
   }
   
/**
  * Selects the kth minimum value from the array a. This method
  * throws IllegalArgumentException if a is null, has zero length,
  * or if there is no kth minimum value. Note that there is no kth
  * minimum value if k < 1, k > a.length, or if k is larger than
  * the number of distinct values in the array. The array a is not
  * changed by this method.
  */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k > a.length || k <= 0) {
         throw new IllegalArgumentException();
      }
      int duplicateCount = 0;
      for (int i = 0; i < a.length -1; i++) {
         if (a[i] == a[i + 1]) {
            duplicateCount ++;
         }
      }
      if (k > a.length - duplicateCount) {
         throw new IllegalArgumentException();
      }
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      //int duplicates = 0;
      int total = 0;
      for (int i = 0; i < k - 1; i++) {
         if (b[i] == b[i + 1]) {
            k++;
         }
      }
      //total = b.length - duplicates;
      //if (k > total) {
         //throw new IllegalArgumentException();
      //}
      //int[] c = Arrays.copyOf(b, b.length);
      //int j = 0;
      //int i = 1;
      //while (i < c.length) {
         //if (c[i] == c[j]) {
            //i++;
         //}
         //else {
            //j++;
            //c[j] = c[i];
            //i++;
         //}
      //}
      int kmin = b[k - 1];
      //int kminimum = a[0];
      //Arrays.<Integer>sort(a);
      
   //sort first, check for duplicates
      return kmin;
   }
   
/**
  * Selects the kth maximum value from the array a. This method
  * throws IllegalArgumentException if a is null, has zero length,
  * or if there is no kth maximum value. Note that there is no kth
  * maximum value if k < 1, k > a.length, or if k is larger than
  * the number of distinct values in the array. The array a is not
  * changed by this method.
  */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int duplicateCount = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] == a[i + 1]) {
            duplicateCount++;
         }
      }
      if (k > a.length - duplicateCount) {
         throw new IllegalArgumentException();
      }
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      //int duplicates = 0;
      //int uniqueTotal = 0;
      for (int i = 0; i < k - 1; i++) {
         if (b[i] == b[i + 1]) {
            k++;
         }
      }
      //uniqueTotal = b.length - duplicates;
      //if (k > uniqueTotal) {
         //throw new IllegalArgumentException();
      //}
      //int[] c = Arrays.copyOf(b, b.length);
      //int j = 0;
      //int i = 1;
      //while (i < c.length) {
         //if (c[i] == c[j]) {
            //i++;
         //} 
         //else {
            //j++;
            //c[j] = c[i];
            //i++;
         //}
      //}
      int kmax = b[k - 1];
      return kmax;
      //Arrays.<Integer>sort(a);
      //return a[a.length - k];
   }
   
/**
  * Returns an array containing all the values in a in the
  * range [low..high]; that is, all the values that are greater
  * than or equal to low and less than or equal to high,
  * including duplicate values. The length of the returned array
  * is the same as the number of values in the range [low..high].
  * If there are no qualifying values, this method returns a
  * zero-length array. Note that low and high do not have
  * to be actual values in a. This method throws an
  * IllegalArgumentException if a is null or has zero length.
  * The array a is not changed by this method.
  */
   public static int[] range(int[] a, int low, int high) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int count = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            count ++;
         }
      }
      int rangeArray[] = new int [count];
      int count2 = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            rangeArray[count2] = a[i];
            count2++;
         }
      }
      return rangeArray;
   }
   
/**
  * Returns the smallest value in a that is greater than or equal to
  * the given key. This method throws an IllegalArgumentException if
  * a is null or has zero length, or if there is no qualifying
  * value. Note that key does not have to be an actual value in a.
  * The array a is not changed by this method.
  */
   public static int ceiling(int[] a, int key) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int i;
      int flag = 0;
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      //int ceilVal = a[i];
      for (i = 0; i < b.length; i++) {
         if (b[i] >= key) {
            flag = 1;
            break;
         }
      }
      if (flag == 0) {
         throw new IllegalArgumentException();
      }
      int ceilVal = b[i];
      for (; i < b.length; i++) {
         if (b[i] >= key && b[i] <= ceilVal) {
            b[i] = ceilVal;
         }
      }
      
      return ceilVal;
   }
   
/**
  * Returns the largest value in a that is less than or equal to
  * the given key. This method throws an IllegalArgumentException if
  * a is null or has zero length, or if there is no qualifying
  * value. Note that key does not have to be an actual value in a.
  * The array a is not changed by this method.
  */
   public static int floor(int[] a, int key) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int i;
      int flag = 0;
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      for (i = 0; i < b.length; i++) {
         if (b[i] <= key) {
            flag = 1;
            break;
         }
      }
      if (flag == 0) {
         throw new IllegalArgumentException();
      }
      int floorVal = b[i];
      for (; i < b.length; i++) {
         if (b[i] <= key && b[i] >= floorVal) {
            floorVal = b[i];
         }
      }
      return floorVal;
   }

}