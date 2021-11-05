public class divideAndSort {
   public void main(String [] args) {
      int a[] = {66, 67, 20, 86, 55, 74, 11, 91, 43, 47};
      int sort = sort(a, 0, 9);
      System.out.print(sort);
   }
   public int sort(int[] a, int l, int r) {
      if (l == r) {
         return a[l];
      }
      int m = (l + r) / 2;
      sort(a, l, m);
      sort(a, m, r);
      merge(a, l, m, r);
   }
   public void merge(int[] a, int l, int m, int r) {
      for (int k = l; k <= r; k++) {
         int aux[];
         aux[k] = a[k];
      }
      int i = l;
      int j = m + 1;
      for (int k = l; k <= r; k++) {
         if (i > m) {
            a[k] = aux[j++];
         }
         else if(j > r){
            a[k] = aux[i++];
         }
         else if(less(aux[j], aux[i])) {
            a[k] = aux[j++];
         }
         else {
            a[k] = aux[i++];
         }
      }
   }
}