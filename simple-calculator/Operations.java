public class Operations {
   public static int add(int a, int b) {
      return a + b;
   }

   public static int subtract(int a, int b) {
      return a - b;
   }

   public static int multiply(int a, int b) {
      return a * b;
   }

   public static int divide(int a, int b) {
      if (b == 0) {
         return 0;
      } else {
         return a / b;
      }
   }

   public static int modulus(int a, int b) {
      return a % b;
   }

   public static int average(int[] numbers) {
      int sum = 0;

      for (int number : numbers) {
         sum += number;
      }

      return sum / numbers.length;
   }
}
