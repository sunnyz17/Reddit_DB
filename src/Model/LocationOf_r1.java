package src.Model;

import java.text.DecimalFormat;

public class LocationOf_r1 {

    private final float Latitude;
    private final float Longitude;
    private final char time;
    private final int UserID;
    private final int PostID;
    public LocationOf_r1(float Latitude, float Longitude, final char time, int UserID, int PostID){
        this.PostID = PostID;
        this.UserID = UserID;
        this.time=time;
        this.Latitude=Latitude;
        this.Longitude=Longitude;

    }
    public float getLatitude(){
        return  Latitude;
    }
    public float getLongitude(){
        return Longitude;
    }
    public char time(){
        return time;
    }
    public int getUserID(){
        return UserID;
    }
    public int getPostID(){
        return PostID;
    }


}