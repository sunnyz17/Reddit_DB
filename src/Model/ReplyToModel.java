package src.Model;

public class ReplyToModel {
    
    private final int ReplyID;
    private final int UserID;
    private final int CommentID;
    private final String Time;
    private final String Content;

    public ReplyToModel(int ReplyID, int UserID, int CommentID, String Content, String Time){
        this.ReplyID = ReplyID;
        this.UserID= UserID;
        this.CommentID = CommentID;
        this.Content = Content;
        this.Time = Time;
    }

    public int getReplyID(){
        return ReplyID;
    }
    public int getUserID(){
        return UserID;
    }
    public String getTime(){
        return Time;
    }
    public int getCommentID(){
        return CommentID;
    }
    public String getContent(){
        return Content;
    }
}
