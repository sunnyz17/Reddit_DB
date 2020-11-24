package src.Model;

public class AdministratorModel_r2 {

    private final int Admin_access_level;
    private final int UserID;


    public AdministratorModel_r2(int Admin_access_level, int UserID, int AdminID){
        this.Admin_access_level = Admin_access_level;
        this.UserID = UserID;

    }

    public int getUserID(){
        return UserID;
    }



    public int getAdmin_access_level(){
        return Admin_access_level;
    }


}