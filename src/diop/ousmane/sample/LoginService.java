package diop.ousmane.sample;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoginService {

	/**
	 * Fixed Thread Pool for login handling.
	 */
	private ExecutorService executor = Executors.newFixedThreadPool(5);

	private final static long MAX_TIME = 10;
	Boolean bool = false;
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean login(String userName, String password) {

		System.err.println("Perform Login for userName[" + userName + "]  password[" + password + "]");
		
		LoginRequest loginRequest = new LoginRequest(userName, password);

		FutureTask<Boolean> loginTask = new FutureTask<>(loginRequest);

		executor.execute(loginTask);

		try {
			// On attend 10 secondes au maximum
			System.err.println("Debut lancement temps :" +new Date());
			bool = loginTask.get(MAX_TIME, TimeUnit.SECONDS);
			System.err.println("Apres le retour de la methode get :" +new Date());
			return bool;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("Login interrompu ! " +new Date());
			int i =1;
			while(!bool){
				try {
					bool = loginTask.get(MAX_TIME, TimeUnit.SECONDS);
					return bool;
				} catch (InterruptedException | ExecutionException | TimeoutException e1) {
					System.err.println("Entre dans le catch de while !bool" +new Date());
					i++;
					if(i == 2){
						System.err.println("Fin temps :" +new Date());
						break;
					}
				}
			}
			return false;
		}
	}

}
