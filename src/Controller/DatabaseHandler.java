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

import src.delegates.*;
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

        //deletes all posts with ID
        public void deletePost(int PostID){
            Connection conn = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                PreparedStatement ps = conn.prepareStatement("DELETE FROM Post WHERE PostID = ?");
                ps.setInt(1, PostID);
                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(" Post with PostID: " + PostID + " does not exist!");
                }
                
                conn.commit();
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
            System.out.println("FINISHED DELETING POST WITH ID" + PostID);
        }

        //updates specific userID with new Username
        public void updateUserName(int UserID, String Username){
            Connection conn = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                PreparedStatement ps = conn.prepareStatement("UPDATE User SET Username = ? WHERE UserID = ?");
                ps.setString(1, Username);
                ps.setInt(2, UserID);

                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(" User with UserID: " + UserID + " does not exist!");
                }
                
                conn.commit();
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
            System.out.println("FINISHED Updating UserID: " + UserID + " with new username: " + Username);

        }


        //TODO: 
        //FIX THE QUERY
        public String[] selectPostByLocation(BigDecimal Latitude, BigDecimal Longitude){
            ArrayList<String> result = new ArrayList<String>();
            Connection conn = null;
    
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                
                    //INSERT SQL SELECT STATEMENT HERE
                    PreparedStatement ps = connection.prepareStatement( "SELECT Content FROM LocationOf_r1 l, post p WHERE l.latitude = ? AND l.longitude = ? AND l.PostID = p.PostID");
                    ps.setBigDecimal(1, Latitude);
                    ps.setBigDecimal(2, Longitude);

                    ResultSet rset = ps.executeQuery();
                    int rowCount = ps.executeUpdate();
                    if (rowCount == 0) {
                        System.out.println(" Coordinates with :  " + Latitude + ", " + Longitude + "does not exist!");
                    }else{
                        System.out.println("The Posts by " + Latitude + ", " + Longitude + "selected are:");

                        while(rset.next()){
                            System.out.println("user post " + rowCount + rset.getString("Content"));
                            result.add(rset.getString("Content"));
                        }
                    }

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

                
                System.out.println("finished Posts from Username select!");
                return result.toArray(new String[result.size()]);
        }



        //selects all the posts in the database
        public String[] selectPostByUser(String Username){
            ArrayList<String[]> result = new ArrayList<String[]>();
            String[] add = new String[3];

            Connection conn = null;
    
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                
                    //INSERT SQL SELECT STATEMENT HERE
                    PreparedStatement ps = connection.prepareStatement( "SELECT PostID, Content, p.UserID FROM Post p, User u WHERE p.UserID = p.UserID AND u.username = ?");
                    ps.setString(1, Username);

                    ResultSet rset = ps.executeQuery();
                    int rowCount = ps.executeUpdate();
                    if (rowCount == 0) {
                        System.out.println(" Username:  " + Username + " does not exist!");
                    }else{
                        System.out.println("The Posts by " + Username + " selected are:");

                        while(rset.next()){
                            System.out.println("user post " + rowCount + rset.getString("Content")); 

                            add[0] = Integer.toString(rset.getInt("PostID"));
                            add[1] = rset.getString("Content");
                            add[2] = Integer.toString(rset.getInt("UserID"));

                            result.add(add);
                        }
                    }
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

                
                System.out.println("finished Posts from Username select!");
                return result.toArray(new String[result.size()]);
        }

        //selecting the post of a user specified trending topic
        public String selectPostofTrendingTopic(String Trending){
            String result = "";
            Connection conn = null;
       
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                
                
                    //INSERT SQL SELECT STATEMENT HERE
                    PreparedStatement ps = connection.prepareStatement( "SELECT Content FROM TrendingTopic WHERE TopicID = ?");
                    ps.setString(1, Trending);

                    ResultSet rset = ps.executeQuery();
                    int rowCount = ps.executeUpdate();
                    if (rowCount == 0) {
                        System.out.println(" TrendingTopic:  " + Trending + " does not exist!");
                    }else{
                        System.out.println("The Posts by " + Trending + " selected are:");

                        while(rset.next()){
                            System.out.println("user post " + rowCount + rset.getString("Content"));
                            result = rset.getString("Content");
                        }
                    }

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

                
                System.out.println("finished Trending Topic Post select!");
                return result;
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


        //inserts a user with parameters specified by a user
        public void insertUser(UserModel model){
            Connection conn = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO User VALUES (?,?,?,?,?)");

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

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO Comment VALUES (?,?,?,?)");

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

        public String[] selectTopicWithPostsOnDate(String time){
            ArrayList<String> result = new ArrayList<String>();
            Connection conn = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");

                //Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
                //INSERT SQL SELECT STATEMENT HERE
                PreparedStatement ps = connection.prepareStatement( "SELECT Content FROM TrendingTopic WHERE time = ?");
                ps.setString(1, time);

                ResultSet rset = ps.executeQuery();
                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(" TrendingTopic with " + time + " does not exist!");
                }else{
                    System.out.println("The trendingtopic post on " + time + " selected are:");

                    while(rset.next()){
                        System.out.println("TrendingTopic post  " + rowCount + rset.getString("Content"));
                        result.add(rset.getString("Content"));
                    }
                }

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

            return result.toArray(new String[result.size()]);
        }

        public String[] postPerDay(){
            ArrayList<String[]> result = new ArrayList<String[]>();
            Connection conn = null;
            String[] add = new String[2];
            try{
                Class.forName("com.mysql.jdbc.Driver");

                //Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
                //INSERT SQL SELECT STATEMENT HERE
                PreparedStatement ps = connection.prepareStatement( "Select Time, count(*) From VoteFor Group By Time;");
                

                ResultSet rset = ps.executeQuery();
                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(" Date does not exist!");
                }else{
                    System.out.println("The posts selected are:");

                    while(rset.next()){
                        
                        add[0] = rset.getString("Time");
                        add[1] = Integer.toString(rset.getInt("Count"));
                        result.add(add);
                    }
                }

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

            System.out.println("posts per day is " + result + " where [0] is date and [1] is count of posts");
            return result.toArray(new String[result.size()]);
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
                        BigDecimal Long = rset.getBigDecimal("Longitude");
                        Integer PostID = rset.getInt("PostID");
                        System.out.println("row: " + rowCount + "PostID is :" + PostID + ", " + "With Latitude and Longitude: " + Lat + ", " + Long  + "\n");
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




    }

