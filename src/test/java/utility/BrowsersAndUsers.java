package utility;

public class BrowsersAndUsers {

	
	private String[] usernames = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
	public String password = "secret_sauce";
	
	public String[] browsers = {"Chrome", "Firefox"};

	public String[] getUsernames() {
		return usernames;
	}

	public void setUsernames(String[] usernames) {
		this.usernames = usernames;
	}
	
}
