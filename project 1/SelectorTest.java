import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** test 1 for min **/
   @Test public void minTest() {
      int[] a = {5, 7, 4, 8, 3};
      int expected = Selector.min(a);
      Assert.assertEquals("min test 1", 3, expected);
   }
   
   /** test 1 for max **/
   @Test public void maxTest() {
      int[] a = {1, 5, 7, 4, 8, 3};
      int expected = Selector.max(a);
      Assert.assertEquals("max test 1", 8, expected);
   }

   /** test 1 for kmin **/
   @Test public void kminTest() {
      int[] a = {-5, -7};
      int expected = Selector.kmin(a, 1);
      Assert.assertEquals("kmin test 1", -7, expected);
   }
   
   /** test 2 for kmin **/
   @Test public void kminTest2() {
      int[] a = {1, 5, 7, 4, 8, 3};
      int expected = Selector.kmin(a, 2);
      Assert.assertEquals("kmin test 2", 3, expected);
   }
   
   /** test 1 for kmax **/
   @Test public void kmaxTest1() {
      int[] a = {1, 5, 7, 4, 8, 3};
      int expected = Selector.kmax(a, 5);
      Assert.assertEquals("kmax test 1", 3, expected);
   }
   
   /** test 2 for kmax **/
   @Test public void kmaxTest2() {
      int[] a = {1, 5, 7, 4, 8, 3};
      int expected = Selector.kmax(a, 2);
      Assert.assertEquals("kmin test 2", 7, expected);
   }
   
   /** test 1 for range **/
   @Test public void rangeTest1() {
      int[] a = {2, 8, 7, 3, 4};
      int[] expected = Selector.range(a, 1, 5);
      int[] actual = {2, 3, 4};
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 1 for ceiling **/
   @Test public void ceilingTest1() {
      int[] a = {2, 8, 7, 3, 4};
      int expected = Selector.ceiling(a, 6);
      int actual = 7;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 2 for ceiling **/
   @Test public void ceilingTest2() {
      int[] a = {5, 9, 1, 7, 3};
      int expected = Selector.ceiling(a, 7);
      int actual = 7;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 3 for ceiling **/
   @Test public void ceilingTest3() {
      int[] a = {8, 7, 6, 5, 4};
      int expected = Selector.ceiling(a, 0);
      int actual = 4;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 4 for ceiling **/
   @Test public void ceilingTest4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int expected = Selector.ceiling(a, 5);
      int actual = 7;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 5 for ceiling **/
   @Test public void ceilingTest5() {
      int[] a = {7, 9};
      int expected = Selector.ceiling(a, 9);
      int actual = 9;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 1 for floor **/
   @Test public void floorTest1() {
      int[] a = {7, 9};
      int expected = Selector.floor(a, 9);
      int actual = 9;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 2 for floor **/
   @Test public void floorTest2() {
      int[] a = {-3, 0, 3, 7, 9};
      int expected = Selector.floor(a, 9);
      int actual = 9;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
   
   /** test 2 for floor **/
   @Test public void floorTest3() {
      int[] a = {3, 7, 1, 9, 5};
      int expected = Selector.floor(a, 9);
      int actual = 9;
      Assert.assertEquals("kmin test 2", actual, expected);
   }
}
