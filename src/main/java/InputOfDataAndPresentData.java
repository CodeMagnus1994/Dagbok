import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Denna klass har två uppgifter.
 * Hanterar input och output av klassobjekt.
 * Överför data till JSON filen DiaryLog.json samt läser data ifrån samma fil.
 */
public class InputOfDataAndPresentData extends CreateObjects {

    /**
     * Arraylistan bär på klassobjekt
     * mapper överför data ifrån arraylistan till json filen samt läser in data ifrån json filen.
     */
    static ArrayList<CreateObjects> theDiary = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();

    /**
     * Metoden tillkallas ifrån main och låter användaren göra ett input i arraylistan.
     * Metoden tillkallar också en annan metod, showInputToUser.
     */
    static void makeInputIntoDiary() throws IOException {

        var inputFromUser = new Scanner(System.in);

        System.out.print("\nEnter title: ");
        String title = preventUserFromSkippingInput(inputFromUser);

        System.out.print("Enter Story: ");
        String story = preventUserFromSkippingInput(inputFromUser);

        DateFormat getFormatToDate = new SimpleDateFormat("yyyy-MM-dd");
        Date getDateThatWillGoIntoDiary = new Date();
        String date = getFormatToDate.format(getDateThatWillGoIntoDiary);

        theDiary.add(new CreateObjects(story, title, date));

        showInputToUser(title, story, date);

        InputOfDataAndPresentData.logInformationIntoJsonFile();
    }

    /**
     * Metoden gör output av användaren inlägg.
     */
    static void showInputToUser(String title, String story, String date) {

        System.out.println("\nTitle: " + title);
        System.out.println("Date: " + date);
        System.out.println("Story: " + story);
    }

    /**
     * Metoden tillkallas ifrån main och gör output av alla objekt som finns i arraylistan.
     */
    static void readAllTheStoriesFromTheDiary() {

        try{
            for(CreateObjects p : theDiary) {
                System.out.println("Title: " + p.getTitleOfPost());
                System.out.println("Date: " + p.getDateOfPost());
                System.out.println("Story: " + p.getDiaryPost());
                System.out.println("\n");
            }
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("The diary was empty!");
        }

    }

    /**
     * Metoden tillkallas ifrån metoden "makeInputIntoDiary" överför data ifrån
     * arraylistan theDiary till json-filen DiaryLog.json.
     */
    static void logInformationIntoJsonFile() throws IOException {

        mapper.writeValue(Paths.get("src/main/resources/DiaryLog.json").toFile(), theDiary);

    }

    /**
     * Metoden tillkallas ifrån main och
     * läser in data ifrån JSON-filen DiaryLog.json och överför den till arraylistan theDiary.
     */
    static void getInformationFromJsonFile() throws IOException {

        try {
            List<CreateObjects> takeAllInfoFromJsonFile =
                    List.of(mapper.readValue(Paths.get("src/main/resources/DiaryLog.json").toFile(),
                    CreateObjects[].class));

            theDiary.addAll(takeAllInfoFromJsonFile);
        }catch (Exception e) {

        }
    }

    /**
     * Metoden tillkallas ifrån metoden "makeInputIntoDiary" och
     * hindrar användren ifrån att hoppa över input av att missklicka "enter".
     */
    static String preventUserFromSkippingInput(Scanner inputFromUser) {

        String keepDataFromUser = inputFromUser.nextLine();

        while(keepDataFromUser.matches("^\\s*$")){
            System.out.println("You forgot to make input!");
            System.out.print("Try again: ");
            keepDataFromUser = inputFromUser.nextLine();
        }

        return keepDataFromUser;
    }

}
