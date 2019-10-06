package p005cm.aptoide.accountmanager;

import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.accountmanager.SignUpAdapter */
public interface SignUpAdapter<T> {
    boolean isEnabled();

    C0117M logout();

    Single<Account> signUp(T t, AccountService accountService);
}
