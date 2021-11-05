import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Sydney Carter (slc0070@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-11-24
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   String firstKgram;

   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      int k = K;
      int s = 0;
      int z = 0;
      firstKgram = sourceText.substring(0, k);
      while(s + k <= sourceText.length()) {
         String empty = "";
         String kg = sourceText.substring(s, s + k);
         if (!model.containsKey(kg)) {
            int j = k;
            while (z + j < sourceText.length()) {
               String g = sourceText.substring(z, z + j);
               if (z + k >= sourceText.length()) {
                  empty += '\u0000';
               }
               if (kg.equals(g)) {
                  empty += sourceText.substring(z + j, z + j + 1);
               }
               z++;
            }
            model.put(kg, empty);
         }
         z = 0;
         s++;
      }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return firstKgram;
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      int s = model.size();
      int z = 0;
      Random randomKgram = new Random();
      int index = randomKgram.nextInt(s);
      for (String n : model.keySet()) {
         if (index == z) {
            return n;
         }
         z++;
      }
      return null;
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      Random randomKgram = new Random();
      String empty = "";
      int z = 0;
      for(String n: model.keySet()) {
         if (n.equals(kgram)) {
            empty = model.get(kgram);
            int i = empty.length();
            if (i > 0) {
               z = randomKgram.nextInt(i) + 1;
            
            }
         }
      }
      int q = z - 1;
      if (!empty.equals("")) {
         return empty.charAt(q);
      }
   
      return '\u0000';
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
