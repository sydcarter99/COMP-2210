public class DivideAndConquer {

   public static void main(String[] args) {
      int a[] = {66, 67, 20, 86, 55, 74, 11, 91, 43, 47};
      int max = max(a, 0, 9);
      System.out.print(max);
   }

   public static int max(int[] a, int l, int r) {
      if (l == r) {
         return a[l];
      }
      int mid = (l + r) / 2;
      int lm = max(a, l, mid);
      int rm = max(a, mid + 1, r);
      if (lm > rm) {
         return lm;
      }
      else {
         return rm;
      }
   }
}