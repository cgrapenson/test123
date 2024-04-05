package maven.test123;

public class LoginStatus {
    private static LoginStatus instance;
    private boolean loginSuccessful;

    private LoginStatus() {}

    public static LoginStatus getInstance() {
        if (instance == null) {
            instance = new LoginStatus();
        }
        return instance;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        this.loginSuccessful = loginSuccessful;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

}
