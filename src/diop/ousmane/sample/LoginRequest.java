package diop.ousmane.sample;

import java.util.concurrent.Callable;

/**
 * Login Request.
 * 
 * @author dialloc
 *
 */
public class LoginRequest implements Callable<Boolean> {

	/**
	 * User Name.
	 */
	private String userName;

	/**
	 * Password.
	 */
	private String password;

	public LoginRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Perform login request.
	 * 
	 * @return true if login succeed.
	 */
	@SuppressWarnings("static-access")
	@Override
	public Boolean call() throws Exception {
		if (userName.equalsIgnoreCase("catherine") || userName.equalsIgnoreCase("camille")) {
			return true;
		} else {
			System.err.println("I am still waiting");
			while (true) {
				System.err.println(".");
				try {// sleep one second
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					//
				}
			}

		}

	}

}
