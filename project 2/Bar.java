public class Bar {

   public static void main(String[] args) {
      int bar = bar(4, 5);
      System.out.print(bar);
   }

   public static int bar(int a, int b) {
      if (b == 0) {
         return 0;
      }
      else if(b % 2 == 0) {
         return bar(a + a, b / 2);
      }
      else {
         return bar(a + a, b/ 2) + a;
      }
   }
   
}