import java.util.Comparator;
import java.util.Arrays;

public class Term implements Comparable<Term> {

   String query;
   long weight;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) { 
      if (query == null) {
         throw new NullPointerException();
      }
      if (weight < 0) {
         throw new IllegalArgumentException();
      }
      this.query = query;
      this.weight = weight;
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
               return Long.valueOf(t2.weight).compareTo(Long.valueOf(t1.weight));
            }
         };
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) { 
      if(length <= 0) {
         throw new IllegalArgumentException();
      }
      return Comparator.comparing((Term term) -> term.query);
      
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      //return query.compareToIgnoreCase(term.query);
      return this.query.compareTo(other.query);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return getQuery() + " " + getWeight();
   }
   
   public String getQuery() {
      return query;
   }
   
   public long getWeight() {
      return weight;
   }

}
