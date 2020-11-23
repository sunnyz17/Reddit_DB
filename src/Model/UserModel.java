package src.Model;

public class UserModel {

    private final String email;
    private final String pass;
    private final int UserID;
    private final String Username;
    private final int Karma;

    public UserModel(String email, String pass, int Karma, int UserID, String Username){
        this.email = email;
        this.pass = pass;
        this.Username = Username;
        this.UserID = UserID;
        this.Karma = Karma;
    }

    public String getPass(){
        return pass;
    }
    public String getemail(){
        return email;
    }
    public int getUserID(){
        return UserID;
    }
    public int getKarma(){
        return Karma;
    }
    public String getUsername(){
        return Username;
    }
}
