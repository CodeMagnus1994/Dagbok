import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InputOfDataAndPresentData extends CreateObjects {

    static ArrayList<CreateObjects> theDiary = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();
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
    static void showInputToUser(String title, String story, String date) {

        System.out.println("\nTitle: " + title);
        System.out.println("Date: " + date);
        System.out.println("Story: " + story);
    }

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

    static void logInformationIntoJsonFile() throws IOException {

        mapper.writeValue(Paths.get("src/main/resources/DiaryLog.json").toFile(), theDiary);

    }

    static void getInformationFromJsonFile() throws IOException {

        try {
            List<CreateObjects> takeAllInfoFromJsonFile =
                    List.of(mapper.readValue(Paths.get("src/main/resources/DiaryLog.json").toFile(),
                    CreateObjects[].class));

            theDiary.addAll(takeAllInfoFromJsonFile);
        }catch (Exception e) {

        }
    }
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
