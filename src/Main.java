import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create 2d array of States/Capitals
        String[][] stateCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        // Wait for user to press enter to continue program, else prompt again
        waitForEnterKeyPress("Press enter to begin: ");

        // Run single question state/capital city test
        singleCapitalTest(stateCapitals);

        // Wait for user to press enter to continue program, else prompt again
        waitForEnterKeyPress("\nPress enter to take the full test: ");

        // Run full 50 state/capital city test
        allCapitalsTest(stateCapitals);

        // Wait for user to press enter to continue program, else prompt again
        waitForEnterKeyPress("\nPress enter to print the array sorted by state, then again by capital: ");

        // Print the array, sorted by state first, then sorted by capital city
        printArray(stateCapitals);
    }

    public static void singleCapitalTest(String[][] stateCapitals) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for capital name, store input in 'input'
        System.out.print("Enter capital city name of a US state: ");
        String input = scanner.nextLine();

        // Store boolean value of whether user's input exists in array
        boolean inputResult = elementExists(stateCapitals, input);

        // Print appropriate response depending on user input result
        if (inputResult) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }

    public static void allCapitalsTest(String[][] stateCapitals) {
        Scanner scanner = new Scanner(System.in);

        // Create ArrayList to store previous user inputs
        ArrayList<String> prevAnswers = new ArrayList<>();

        // Initialize score and attempts
        int score = 0;
        int attempts = 50;

        System.out.println("\n>> In 50 attempts, name the capitals of each US state <<\n");

        // While 'attempts' is greater than 0, display score/attempts and prompt for capital name
        while (attempts > 0) {
            System.out.println("Current score: " + score);
            System.out.println("Attempts: " + attempts);
            System.out.print("\nCapital city name: ");
            String input = scanner.nextLine();

            // Store boolean value of whether user's input exists in array
            boolean inputResult = elementExists(stateCapitals, input);

            // If ArrayList contains the user's input, answer already given, continue loop
            if (prevAnswers.contains(input)) {
                System.out.println("You already named this capital! Try again!\n");
                continue;
            }

            // If user input is correct, print result and adjust score
            if (inputResult) {
                prevAnswers.add(input);
                System.out.println("Correct!\n");
                score++;
            }
            // Else user input is incorrect
            else {
                System.out.println("Incorrect!\n");
            }
            attempts--;
        }

        // Display final score
        System.out.println("Final score: " + score);
        System.out.println("Thanks for playing!");
    }

    public static void printArray(String[][] stateCapitals) {
        System.out.println("\n>>> Ordered by state name:");

        // Print array sorted alphabetically by state name
        for (String[] stateCap : stateCapitals) {
            System.out.println(Arrays.toString(stateCap));
        }

        // Call bubbleSort method to sort array alphabetically by capital name
        bubbleSort(stateCapitals);

        System.out.println("\n>>> Ordered by capital name:");

        // Print array sorted alphabetically by capital name
        for (String[] stateCap : stateCapitals) {
            System.out.println(Arrays.toString(stateCap));
        }
        System.out.println();
    }

    public static boolean elementExists(String[][] array, String target) {
        // Return true if element exists in array
        for (String[] row : array) {
            for (String element : row) {
                if (element.equals(target)) {
                    return true;
                }
            }
        }
        // Else element does not exist in array, return false
        return false;
    }

    public static void bubbleSort(String[][] stateCapitals) {
        // Alphabetically sorts 2d array based on capital name
        for (int i = 0; i < stateCapitals.length - 1; i++) {
            for (int j = 0; j < stateCapitals.length - i - 1; j++) {
                // If current capital name comes after next capital name alphabetically, swap elements
                if (stateCapitals[j][1].compareTo(stateCapitals[j + 1][1]) > 0) {
                    String[] temp = stateCapitals[j];
                    stateCapitals[j] = stateCapitals[j + 1];
                    stateCapitals[j + 1] = temp;
                }
            }
        }
    }

    public static void waitForEnterKeyPress(String prompt) {
        // Wait for user to press enter to continue program
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (!input.isEmpty());
    }
}