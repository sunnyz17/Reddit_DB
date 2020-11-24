package src.Model;

import java.text.DecimalFormat;

public class LocationOf_r2 {

    private final float Latitude;
    private final float Longitude;
    private final char Address;
    private final int UserID;
    private final int PostID;
    public LocationOf_r2(float Latitude, float Longitude, final char Address, int UserID, int PostID){
        this.PostID = PostID;
        this.UserID = UserID;
        this.Address=Address;
        this.Latitude=Latitude;
        this.Longitude=Longitude;

    }
    public float getLatitude(){
        return  Latitude;
    }
    public float getLongitude(){
        return Longitude;
    }
    public char Address(){
        return Address;
    }
    public int getUserID(){
        return UserID;
    }
    public int getPostID(){
        return PostID;
    }


}