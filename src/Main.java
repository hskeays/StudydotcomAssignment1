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

        // Wait for user to press ENTER to continue program, else prompt again
        waitForEnterKeyPress("Press ENTER to begin: ");

        // Run single question state/capital city test
        singleCapitalTest(stateCapitals);

        // Wait for user to press ENTER to continue program, else prompt again
        waitForEnterKeyPress("\nPress ENTER to take the full test: ");

        // Run full 50 state/capital city test
        allCapitalsTest(stateCapitals);

        // Wait for user to press ENTER to continue program, else prompt again
        waitForEnterKeyPress("\nPress ENTER to print the array sorted by state, then again by capital: ");

        // Print the array, in its original order, ordered alphabetically by state name
        printArray(stateCapitals, ">> Sorted by state name:");

        // Use bubble sort algorithm to order the array alphabetically by capital name
        bubbleSortByCapital(stateCapitals);

        // Print the array again, now sorted alphabetically by capital name
        printArray(stateCapitals, ">> Sorted by capital city name:");
    }

    public static void singleCapitalTest(String[][] stateCapitals) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for capital name, store user input in 'input'
        System.out.print("Enter the capital city name of any US state: ");
        String input = scanner.nextLine();

        // Store boolean value of whether user's input exists in array
        boolean inputResult = elementExists(stateCapitals, input);

        // Print appropriate response depending on user input result
        if (inputResult) {
            System.out.println("\nCorrect!");
        } else {
            System.out.println("\nIncorrect!");
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
            System.out.print("Capital city name: ");
            String input = scanner.nextLine();

            // Store boolean value of whether user's input exists in array(is a correct answer)
            boolean inputResult = elementExists(stateCapitals, input);

            // If ArrayList contains the user's input, answer already given, continue loop
            if (prevAnswers.contains(input)) {
                System.out.println("You already named this capital! Try again!\n");
                continue;
            }

            // If user input is correct, print result and increment score
            if (inputResult) {
                prevAnswers.add(input);
                System.out.println("\nCorrect!\n");
                score++;
            }
            // Else user input is incorrect
            else {
                System.out.println("\nIncorrect!\n");
            }
            attempts--;
        }

        // Display final score and ending message
        System.out.println("Final score: " + score + "\nThanks for playing!");
    }

    public static void printArray(String[][] stateCapitals, String header) {
        System.out.println(header);
        // Print the array
        for (String[] stateCap : stateCapitals) {
            System.out.println(Arrays.toString(stateCap));
        }
        // Add space below printed array
        System.out.println();
    }

    public static boolean elementExists(String[][] array, String target) {
        if (!target.isEmpty()) {
            target = target.substring(0, 1).toUpperCase() + target.substring(1).toLowerCase();
        } else {
            return false;
        }
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

    public static void bubbleSortByCapital(String[][] stateCapitals) {
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
        // Wait for user to press ENTER to continue program
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (!input.isEmpty());
    }
}