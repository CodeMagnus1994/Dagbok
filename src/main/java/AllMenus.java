/**
 * Klassen bär på de menyer som guidar användaren till att nyttja programmets alternativ.
 */
public class AllMenus {

    /**
     * Metoden showMenu bär på 2 stycken metoder som tillkallas ifrån main.
     * @param pickWhatMenu vägleder programmet till att välja rätt meny.
     */
    static void showMenu(int pickWhatMenu) {

        if(pickWhatMenu == 0) {
            System.out.println("\nWelcome to the diary, choose between the following options!");

            System.out.println("1. Read diary");
            System.out.println("2. Make input into diary");
            System.out.println("3. Cancel diary");
            System.out.print("\nEnter: ");
        }

        if(pickWhatMenu == 1) {
            System.out.println("\n1. Read diary");
            System.out.println("2. Make input into diary");
            System.out.println("3. Cancel diary");
            System.out.print("Enter: ");
        }

    }

}
