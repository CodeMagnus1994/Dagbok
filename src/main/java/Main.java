import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        InputOfDataAndPresentData.getInformationFromJsonFile();
        var inputFromUser = new Scanner(System.in);
        int makeOptionFromMenu;

        AllMenus.showMenu(0);

        while(true) {

            preventUserFromEnteringCharValue(inputFromUser);

            makeOptionFromMenu = inputFromUser.nextInt();
            switch (makeOptionFromMenu) {
                case 1:
                    InputOfDataAndPresentData.readAllTheStoriesFromTheDiary();
                    break;
                case 2:
                    InputOfDataAndPresentData.makeInputIntoDiary();
                    break;
                case 3:
                    System.out.println("The diary will close. Thank you so much for visiting!!! :)");
                    System.exit(0);
                default:
                    System.out.println("That number was not on the menu, pay attention!");
                    inputFromUser.nextLine();
            }

            AllMenus.showMenu(1);
        }

    }

    public static void preventUserFromEnteringCharValue(Scanner checkInput) {

        while(!checkInput.hasNextInt()) {
            System.out.print("You entered an inappropriate character, make choice from the menu! ");
            checkInput.nextLine();
            AllMenus.showMenu(1);
        }

    }

}
