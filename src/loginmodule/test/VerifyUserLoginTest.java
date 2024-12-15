package loginmodule.test;
import loginmodule.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class VerifyUserLoginTest {
    private VerifyUserLogin verifyUserLogin;

    @Before
    public void setUp() throws Exception {
        // Mocking the ReadCredentialsFile and its method getCredentialsList for testing
        ReadCredentialsFile reader = new ReadCredentialsFile() {
            @Override
            public ArrayList<String> getCredentialsList() {
                ArrayList<String> mockList = new ArrayList<>();
                mockList.add("user1,password1");
                mockList.add("user2,password2");
                return mockList;
            }
        };
        verifyUserLogin = new VerifyUserLogin();
    }

    @Test
    public void testVerifyUserLoginCredentials_Failure() {
        assertFalse(verifyUserLogin.verifyUserLoginCredentials("user1", "wrongpassword"));
        assertFalse(verifyUserLogin.verifyUserLoginCredentials("nonexistentuser", "password"));
    }
}
