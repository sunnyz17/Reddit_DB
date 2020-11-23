package src.Model;

public class AdministratorModel {
    
    private final int Admin_access_level;
    private final int UserID;
    private final int AdminID;

    public AdministratorModel(int Admin_access_level, int UserID, int AdminID){
        this.Admin_access_level = Admin_access_level;
        this.UserID = UserID;
        this.AdminID = AdminID;
    }

    public int getUserID(){
        return UserID;
    }

    public int getAdminID(){
        return AdminID;
    }

    public int getAdmin_access_level(){
        return Admin_access_level;
    }


}
