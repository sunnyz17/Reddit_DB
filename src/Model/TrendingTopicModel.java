package src.Model;

public class TrendingTopicModel {
    private final String TopicID;
    private final String Content;
    private final int PostID;
    public TrendingTopicModel(String TopicID, String Content, int PostID){
        this.TopicID = TopicID;
        this.Content=  Content;
        this.PostID = PostID;
    }

  
    public String getTopicID(){
        return TopicID;
    }


    public String getContent(){
        return Content;
    }

    
    public int getPostID(){
        return PostID;
    }

}
