public class DatabaseModel{

    private final String email;
    private final String password;
    private final String UserID;
    private final String Username;
    private final String Time;
    private final String UserID;
    private final String Content;
    private final String PostID;
    private final String AdminID;
    private final String TopicID;
    private final Boolean Trending;
    private final String ReplyID;
    private final String CommentID;
    private final Int Karma;
    private final Int numberofLikes;
    private final Int Admin_access_level;
    
    

    public UserModel(String email, String password, Int Karma, String UserID, String Username){
        this.email = email;
        this.password = password;
        this.Username = Username;
        this.UserID = UserID;
        this.Karma = Karma;
    }

    public AdministratorModel(Int Admin_access_level, String UserID, String AdminID){
        this.Admin_access_level = Admin_access_level;
        this.UserID = UserID;
        this.AdminID = AdminID;
    }

    public PostModel(String PostID, String Content, String UserID, String Time){
        this.PostID = PostID;
        this.Content = Content;
        this.UserID = UserID;
        this.Time = Time;
    }

    public LikedPostModel(String PostID, Boolean Trending, Int numberofLikes){
        this.PostID = PostID;
        this.Trending = Trending;
        this.numberofLikes = numberofLikes;
    } 

    public TrendingTopicModel(String TopicID, String Content, String PostID){
        this.TopicID = TopicID;
        this.Content=  Content;
        this.PostID = PostID;
    }

    public CommentModel(String CommentID, String UserID, String PostID, String Time, String Content){
        this.CommentID = CommentID;
        this.UserID = UserID;
        this.PostID = PostID;
        this.Time = Time;
        this.Content = Content;
    }

    public ReplyToModel(String ReplyID, String UserID, String CommentID, String Content, String Time){
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

    public Int getKarma(){
        return Karma;
    }

    public Int getAdmin_access_level(){
        return Admin_access_level;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return password;
    }

    public Int getnumberofLikes(){
        return numberofLikes;
    }
}