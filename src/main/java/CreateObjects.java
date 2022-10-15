import java.util.ArrayList;
public class CreateObjects {
    private String diaryPost;
    private String dateOfPost;
    private String titleOfPost;

    public CreateObjects(String diaryPost, String titleOfPost, String dateOfPost) {
        this.diaryPost = diaryPost;
        this.dateOfPost = dateOfPost;
        this.titleOfPost = titleOfPost;
    }

    public CreateObjects() {

    }

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
