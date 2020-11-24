package src.delegates;

import src.Controller.*;
import src.Model.*;

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
	public void databaseSetup();
	
	

	public void insertUser(UserModel model);
	public void insertPost(PostModel model);
	public void insertComment(CommentModel model);
	
	public void deletePost(int PostID);

	public String[] selectPostofUser(String Username);
	public String[] selectUsername();

	//need fixes still

	public void selectCoordofAllPosts();


	
	
}
