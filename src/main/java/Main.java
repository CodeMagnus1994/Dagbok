import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * Denna switch agerar som programmets kärna.
         * Användaren får skriva in siffrorna 1,2 eller 3 för att göra 1 utav 3 val.
         * 1. Läsa inlägg
         * 2. För att göra nya inlögg
         * 3. Stänga ner programmet.
         * Skulle användaren göra ett input som är olika ifårn 1,2 eller 3 så begärs hen att göra ett nytt input.
         */

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

    /**
     * Denna metod tillkallas ifrån main.
     * Syftet är att man skall hindra användaren ifrån att göra ett input som in passar med de val som
     * finns i programmets meny.
     * @param checkInput
     */

    public static void preventUserFromEnteringCharValue(Scanner checkInput) {

        while(!checkInput.hasNextInt()) {
            System.out.print("You entered an inappropriate character, make choice from the menu! ");
            checkInput.nextLine();
            AllMenus.showMenu(1);
        }

    }

}
