package p005cm.aptoide.accountmanager;

import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.accountmanager.AccountPersistence */
public interface AccountPersistence {
    Single<Account> getAccount();

    C0117M removeAccount();

    C0117M saveAccount(Account account);
}
