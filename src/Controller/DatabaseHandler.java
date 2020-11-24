package src.Controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.Model.PostModel;
import src.Model.AdministratorModel;
import src.Model.CommentModel;
import src.Model.LikedPostModel;
import src.Model.ReplyToModel;
import src.Model.TrendingTopicModel;
import src.Model.UserModel;


public class DatabaseHandler{

	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	//private static final String WARNING_TAG = "[WARNING]";
 
    private Connection connection = null;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //this depends on ur database name so 
    //URL   =====>   "jdbc:mysql://localhost:3306/" + [your database name]
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema";

    //  Database credentials
    //this depends on your own set password
    static final String USER = "root";
    static final String PASS = "123123";


        public DatabaseHandler(){

                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    // System.out.println("Creating database...");
                    // stmt = conn.createStatement();

                    // String sql = "CREATE DATABASE STUDENTS";
                    // stmt.executeUpdate(sql);
                    System.out.println("Database created successfully...");
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }finally{
                    //finally block used to close resources
                    try{
                        if(stmt!=null)
                            stmt.close();
                    }catch(SQLException se2){
                    }// nothing we can do
                    try{
                        if(conn !=null)
                            conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }//end finally try
                }//end try
                System.out.println("Goodbye!");
            }

        
        public void closeDB() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        private void rollbackConnection() {
            try  {
                connection.rollback();	
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        //deletes all posts with ID >= 1000
        public void deletePost(int PostID){
            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            
                //INSERT SQL SELECT STATEMENT HERE
                String strSelect = "DELETE FROM Post WHERE PostID >= 1000";
                stmt.executeQuery(strSelect);

            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
            System.out.println("FINISHED DELETING ALL POSTS WITH ID >= 1000");
        }

        //selects all the posts in the database
        public PostModel[] selectPost(){
            ArrayList<PostModel> result = new ArrayList<PostModel>();
            Connection conn = null;
            Statement stmt = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
                
                    //INSERT SQL SELECT STATEMENT HERE
                    String strSelect = "SELECT * FROM Post";
                    
                    ResultSet rset = stmt.executeQuery(strSelect);
                    System.out.println("The records selected are:");
                    int rowCount = 0;
                    
                    //here, you select each entitites from the Post table 
                    //this loop gets all the rows in the Post table
                    while(rset.next()){
                        PostModel model = new PostModel(
                            rset.getInt("PostID"),
                            rset.getString("Content"),
                            rset.getInt("UserID"),
                            rset.getString("timee"));

                        System.out.println(model + "\n");
                        result.add(model);
                    }
               
                }catch(SQLException ex){
                    ex.printStackTrace();
                    rollbackConnection();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end try

                
                System.out.println("finished select!");
                return result.toArray(new PostModel[result.size()]);
        }

        //inserts a post specified by a user
        public void insertPost(PostModel model){
            Connection conn = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO Post VALUES (?,?,?,?)");

                    ps.setInt(1, model.getPostID());
                    ps.setString(2, model.getContent());
                    ps.setInt(3, model.getUserID());
                    ps.setString(4, model.getTime());

                    ps.executeUpdate();

                    ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
        }


        //inserts a user 
        public void insertUser(UserModel model){
            Connection conn = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO Post VALUES (?,?,?,?,?)");

                    ps.setString(1, model.getemail());
                    ps.setString(2, model.getPass());
                    ps.setString(3, model.getUsername());
                    ps.setInt(4, model.getUserID());
                    ps.setInt(5, model.getKarma());

                    ps.executeUpdate();

                    ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
        }


        //inserts a comment
        public void insertComment(CommentModel model){
            Connection conn = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO Post VALUES (?,?,?,?)");

                    ps.setInt(1, model.getCommentID());
                    ps.setInt(2, model.getUserID());
                    ps.setInt(3, model.getPostID());
                    ps.setString(4, model.getTime());
                    ps.setString(5, model.getContent());

                    ps.executeUpdate();

                    ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
        }

        





        //gets the coordinates of all the posts
        public void selectCoordofAllPosts(){
            Connection conn = null;
            Statement stmt = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    System.out.println("Selecting all posts coords");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();

                    String strSelect = "SELECT Latitude, Longtitude, PostID FROM LocationOf";
                    ResultSet rset = stmt.executeQuery(strSelect);
                    int rowCount = 0;

                    //TODO:
                    while(rset.next()){
                        BigDecimal Lat = rset.getBigDecimal("Latitude");
                        BigDecimal Long = rset.getBigDecimal("Longtitude");
                        Integer PostID = rset.getInt("PostID");
                        System.out.println("row: " + rowCount + "PostID is :" + PostID + ", " + "With Latitude and Longtitude: " + Lat + ", " + Long + + "\n");
                        ++rowCount;
                    }


            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
        }



        //gets all the usernames of users 
        public String[] selectUsername(){
            ArrayList<String> result = new ArrayList<String>();
            Connection conn = null;
            Statement stmt = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //Open a connection
                    System.out.println("Connecting to database...");
                    System.out.println("Selecting all Usernames");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();


                    String strSelect = "SELECT Username FROM User";
                    ResultSet rset = stmt.executeQuery(strSelect);
                    int rowCount = 0;

                    while(rset.next()){
                        String Username = rset.getString("Username");
                        System.out.println("User: " + rowCount + " " + Username + "\n");
                        result.add(Username);
                        ++rowCount;
                    }


            }catch(SQLException ex){
                ex.printStackTrace();
                rollbackConnection();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
            return result.toArray(new String[result.size()]);
        }




    }

