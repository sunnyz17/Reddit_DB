package ca.ubc.cs304.delegates;

import ca.ubc.cs304.model.*;

/**
 * This interface uses the delegation design pattern where instead of having
 * the TerminalTransactions class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case Bank).
 * 
 * TerminalTransactions calls the methods that we have listed below but 
 * Bank is the actual class that will implement the methods.
 */
public interface TerminalTransactionsDelegate {
	public void databaseSetup();
	
	public void deleteBranch(int branchId);
	public void insertBranch(BranchModel model);

	public void insertUser(UserModel model);
	public void insertPost(PostModel model);
	public void insertAdmin1(AdministratorModel_r1 model);
	public void insertAdmin2(AdministratorModel_r2 model);
	public void insertComment(CommentModel model);
	public void insertVote(LikedPostModel model);

	public void showBranch();
	public void updateBranch(int branchId, String name);
	
	public void terminalTransactionsFinished();
}
