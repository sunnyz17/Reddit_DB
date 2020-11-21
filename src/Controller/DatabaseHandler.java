package src.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.Model.DatabaseModel;


public class DatabaseHandler{

	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
 
    private Connection connection = null;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123123";


        public DatabaseHandler(){

                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
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
                        if(conn!=null)
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

        public void deletePost(int PostID){
            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            
                //INSERT SQL SELECT STATEMENT HERE
                String strSelect = "DELETE FROM Post WHERE PostID >= 1000";
                stmt.executeQuery(strSelect);

            }catch(SQLException ex){
                ex.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end try
            System.out.println("FINISHED DELETING ALL POSTS");
        }

        public void selectPost(){
            Connection conn = null;
            Statement stmt = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
                
                    //INSERT SQL SELECT STATEMENT HERE
                    String strSelect = "SELECT * FROM Post";
                    
                    ResultSet rset = stmt.executeQuery(strSelect);
                    System.out.println("The records selected are:");
                    int rowCount = 0;
                    
                    //here, you select each entitites from the Post table 
                    while(rset.next()){
                        Integer PostID = rset.getInt("PostID");
                        String Content = rset.getString("Content");
                        Integer UserID = rset.getInt("UserID");
                        String time = rset.getString("timee");
                        System.out.print("PostID is: " + PostID + ", " + "Post Content is: " + Content + ", " + "Posted by UserID: " + UserID + ", " + "Posted at the time: " + time);
                        ++rowCount;
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
        }


        public void insertPost(){
            Connection conn = null;
            Statement stmt = null;
            try{
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();

                    //TODO: 
                    //DO THE INSERTING CODE HERE
                    //NEED TO CONNECT TO THE FRONT END OPTIONS SOMEHOW?



            }catch(SQLException ex){
                ex.printStackTrace();
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

