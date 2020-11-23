package src.Model;

public class LikedPostModel {

    private final int PostID;
    private final Boolean Trending;
    private final int numberofLikes;


    public LikedPostModel(int PostID, Boolean Trending, int numberofLikes){
        this.PostID = PostID;
        this.Trending = Trending;
        this.numberofLikes = numberofLikes;
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
