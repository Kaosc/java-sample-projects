import java.util.Scanner;

public class Calculator {
    static boolean invalidChoice = false;

    void printOptions() {
        if (invalidChoice) {
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nInvalid choice! Please enter a number between 1 and 7.\n");
            invalidChoice = false;
        }

        System.out.println("\n--- Select operation ---\n");
        System.out.println("[1] Add");
        System.out.println("[2] Subtract");
        System.out.println("[3] Multiply");
        System.out.println("[4] Divide");
        System.out.println("[5] Modulus");
        System.out.println("[6] Average");
        System.out.println("[7] Exit\n");
    }

    void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printOptions();
            System.out.print("Enter your choice:");

            int choice = 0;

            // Catch if user enters a non-integer value
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                invalidChoice = true;
                scanner.nextLine(); // consume the newline character
                continue;
            }

            if (choice < 1 || choice > 7) {
                invalidChoice = true;
                continue;
            }

            if (choice == 7) {
                break;
            }

            if (choice == 6) {
                scanner.nextLine(); // consume the newline character

                while (true) {
                    String strNumberInput;
                    String[] strNumberList;
                    int[] numbers;

                    System.out.print("\n> Enter 10 numbers separated by space: ");
                    strNumberInput = scanner.nextLine().trim();

                    strNumberList = strNumberInput.split(" ");

                    if (strNumberList.length > 10) {
                        System.out.println("\nToo many numbers! Please enter 10 numbers separated by space.");
                        continue;
                    }

                    numbers = new int[strNumberList.length];

                    try {
                        for (int i = 0; i < strNumberList.length; i++) {
                            numbers[i] = Integer.parseInt(strNumberList[i]);
                        }

                        System.out.println("\n>> Avarage result: " + Operations.average(numbers));
                    } catch (Exception e) {
                        System.out.println("\nInvalid input! Please enter valid integers separated by space.");
                        continue;
                    }

                    break;
                }
            } else {

                while (true) {

                    int a = 0, b = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.print("> Enter first number: ");
                            a = scanner.nextInt();
                            System.out.print("> Enter second number: ");
                            b = scanner.nextInt();
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("\nInvalid input! Please enter valid integers.\n");
                            scanner.nextLine(); // consume the invalid input
                        }
                    }

                    String operationResult = "";

                    switch (choice) {
                        case 1:
                            operationResult = "Addition result: " + Operations.add(a, b);
                            break;
                        case 2:
                            operationResult = "Subtraction result: " + Operations.subtract(a, b);
                            break;
                        case 3:
                            operationResult = "Multiplication result: " + Operations.multiply(a, b);
                            break;
                        case 4:
                            if (b == 0) {
                                operationResult = "Division by zero is not allowed!";
                                break;
                            }

                            operationResult = "Division result: " + Operations.divide(a, b);
                            break;
                        case 5:
                            operationResult = "Modulus result: " + Operations.modulus(a, b);
                            break;
                    }

                    if (!operationResult.isEmpty()) {
                        System.out.println("\n>> " + operationResult);
                    }

                    break;
                }

            }

        }

        scanner.close();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.execute();
    }
}