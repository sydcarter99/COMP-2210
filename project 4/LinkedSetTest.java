import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedSetTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** test for add method. **/
   @Test public void testAdd() {
      LinkedSet<Integer> a = new LinkedSet<Integer>();
      a.add(4);
      a.add(1);
      a.add(5);
      a.add(3);
      a.add(1);
      a.add(2);
      //Assert.assertEquals("add test", , 2);
      //Iterator<Set<Integer>> itr = a.iterator();
      //while(itr.hasNext()) {
         //System.out.println(itr.next().toString());
      //}
      //System.out.print(a);
   }
}
