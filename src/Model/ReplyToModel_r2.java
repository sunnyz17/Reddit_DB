package src.Model;

public class ReplyToModel_r2 {

    private final int ReplyID;
    private final int UserID;
    private final int CommentID;


    public ReplyToModel_r2(int ReplyID, int UserID, int CommentID, String Content, String Time){
        this.ReplyID = ReplyID;
        this.UserID= UserID;
        this.CommentID = CommentID;

    }

    public int getReplyID(){
        return ReplyID;
    }
    public int getUserID(){
        return UserID;
    }

    public int getCommentID(){
        return CommentID;
    }

}
