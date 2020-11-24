package src.delegates;

import src.Controller.*;
import src.Model.*;
import java.math.BigDecimal;

/**
 * This interface uses the delegation design pattern where instead of having
 * the TerminalTransactions class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case Bank).
 * 
 * TerminalTransactions calls the methods that we have listed below but 
 * Bank is the actual class that will implement the methods.
 */
public interface TransactionsDelegate {

	public void insertUser(UserModel model);
	public void insertPost(PostModel model);
	public void insertComment(CommentModel model);

	public void deleteUser(int userID);
	public void updateUserName(int UserID, String Username);

	public String[] selectPostByLocation(BigDecimal Latitude, BigDecimal Longitude);
	public String[] selectPostByUser(String Username); //array of array 
	public String selectPostofTrendingTopic(String Trending);
	public String[] selectTopicWithPostsOnDate(String time);
	public String[] postPerDay(); //array of array
	public int highestCommentNumber();
	public String[] UserinAllVotes();
}
