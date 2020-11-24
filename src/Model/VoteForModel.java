package src.Model;

public class VoteForModel {

    private final int UserID;
    private final String Time;

    private final int PostID;
    private final int VoteID;


    public VoteForModel(int VoteID, int UserID, int PostID, String Time){
        this.VoteID = VoteID;
        this.UserID = UserID;
        this.PostID = PostID;
        this.Time = Time;

    }

    public int getUserID(){
        return UserID;
    }

    public String getTime(){
        return Time;
    }


    public int getVoteID(){
        return VoteID;
    }

    public int getPostID(){
        return PostID;
    }


}
