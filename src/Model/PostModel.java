package src.Model;

public class PostModel{

    private final int UserID;
    private final char Time;
    private final String Content;
    private final int PostID;

    public PostModel(int PostID, String Content, int UserID, char Time){
        this.PostID = PostID;
        this.Content = Content;
        this.UserID = UserID;
        this.Time = Time;
    }

    public int getPostID(){
        return PostID;
    }
    public int getUserID(){
        return UserID;
    }
    public char getTime(){
        return Time;
    }
    public String getContent(){
        return Content;
    }
}