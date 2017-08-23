package diop.ousmane.sample;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

	private LoginService loginService = new LoginService();

	@Test
	public void testLooginCatherine() {
		Assert.assertFalse(loginService.login("catherine", "ent"));
	}

	@Test
	public void testLooginCamille() {
		Assert.assertTrue(loginService.login("camille", "rh"));
	}

	@Test
	public void testLoginOusmane() {
		Assert.assertFalse(loginService.login("ousmane", "cahierdeTexte"));
	}

	@Test
	public void testLoginArmel() {
		Assert.assertFalse(loginService.login("armel", "mahara"));
	}

}
