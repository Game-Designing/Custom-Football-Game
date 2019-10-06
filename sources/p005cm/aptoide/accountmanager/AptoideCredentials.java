package p005cm.aptoide.accountmanager;

/* renamed from: cm.aptoide.accountmanager.AptoideCredentials */
public class AptoideCredentials {
    private final String email;
    private final boolean isChecked;
    private final String password;

    public AptoideCredentials(String email2, String password2, boolean isChecked2) {
        this.email = email2;
        this.password = password2;
        this.isChecked = isChecked2;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isChecked() {
        return this.isChecked;
    }
}
