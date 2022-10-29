import java.util.ArrayList;

/**
 * Denna klass lägger grunden för att användaren skall kunna skapa objekt som bär på den data
 * som kommer att öveföras till JSON filen.
 */

public class CreateObjects {

    /**
     * 3 stycken instansvariablar kommer att tillhöra varje objekt av denna klasstypen.
     * @param diaryPost
     * @param titleOfPost
     * @param dateOfPost
     */
    private String diaryPost;
    private String dateOfPost;
    private String titleOfPost;


    /**
     * 2 stycken konstruktorer.
     */
    public CreateObjects(String diaryPost, String titleOfPost, String dateOfPost) {
        this.diaryPost = diaryPost;
        this.dateOfPost = dateOfPost;
        this.titleOfPost = titleOfPost;
    }

    public CreateObjects() {

    }

    /**
     * Getters och setters för varje instansvariabel.
     */
    public String getDiaryPost() {return diaryPost;}

    public void setDiaryPost(String diaryPost) {this.diaryPost = diaryPost;}

    public String getDateOfPost() {return dateOfPost;}

    public void setDateOfPost(String dateOfPost) {this.dateOfPost = dateOfPost;}

    public String getTitleOfPost() {
        return titleOfPost;
    }

    public void setTitleOfPost(String titleOfPost) {
        this.titleOfPost = titleOfPost;
    }
}
