import java.util.Comparator;
import java.util.Arrays;
public class Autocomplete {

   Term terms[];

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) { 
      if (terms == null) {
         throw new NullPointerException();
      }
      Arrays.sort(terms); // lexographical sorted order
      this.terms = terms;
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) { 
      int l = prefix.length();
      Comparator<Term> comp = Term.byPrefixOrder(l); // comparator do range search by prefix
      Term key = new Term(prefix, -1); // here weight -1 is dummy/meaningless
      int idx1 = BinarySearch.firstIndexOf(terms, key, comp);
      int idx2 = BinarySearch.lastIndexOf(terms, key, comp);
                
      if(idx1 == -1) { // no data found
         throw new NullPointerException();
      } else { // data found
         // copy and sort based on weight in descending order
         Term found[] = new Term[idx2 - idx1 + 1];
         for(int i = idx1; i <= idx2; i++) {
            found[i - idx1] = terms[i];
         }
         Arrays.sort(found, Term.byDescendingWeightOrder());
         return found;
      }
   }

}
