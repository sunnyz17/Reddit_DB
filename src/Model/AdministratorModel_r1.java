package src.Model;

public class AdministratorModel_r1 {

    private final int UserID;
    private final int AdminID;

    public AdministratorModel_r1(int Admin_access_level, int UserID, int AdminID){

        this.UserID = UserID;
        this.AdminID = AdminID;
    }

    public int getUserID(){
        return UserID;
    }

    public int getAdminID(){
        return AdminID;
    }




}