package src.Model;

public class DatabaseModel{

    private final String email;
    private final String pass;
    private final int UserID;
    private final String Username;
    private final String Time;
    private final String Content;
    private final int PostID;
    private final int AdminID;
    private final String TopicID;
    private final Boolean Trending;
    private final String ReplyID;
    private final int CommentID;
    private final int Karma;
    private final int numberofLikes;
    private final int Admin_access_level;
    

    public UserModel(String email, String pass, int Karma, int UserID, String Username){
        this.email = email;
        this.pass = pass;
        this.Username = Username;
        this.UserID = UserID;
        this.Karma = Karma;
    }

    public AdministratorModel(int Admin_access_level, int UserID, int AdminID){
        this.Admin_access_level = Admin_access_level;
        this.UserID = UserID;
        this.AdminID = AdminID;
    }

    public PostModel(int PostID, String Content, int UserID, String Time){
        this.PostID = PostID;
        this.Content = Content;
        this.UserID = UserID;
        this.Time = Time;
    }

    public LikedPostModel(int PostID, Boolean Trending, int numberofLikes){
        this.PostID = PostID;
        this.Trending = Trending;
        this.numberofLikes = numberofLikes;
    } 

    public TrendingTopicModel(String TopicID, String Content, int PostID){
        this.TopicID = TopicID;
        this.Content=  Content;
        this.PostID = PostID;
    }

    public CommentModel(int CommentID, int UserID, int PostID, String Time, String Content){
        this.CommentID = CommentID;
        this.UserID = UserID;
        this.PostID = PostID;
        this.Time = Time;
        this.Content = Content;
    }

    public ReplyToModel(String ReplyID, int UserID, int CommentID, String Content, String Time){
        this.ReplyID = ReplyID;
        this.UserID= UserID;
        this.CommentID = CommentID;
        this.Content = Content;
        this.Time = Time;
    }

    public String getUserID(){
        return UserID;
    }

    public String getReplyID(){
        return ReplyID;
    }

    public String getTopicID(){
        return TopicID;
    }

    public String getTime(){
        return Time;
    }

    public String getContent(){
        return Content;
    }

    public String getCommentID(){
        return CommentID;
    }

    public String getAdminID(){
        return AdminID;
    }

    public String getemail(){
        return email;
    }

    public int getKarma(){
        return Karma;
    }

    public int getAdmin_access_level(){
        return Admin_access_level;
    }

    public String getUsername(){
        return Username;
    }

    public String getPass(){
        return pass;
    }

    public int getnumberofLikes(){
        return numberofLikes;
    }

    public int getPostID(){
        return PostID;
    }

    public Boolean getTrending(){
        return Trending;
    }

}