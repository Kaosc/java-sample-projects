import java.util.ArrayList;
import java.util.Arrays;

public class Main {

   public static String[] merge(String[] list1, String[] list2) {
      ArrayList<String> mergedList = new ArrayList<>(Arrays.asList(list1));
      mergedList.addAll(Arrays.asList(list2));

      for (int i = 0; i < mergedList.size(); i++) {
         for (int j = i + 1; j < mergedList.size(); j++) {
            if (mergedList.get(i).equals(mergedList.get(j))) {
               mergedList.remove(j);
               j--; // to avoid skipping the next element
            }
         }

      }

      return mergedList.toArray(new String[0]);
   }

   public static void main(String[] args) {

      String[] shoppingList1 = { "milk", "bread", "egg", "butter", "sugar" };
      String[] shoppingList2 = { "milk", "Bread", "EGG", "butter", "sugar" };

      String[] uniqShoppingList = merge(shoppingList1, shoppingList2);

      System.out.println("\nShopping List: \n");
      for (String item : uniqShoppingList) {
         System.out.println(">> " + item);
      }
      System.out.println("");
   }
}
