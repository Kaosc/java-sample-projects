public class Operations {
   int add(int a, int b) {
      return a + b;
   }

   int subtract(int a, int b) {
      return a - b;
   }

   int multiply(int a, int b) {
      return a * b;
   }

   int divide(int a, int b) {
      if (b == 0) {
         return 0;
      } else {
         return a / b;
      }
   }

   int modulus(int a, int b) {
      return a % b;
   }

   int average(int[] numbers) {
      int sum = 0;

      for (int number : numbers) {
         sum += number;
      }

      return sum / numbers.length;
   }
}
