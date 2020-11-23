package src.Model;

public class CommentModel {

    private final int UserID;
    private final String Time;
    private final String Content;
    private final int PostID;
    private final int CommentID;
   

    public CommentModel(int CommentID, int UserID, int PostID, String Time, String Content){
        this.CommentID = CommentID;
        this.UserID = UserID;
        this.PostID = PostID;
        this.Time = Time;
        this.Content = Content;
    }

    public int getUserID(){
        return UserID;
    }

    public String getTime(){
        return Time;
    }

    public String getContent(){
        return Content;
    }

    public int getCommentID(){
        return CommentID;
    }

    public int getPostID(){
        return PostID;
    }

    
}
