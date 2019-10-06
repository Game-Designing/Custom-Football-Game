package p005cm.aptoide.accountmanager;

import java.net.SocketTimeoutException;
import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.accountmanager.AptoideSignUpAdapter */
public class AptoideSignUpAdapter implements SignUpAdapter<AptoideCredentials> {
    private final CredentialsValidator credentialsValidator;

    public AptoideSignUpAdapter(CredentialsValidator credentialsValidator2) {
        this.credentialsValidator = credentialsValidator2;
    }

    public Single<Account> signUp(AptoideCredentials credentials, AccountService service) {
        return this.credentialsValidator.validate(credentials, true).mo3587a(service.createAccount(credentials.getEmail(), credentials.getPassword())).mo3699e(new C1336s(service, credentials));
    }

    /* renamed from: a */
    static /* synthetic */ Single m6125a(AccountService service, AptoideCredentials credentials, Throwable throwable) {
        if (throwable instanceof SocketTimeoutException) {
            return service.getAccount(credentials.getEmail(), credentials.getPassword());
        }
        return Single.m735a(throwable);
    }

    public C0117M logout() {
        return C0117M.m590b();
    }

    public boolean isEnabled() {
        return true;
    }
}
