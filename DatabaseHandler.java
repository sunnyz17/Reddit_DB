import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DatabaseModel;

public class DatabaseHandler{

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
 
    private Connection connection = null;

    //TODO: this function might need some changes if we want to host locally

        public DatabaseHandler(){
            try {
                // Load the Oracle JDBC driver
                // Note that the path could change for new drivers
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }
        //connection url depends on what model we want to use
        
        public void closeDB() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        public void deletePost(int PostID){
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM Post WHERE PostID = ?");
                ps.setInt(1, PostID);
                
                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(WARNING_TAG + " Post " + PostID + " does not exist!");
                }
                
                connection.commit();
        
                ps.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
                rollbackConnection();
            }
        }

        public void selectPost(){
            
            try(
                
                Connection conn = DriverManager.getConnection(); //insert database connection url here
                
                Statement stmt = conn.createStatement();)
                ){
                    //INSERT SQL SELECT STATEMENT HERE
                    String strSelect = "";
                    
                    ResultSet rset = stmt.executeQuery(strSelect);
                    System.out.println("The records selected are:");
                    int rowCount = 0;
                    
                    //here, you select each entitites from the Post table 
                    //TODO: add the entities and coressponding methods to get it 
                    while(rset.next()){
                        
                    }
                    //ie
                    // while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    //     String title = rset.getString("title");
                    //     double price = rset.getDouble("price");
                    //     int    qty   = rset.getInt("qty");
                    //     System.out.println(title + ", " + price + ", " + qty);
                    //     ++rowCount;
                    //  }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
        }


        public void insertPost(){
            try(
                Connection conn = DriverManager.getConnection(

                );
                Statement stmt = conn.createStatement();
            ){

            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }









    }

