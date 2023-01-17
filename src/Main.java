import java.util.Scanner;

public class Main {
    public static String checkInput() {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        if (input.length() == 0 || input.length() > 8) {
            System.out.println("Invalid input. String should have more than 0 and less than 8 characters.");
            return checkInput();
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != 'Y' && c != 'I') {
                System.out.println("Invalid input. Only Y and I are allowed.");
                return checkInput();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("Введите символы I и Y(не менее одного и не более семи): ");

        String inputArg = checkInput();

        char[] strToArray = inputArg.toCharArray();

        Solution.solution(strToArray);
    }
}