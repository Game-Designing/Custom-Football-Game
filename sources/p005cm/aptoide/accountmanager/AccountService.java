package p005cm.aptoide.accountmanager;

import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.accountmanager.AccountService */
public interface AccountService {
    C0117M changeBirthdate(String str);

    C0117M changeSubscribeNewsletter(String str);

    Single<Account> createAccount(String str, String str2);

    Single<Account> createAccount(String str, String str2, String str3, String str4);

    Single<Account> getAccount();

    Single<Account> getAccount(String str, String str2);

    C0117M removeAccount();

    C0117M subscribeStore(String str, String str2, String str3);

    C0117M unsubscribeStore(String str, String str2, String str3);

    C0117M updateAccount(String str);

    C0117M updateAccount(String str, String str2);

    C0117M updateAccount(boolean z);

    C0117M updateAccountUsername(String str);

    C0117M updateTermsAndConditions();
}
